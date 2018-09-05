/*create table customer (cust_id varchar(20) primary key, first_name varchar(20), last_name varchar(20), contact varchar(10), email varchar(20), address varchar(50));

create table orders (order_id varchar(20), cust_id varchar(20), date_order_placed date, date_order_paid date, total_price float);*/

/*line items*/

/*create table lineitems (line_item_id varchar(20), order_id varchar(20), product_id varchar(20), quantity int, total_price float);*/

/*product*/

create table product (product_id varchar(20), name varchar(20), cost float, discount float);
