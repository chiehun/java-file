CREATE TABLE product(
    code NUMBER(5),
    name VARCHAR2(100),
    price NUMBER(8),
    pictureurl VARCHAR2(50),
    description VARCHAR2(1000),
    PRIMARY KEY(code)
);

CREATE SEQUENCE product_seq
    START WITH 1
    INCREMENT BY 1;
    
INSERT INTO product VALUES
(product_seq.NEXTVAL, '개념을 콕콕 잡아주는 데이터베이스', 27000, 'db.jpg', '데이터베이스에 관한 모든 것을 쉽고 재미있게 정리한 교재...');

SELECT * FROM product;

commit;
