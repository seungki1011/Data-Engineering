package hello.itemservice.repository;

import hello.itemservice.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * NamedParameterJdbcTemplate
 */
@Slf4j
@Repository
public class JdbcTemplateItemRepositoryV2 implements ItemRepository{

    /**
     * NamedParameterJdbcTemplate를 사용하도록 변경
     * NamedParameterJdbcTemplate도 내부에 dataSource 필요
     * DI로 dataSource를 받고 내부에서 NamedParameterJdbcTemplate을 생성해서 가진다
     * JdbcTemplate을 사용할 때 관례상 이 방법을 많이 사용
     */
    private final NamedParameterJdbcTemplate template;

    public JdbcTemplateItemRepositoryV2(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * 1. BeanPropertySqlParameterSource
     * 자바빈 프로퍼티 규약을 통해서 자동으로 파라미터 객체 생성
     * 예) getXxx() -> xxx
     * 예) getItemName() -> itemName
     * BeanPropertySqlParameterSource가 많은 것을 자동화 해줘서 좋아보이지만, 모든 상황에서 사용할 수 있는 것은 아님
     * 한계를 아래의 update()에서 설명
     */
    @Override
    public Item save(Item item) {
        /**
         * SQL에서 ? 대신 :itemName 처럼 :파라미터이름 형식으로 받고 있음
         */
        String sql = "insert into item(item_name, price, quantity) " +
                "values (:itemName, :price, :quantity)";

        // 방법1 : BeanPropertySqlParameterSource 사용
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(item);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, param, keyHolder);

        long key = keyHolder.getKey().longValue();
        item.setId(key);

        return item;
    }

    /**
     * 2. MapSqlParameterSource
     * Map과 유사
     * SQL 타입을 지정할 수 있는 등, SQL에 특화된 기능 제공
     * 메서드 체이닝 제공
     * update()에서 SQL에 :id를 바인딩 해야 하는데, ItemUpdateDto에는 itemId가 없다
     * 따라서 MapSqlParameterSource을 사용해야 함
     */
    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        String sql = "update item " +
                "set item_name=:itemName, price=:price, quantity=:quantity " +
                "where id=:id";

        // 방법 2 : MapSqlParameterSource 사용
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("itemValue", updateParam.getItemName())
                .addValue("price", updateParam.getPrice())
                .addValue("quantity", updateParam.getQuantity())
                .addValue("id", itemId);

        template.update(sql, param);
    }

    /**
     * 3. Map
     * 단순히 Map을 사용한다
     */
    @Override
    public Optional<Item> findById(Long id) {
        String sql = "select id, item_name, price, quantity from item where id = :id";

        try {
            // 방법 3 : Map 사용
            Map<String, Object> param = Map.of("id", id);
            Item item = template.queryForObject(sql, param, itemRowMapper());

            return Optional.of(item);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * BeanPropertyRowMapper는 ResultSet의 결과를 받아서 자바빈 규약에 맞추어 데이터를 변환해줌
     * 예) select id, price를 통해 조회하면 다음과 같은 코드를 리플렉션을 통해 작성해줌
     * 예) Item item = new Item();
     *    item.setId(rs.getLong("id"));
     *    item.setPrice(rs.getInt("price"));
     *
     * 만약 select item_name 이면 setItem_name()이 없기 때문에 이 경우에는 다음과 같이 고치면 된다
     * select item_name as itemName
     * as를 통해서 별칭을 사용하면 됨
     */
    private RowMapper<Item> itemRowMapper() {
        return BeanPropertyRowMapper.newInstance(Item.class);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        SqlParameterSource param = new BeanPropertySqlParameterSource(cond);

        String sql = "select id, item_name, price, quantity from item";

        // 동적 쿼리 작성
        if (StringUtils.hasText(itemName) || maxPrice != null) {
            sql += " where";
        }

        boolean andFlag = false;

        if (StringUtils.hasText(itemName)) {
            sql += " item_name like concat('%',:itemName,'%')";
            andFlag = true;
        }

        if (maxPrice != null) {
            if (andFlag) {
                sql += " and";
            }
            sql += " price <= :maxPrice";
        }

        log.info("sql={}", sql);
        return template.query(sql, param, itemRowMapper());
    }
}
