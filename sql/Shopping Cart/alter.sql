/*alter table orders add constraint fk_customer_id foreign key (cust_id) references customer(cust_id);*/

/*alter table orders add primary key (order_id);*/
/*alter table lineitems add primary key (line_item_id);*/
/*alter table lineitems add constraint fk_order_id foreign key (order_id) references orders(order_id); */

/*alter table product add primary key (product_id);*/

alter table lineitems add constraint fk_product_id foreign key (product_id) references product(product_id);
