create table category (categoryid bigint not null auto_increment, type varchar(255), primary key (categoryid))
create table item (itemid bigint not null auto_increment, description varchar(255), price double precision, status varchar(255), title varchar(255), zipcode integer, categoryid bigint, userid bigint, primary key (itemid))
create table user (userid bigint not null auto_increment, email varchar(50), firstname varchar(30), lastname varchar(30), password varchar(255) not null, role varchar(255) not null, username varchar(255) not null, primary key (userid))
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table item add constraint FKrr3uj06scs7dswxs7vtv5gyso foreign key (categoryid) references category (categoryid)
alter table item add constraint FKnhr2sfmswb0vcj96as81hn5fm foreign key (userid) references user (userid)
