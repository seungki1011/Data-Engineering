DROP TABLE IF EXISTS item;
CREATE TABLE item
(
    id BIGINT AUTO_INCREMENT,
    item_name VARCHAR(20),
    price INT,
    quantity INT,
    PRIMARY KEY (id)
);
