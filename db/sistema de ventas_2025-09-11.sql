CREATE TABLE `tbl_user` (
	`id` BIGINT NOT NULL UNIQUE,
	`first_name` VARCHAR(255),
	`last_name` VARCHAR(255),
	`email` VARCHAR(255),
	`password` VARCHAR(255),
	`role` VARCHAR(255),
	PRIMARY KEY(`id`)
);


CREATE TABLE `tbl_category` (
	`id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	`name` VARCHAR(255),
	`description` VARCHAR(255),
	`isActive` BOOLEAN,
	PRIMARY KEY(`id`)
);


CREATE TABLE `tbl_product` (
	`id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	`name` VARCHAR(255),
	`description` VARCHAR(255),
	`price` DECIMAL,
	`stock` BIGINT,
	`isActive` BOOLEAN,
	`category_id` BIGINT,
	PRIMARY KEY(`id`)
);


CREATE TABLE `tbl_client` (
	`id` BIGINT NOT NULL UNIQUE,
	`first_name` VARCHAR(255),
	`last_name` VARCHAR(255),
	`email` VARCHAR(255),
	`adress` VARCHAR(255),
	`isActive` BOOLEAN,
	PRIMARY KEY(`id`)
);


CREATE TABLE `tbl_sale` (
	`id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	`date_time` DATETIME,
	`total` DECIMAL,
	`payment_method` VARCHAR(255),
	`client_id` BIGINT,
	PRIMARY KEY(`id`)
);


CREATE TABLE `tbl_sale_detail` (
	`id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
	`product_id` BIGINT,
	`amount` BIGINT,
	`unit_price` DECIMAL,
	`subtotal` DECIMAL,
	`sale_id` BIGINT,
	PRIMARY KEY(`id`)
);


ALTER TABLE `tbl_product`
ADD FOREIGN KEY(`category_id`) REFERENCES `tbl_category`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `tbl_sale`
ADD FOREIGN KEY(`client_id`) REFERENCES `tbl_client`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `tbl_sale_detail`
ADD FOREIGN KEY(`sale_id`) REFERENCES `tbl_sale`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `tbl_sale_detail`
ADD FOREIGN KEY(`product_id`) REFERENCES `tbl_product`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;