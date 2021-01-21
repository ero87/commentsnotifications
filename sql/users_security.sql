create database comment_notification;

use comment_notification;

drop table comment;
create table comment(
    comment_id integer primary key auto_increment,
    comment varchar(264) not null,
    time time not null
);

drop table notification;
create table notification(
    notification_id integer primary key auto_increment,
    comment_id integer not null,
    time time,
    delivered boolean,
    FOREIGN KEY (comment_id) REFERENCES comment(comment_id)
);