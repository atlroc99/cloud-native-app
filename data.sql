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

-- create table category
-- auto-generated definition
create table product
(
    ID          varchar(45) not null,
    name        varchar(30) not null,
    description varchar(25) null,
    price       decimal     null,
    category_id int         not null,
    constraint ID
        unique (ID),
    constraint FK_CATEGORY_ID
        foreign key (category_id) references category (ID)
);

alter table product
    add primary key (ID);


-- add category_id as foreign key to product table
alter table product add category_id int not null ;
alter table product add constraint FK_CATEGORY_ID FOREIGN KEY (category_id) references category(ID);


