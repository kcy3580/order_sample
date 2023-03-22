create database `order`;
create user `order` identified by 'local';
grant all privileges on `order`.* to `order`;
grant super on *.* to `order`;