CREATE TABLE coupon
( ID VARCHAR(45) NOT NULL UNIQUE,
  code VARCHAR(30) NOT NULL,
  discount decimal,
  expiration_date date,
  CONSTRAINT coupon_pk PRIMARY KEY (ID));


CREATE TABLE product
( ID VARCHAR(45) NOT NULL UNIQUE,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(25),
  price decimal,
  CONSTRAINT product_pk PRIMARY KEY (ID)
);