package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    /**
     * GET LIST USERS API 조회
     * GET은 해당하는 데이터를 가져옴
     * @Query는 retrofit 라이브러리에서 쿼리스티링을 입력하는 방법
     * API 위치는 /api/users
     * 전달하는 파라미터는 page=2
     * https://reqres.in/api/users?page=2 -> ?는 Query String을 작성하겠다는 것
     * 쿼리스트링은 API에 조회할 때 조건으로 줄 인자를 입력하는 방법
     */
    @GET("/api/users")
    Call<Object> retrofitTest(@Query("page") int page);
}
