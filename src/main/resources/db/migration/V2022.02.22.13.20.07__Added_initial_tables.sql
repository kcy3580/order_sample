use `order`;

create table orders (
    ord_id                      bigint unsigned auto_increment not null comment '주문ID',
    ord_no                      varchar(20)                    not null comment '주문번호',
    cust_id                     varchar(20)                    not null comment '고객ID',
    cust_nm                     varchar(20)                    not null comment '고객명',
    cust_cpno                   varchar(2000)                           comment '고객휴대전화번호',
    ord_st_code                 varchar(2)                              comment '주문상태코드',
    crt_dtm                     datetime                       not null comment '생성일시',
    chn_dtm                     datetime                       not null comment '수정일시',
    primary key (ord_id)
)
comment '주문';
