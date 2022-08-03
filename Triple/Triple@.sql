create sequence auto_increment
    increment by 1
    start with 1;

create table users(
    idx number(7) primary key,
    email varchar2(30) not null,
    userpw varchar2(20) not null,
    nickname varchar2(20) not null,
    country_code varchar2(4) not null,
    hp varchar2(13) not null,
    zipcode number(6),
    address1 varchar2(30),
    address2 varchar2(20),
    address3 varchar2(20),
    reg_date date default sysdate,
    status varchar2(10) not null,
    tos_agree varchar2(10) not null
);

create sequence seq_users
    increment by 1
    start with 1;
    
select * from air_ticket;
create table terms(
    idx number(7) primary key,
    terms_name varchar2(30) not null,
    reg_date date default sysdate,
    content varchar2(300) not null,
    if_required varchar2(2) not null,
    if_use varchar2(2) not null
);

create sequence seq_terms
    increment by 1
    start with 1;
    

create table airport(
    idx number(7)  primary key,
    airport_num varchar2(10) not null,
    airport_name varchar2(20) not null,
    airport_code varchar2(10) not null,
    country varchar2(20) not null,
    city varchar2(20) not null  
);

create sequence seq_airport
    increment by 1
    start with 1;
    

create table airline(
    idx number(7) primary key,
    airline_num number(7) not null,
    kr_name varchar2(20) not null,
    en_name varchar2(20) not null,
    airline_code varchar2(10) not null,
    address varchar2(30) not null,
    contact_num1 varchar2(20) not null,
    contact_num2 varchar2(20)
);

create sequence seq_airline
    increment by 1
    start with 1;
    

insert into air_ticket values(
    4,
    'AIR_TICKET',
    'ARI004',
    4444,
    6666,
    'ICN',
    'SIN',
    '2022-07-27 16:00',
    '2022-07-27 18:30',
    230000,
    'K597',
    'FIRST',
    'Y',
    sysdate,
    'AVAILABLE'
);
commit;
select * from air_ticket;

create table aircraft(
    idx number(7) primary key,
    aircraft_num number(7) not null,
    aircraft_name varchar2(20) not null,
    made_by varchar2(20) not null,
    aircraft_capacity number(4) not null,
    normal_seat number(3) not null,
    economy_seat number(3) not null,
    special_seat number(3) not null,
    family_seat number(3) not null,
    vip_seat number(3) not null,
    airline_id number(7) not null
);
insert into airline;

select * from reservation;

create sequence seq_aircraft
    increment by 1
    start with 1;
drop table air_ticket;    
select * from air_ticket; 
insert into air_ticket values(
    1,
    'AIR_TICKET',
    'JINAIR_J',
    
    
);
drop table admin_user;
insert into admin_user values(1, 'apple123', 'apple123!', '����', '010-1111-1111', '������', 'apple@naver.com', 'ceo', 'REGISTERED', sysdate);    
select * from admin_user;
commit;
create table air_ticket(
    idx number(7) primary key,
    ticket_type varchar2(10),
    ticket_num varchar2(10),
    airline_idx number(7) not null,
    aircraft_idx number(7) not null,
    departure_airport varchar2(20) not null,
    landing_airport varchar2(20) not null,
    departure_date date not null,
    landing_date date not null,
    price number(8) not null,
    seat_num varchar2(10) not null,
    seat_grade varchar2(10) not null,
    baggage varchar2(10) not null,
    rev_date date,
    status varchar2(10) not null
);

create sequence seq_air_ticket
    increment by 1
    start with 1;

select * from users;
select * from reservation;
drop table reservation_airuse;

create table reservation_airuse(
    idx number(7) primary key,
    email number(7) not null,
    ticket_type varchar2(10) not null,
    ticket_num number(7) not null,
    eng_lastname number(7) not null,
    eng_firstname varchar2(20) not null,
    birth varchar2(20) not null,
    gender varchar2(20) not null,
    use_hp varchar2(20) not null,
    nationality varchar2(20) not null,
    passport_num varchar2(20) not null,
    passport_exp varchar2(10) not null,
    passport_country varchar2(20) not null,
    info_agree varchar2(10) not null,
    reg_date date default sysdate
);

create sequence seq_reservation_airuse
    increment by 1
    start with 1;
    

create table lodging(
    idx number(7) primary key,
    type varchar2(10) unique not null,
    company_num varchar2(10) not null,
    lodging_type varchar2(10) not null,
    company_name varchar2(10) not null,
    introducing varchar2(300) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    address varchar2(30) not null,
    contact_hp varchar2(20) not null,
    representative varchar2(20) not null,
    email varchar2(30) not null,
    like_num number(5) default 0
);

create sequence seq_lodging
    increment by 1
    start with 1;
    

create table lodging_room(
    idx number(7) primary key,
    room_num varchar2(10) not null,
    room_type varchar2(20) not null,
    rev_status varchar2(2) not null,
    check_in date not null,
    check_out date not null,
    width varchar2(30) not null,
    room_capacity number(2) not null,
    room_policy varchar2(30) not null,
    price number(8) not null,
    lodging_id number(7) not null,
    use_date date,
    status varchar2(10)
);

create sequence seq_lodging_room
    increment by 1
    start with 1;
    

create table lodging_ticket(
    idx number(7) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    room_num varchar2(10) not null,
    rev_name varchar2(10) not null,
    rev_hp varchar2(10) not null,
    rev_email varchar2(10) not null,
    use_eng_lastname varchar2(20) not null,
    use_eng_firstname varchar2(20) not null,
    use_birth varchar2(20) not null,
    use_requests varchar2(100),
    info_agree varchar2(10) not null,
    reg_date date default sysdate	
);

create sequence seq_lodging_ticket
    increment by 1
    start with 1;
    

create table tour( 
    idx number(7) primary key,
    type varchar2(10) unique not null,
    tour_num varchar2(10) not null,
    country varchar2(10) not null,
    address varchar2(30) not null,
    manager_name varchar2(20) not null,
    contact_num varchar2(20) not null,
    title varchar2(50) not null,
    info varchar2(300) not null,
    status varchar2(10) not null,
    price number(8) not null,
    time_taken varchar2(20) not null,
    start_date date not null,
    end_date date not null,
    like_num number(5) default 0,
    remaining number(5) not null
);

create sequence seq_tour
    increment by 1
    start with 1;
    

create table tour_ticket(
    idx number(7) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    rev_name varchar2(10) not null,
    rev_hp varchar2(10) not null,
    rev_email varchar2(20) not null,
    repre_hp varchar2(20) not null,
    repre_lastname varchar2(20) not null,
    repre_firstname varchar2(20) not null,
    repre_birth varchar2(100) not null,
    kakaoid varchar2(20) not null,
    lodging_name varchar2(30),
    use_lastname varchar2(20) not null,
    use_firstname varchar2(20) not null,
    reg_date date default sysdate
);

create sequence seq_tour_ticket
    increment by 1
    start with 1;
    
insert into reservation values(
    1,
    'AIR_TICKET',
    'AIR001',
    '',
    'apple@apple.com',
    '010-1111-1111',
    '010-2222-2222'
);
drop table reservation;
select * from users;
create table reservation(
    idx number(10) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    rev_name varchar2(20) not null,
    email varchar2(30) not null,
    hp varchar2(20) not null,
    emergency_hp varchar2(20) not null
);

create sequence seq_reservation
    increment by 1
    start with 1;
    

create table review(
    idx number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    star_count varchar2(20) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    like_count number(5) default 0,
    reg_date date default sysdate,
    ticket_num varchar2(10) not null
);

create sequence seq_review
    increment by 1
    start with 1;
    

create table review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    like_count number(5),
    reg_date date default sysdate
);

create sequence seq_review_reply
    increment by 1
    start with 1;
select * from admin_user;
drop table magazine;
select * from magazine;
create table magazine(
    idx number(7) primary key,
    adminuser_id varchar2(20) not null,
    adminuser_name varchar2(20) not null,
    magazine_type varchar2(20) not null,
    title varchar2(100) not null,
    summary varchar2(100) not null,
    tag varchar2(50) not null,
    content varchar2(500) not null,
    upload_path varchar2(200),
    file_name varchar2(200),
    reg_date date default sysdate
);

create sequence seq_magazine
    increment by 1
    start with 1;
    

create table adminuser(
    idx number(7) primary key,
    admin_id varchar2(20) unique not null,
    admin_pw varchar2(20) not null,
    admin_name number(7) not null,
    reg_date date default sysdate
);

create sequence seq_adminuser
    increment by 1
    start with 1;
 
 select * from package;
 create table PACKAGE(
    idx number(7) primary key,
    country varchar2(20) not null,
    title varchar2(20) not null,
    upload_path varchar2(200) not null,
    file_name varchar2(200) not null,
    keyword varchar2(20) not null,
    adult_pr number(10) not null,
    kid_pr number(10) not null,
    infant_pr number(10) not null,
    adult_infant_pr number(10) not null,
    program varchar2(400) not null,
    contained varchar2(400) not null,
    not_contained varchar2(400) not null
    reg_date date default sysdate  
);

create sequence seq_package
    increment by 1
    start with 1;   

create table spot(
    idx number(7) primary key,
    type varchar2(10) unique not null,
    spot_num number(7) unique not null,
    spot_name varchar2(20) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    hp varchar2(20) not null,
    title varchar2(30) not null,
    content varchar2(500) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    operation_status varchar2(4),
    reg_date date default sysdate,
    like_count number(7) default 0,
    review_count number(7) default 0
);

create sequence seq_spot
    increment by 1
    start with 1;
    

create table spot_review(
    idx number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    like_count number(5),
    reply_count number(5) default 0,
    reg_date date default sysdate,
    star_count varchar2(20) not null
);

create sequence seq_spot_review
    increment by 1
    start with 1;
    

create table tourspot_review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create sequence seq_tourspot_review_reply
    increment by 1
    start with 1;
    
drop table restaurant;

create table restaurant(
    idx number(7) primary key,
    location varchar2(200) not null,
    title varchar2(50) not null,
    summary varchar2(50) not null,
    menu1_name varchar2(30) not null,
    menu1_description varchar2(100) not null,
    menu1_price number(7) not null,
    menu2_name varchar2(30) not null,
    menu2_description varchar2(100) not null,
    menu2_price number(7) not null,
    menu3_name varchar2(30) not null,
    menu3_description varchar2(100) not null,
    menu3_price number(7) not null,
    how_to_go varchar2(200),
    available_at varchar2(200),
    tip varchar2(200),
    etc varchar2(200),
    upload_path1 varchar2(200),
    file_name1 varchar2(200),
    upload_path2 varchar2(200),
    file_name2 varchar2(200),
    upload_path3 varchar2(200),
    file_name3 varchar2(200),
    upload_path4 varchar2(200),
    file_name4 varchar2(200),
    reg_date date default sysdate,
    like_count number(7) default 0,
    review_count number(7) default 0
);

create sequence seq_restaurant
    increment by 1
    start with 1;
    

create table restaurant_review(
    idx number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    like_count number(5) default 0,
    reply_count number(5),
    reg_date date default sysdate,
    star_count varchar2(20) not null
);

create sequence seq_restaurant_review
    increment by 1
    start with 1;
    

create table restaurant_review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create sequence seq_restaurant_review_reply
    increment by 1
    start with 1;
    

create table coupon(
    idx number(7) primary key,
    coupon_id number(7) not null,
    name varchar2(20) not null,
    type varchar2(20) not null,
    price number(10) not null,
    use_condition varchar2(20) not null,
    use_status varchar2(30) not null,
    code varchar2(500) not null,
    start_date date,
    end_date date,
    coupon_use varchar2(30)
);

create sequence seq_coupon
    increment by 1
    start with 1;
    

create table user_coupon(
    idx number(7) primary key,
    user_id number(7) not null,
    coupon_id number(7),
    reg_date date default sysdate
);

create sequence seq_user_coupon
    increment by 1
    start with 1;
    
select * from guide;
drop table guide;
create table guide(
    idx number(7) primary key,
    type varchar2(20) unique not null,
    guide_num number(7) not null,
    adminuser_id number(7) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(50) not null,
    content varchar2(500),
    upload_path varchar2(200),
    file_name varchar2(200),
    file_type varchar2(10),
    reg_date date default sysdate,
    review_count number(7) default 0
);

create sequence seq_guide
    increment by 1
    start with 1;
    

create table guide_review(
    idx number(7) primary key,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    reg_date date default sysdate,
    like_count number(5) default 0,
    reply_count number(5)
);

create sequence seq_guide_review
    increment by 1
    start with 1;
    

create table guide_review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create sequence seq_guide_review_reply
    increment by 1
    start with 1;
    

create table question(
    idx number(7) primary key,
    inquiry_id number(7) not null,
    ticket_num number(7) not null,
    user_id number(7) not null,
    type_category varchar2(20) not null,
    type_detail varchar2(20) not null,
    title varchar2(30) not null,
    content varchar2(300) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    info_agree varchar2(10) not null,
    reg_date date default sysdate
);

create sequence seq_question
    increment by 1
    start with 1;
    

create table answer(
    idx number(7) primary key,
    answer_num number(7) not null,
    inquiry_id number(7) not null,
    adminuser_id number(7) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(20) not null,
    content varchar2(300) not null,
    reg_date date default sysdate
);

create sequence seq_answer
    increment by 1
    start with 1;
    

create table tripler(
    idx number(7) primary key,
    tripler_num number(7) not null,
    user_id number(7) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    nickname	 varchar2(20) not null,
    title varchar2(30) not null,
    content	varchar2(500),
    uploadPath varchar2(200),
    fileName	varchar2(200),
    fileType	varchar2(10),
    reg_date	date default sysdate,
    like_count number(5) default 0,	
    reply_count number(5)
);

create sequence seq_tripler
    increment by 1
    start with 1;
    

create table tripler_reply(
    idx number(7) primary key,
    reply_num number(7)	not null,
    tripler_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id number(7) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create sequence seq_tripler_reply
    increment by 1
    start with 1;
    

create table mysave(
    idx number(7) primary key,
    user_id number(7) not null,
    item_num number(7) not null,
    save_yn varchar2(10) not null,
    memo varchar2(100),
    save_type varchar2(10) not null,
    reg_date date default sysdate
);

create sequence seq_mysave
    increment by 1
    start with 1;
    

create table notice(
    idx number(7),
    notice_num number(7) not null,
    adminuser_id number(7) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(30) not null,
    content varchar2(500) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(20),
    reg_date date default sysdate
);

create sequence seq_notice
    increment by 1
    start with 1;
    

create table faq(
    idx number(7),
    faq_num number(7) not null,
    faq_category varchar2(20) not null,
    adminuser_id number(7) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(30) not null,
    content varchar2(500) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(20),
    reg_date date default sysdate
);

create sequence seq_faq
    increment by 1
    start with 1;








