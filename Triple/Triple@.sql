create sequence auto_increment
    increment by 1
    start with 1;

drop table users;


select * from users;

create table users(
    idx number(7) primary key,
    email varchar2(30) not null,
    userpw varchar2(20) not null,
    nickname varchar2(50) not null,
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

 
drop table airport;
 
select * from airport;

create table airport(
    idx number(7)  primary key,
    airport_name varchar2(50) not null,
    country varchar2(50) not null,
    city varchar2(50) not null  
);

create sequence seq_airport
    increment by 1
    start with 1;


select * from airline;

create table airline(
    idx number(7) primary key,
    kr_name varchar2(20) not null,
    en_name varchar2(20) not null,
    route varchar2(20) not null,
    rep_num varchar2(20) not null,
    support_num varchar2(20) not null,
    upload_path varchar2(200) not null,
    file_name varchar2(200) not null
);

create sequence seq_airline
    increment by 1
    start with 1;
    


drop table aircraft;
select * from aircraft;

create table aircraft(
    idx number(7) primary key,
    aircraft_name varchar2(50) not null,
    made_by varchar2(50) not null,
    aircraft_capacity number(4) not null,
    premium_seat number(4) not null,
    first_seat number(4) not null,
    business_seat number(4) not null,
    economy_seat number(4) not null,
    airline_name varchar2(50) not null
);

create sequence seq_aircraft
    increment by 1
    start with 1;


insert into admin_user values(1, 'apple123', 'apple123!', '����', '010-1111-1111', '������', 'apple@naver.com', 'ceo', 'REGISTERED', sysdate);

insert into admin_user values(1, 'apple123', 'apple123!', '����', '010-1111-1111', '������', 'apple@naver.com', 'ceo', 'REGISTERED', sysdate);
select * from admin_user;


select * from air_ticket where departure_airport='?ÎÃµ°øÇ×' and landing_airport='³ª¸®Å¸°øÇ×' and departure_time like '%2022-08-07%';
delete from air_ticket where idx=26;
drop table air_ticket;


select * from air_ticket;

create table air_ticket(
    idx number(7) primary key,
    air_route varchar2(10) not null,
    departure_airport varchar2(50) not null,
    landing_airport varchar2(50) not null,
    departure_time varchar2(50) not null,
    landing_time varchar2(50) not null,
    flight_time varchar2(50) not null,
    airline_name varchar2(50) not null,
    aircraft_name varchar2(50) not null,
    baggage varchar2(10) not null,
    economy_adult_price number(7) not null,
    economy_child_price number(7) not null,
    economy_infant_price number(7) not null,
    premium_adult_price number(7) not null,
    premium_child_price number(7) not null,
    premium_infant_price number(7) not null,
    business_adult_price number(7) not null,
    business_child_price number(7) not null,
    business_infant_price number(7) not null,
    first_adult_price number(7) not null,
    first_child_price number(7) not null,
    first_infant_price number(7) not null,
    premium_seat_count number(4) not null,
    first_seat_count number(4) not null,
    business_seat_count number(4) not null,
    economy_seat_count number(4) not null,
    reg_date date default sysdate
);

create sequence seq_air_ticket
    increment by 1
    start with 1;


drop table round_ticket_reservation;


select * from round_ticket_reservation;

create table round_ticket_reservation(
    idx number(7) primary key,
    email varchar2(50) not null,
    departure_ticket_id number(7) not null,
    comeback_ticket_id number(7) not null,
    age_type varchar2(20) not null,
    seat_class varchar2(30) not null,
    eng_lastname varchar2(50) not null,
    eng_firstname varchar2(50) not null,
    birth varchar2(20) not null,
    gender varchar2(20) not null,
    use_hp varchar2(20),
    nationality varchar2(20) not null,
    passport_num varchar2(20) not null,
    passport_exp varchar2(20) not null,
    passport_country varchar2(20) not null,
    passenger_name varchar2(30) not null,
    reg_date date default sysdate
);

create sequence seq_round_ticket_reservation
    increment by 1
    start with 1;
    
  
drop table oneway_reservation;


select * from oneway_reservation;

create table oneway_reservation(
    idx number(7) primary key,
    email varchar2(50) not null,
    departure_ticket_id number(7) not null,
    age_type varchar2(20) not null,
    seat_class varchar2(30) not null,
    eng_lastname varchar2(50) not null,
    eng_firstname varchar2(50) not null,
    birth varchar2(20) not null,
    gender varchar2(20) not null,
    use_hp varchar2(20),
    nationality varchar2(20) not null,
    passport_num varchar2(20) not null,
    passport_exp varchar2(20) not null,
    passport_country varchar2(20) not null,
    passenger_name varchar2(30) not null,
    reg_date date default sysdate
);

create sequence seq_oneway_reservation
    increment by 1
    start with 1;
    
delete lodging;
commit;
drop table lodging;
commit;
select * from lodging;
create table lodging(
    idx number(7) primary key,
    type varchar2(50) not null,
    rank number(3) not null,
    country varchar2(50) not null,
    city varchar2(100) not null,
    name varchar2(200) not null,
    upload_path varchar2(500) not null,
    file_name varchar2(500) not null,
    info varchar2(2000) not null,
    introducing varchar2(2000) not null,
    address varchar2(1000) not null,
    check_in varchar2(50) not null,
    check_out varchar2(50) not null,
    policy varchar2(1000) not null,
    cf varchar2(2000) not null,
    more_info varchar2(2000) not null,
    total_star number(7) default 0,
    star_count number(3,1) default 0,
    review_count number(7) default 0,
    cheapest_price number(7) default 0
);

create sequence seq_lodging
    increment by 1
    start with 1;
    

drop table lodging_room;
select * from lodging_room;
create table lodging_room(
    idx number(7) primary key,
    company_id number(7) not null,
    name varchar2(100) not null,
    room_num varchar2(100) not null,
    upload_path varchar2(200) not null,
    file_name varchar2(200) not null,
    room_capacity varchar2(100) not null,
    smoking varchar2(100) not null,
    room_view varchar2(20) not null,
    width varchar2(30) not null,
    bed varchar2(20) not null,
    introducing varchar2(2000) not null,
    price number(7) not null,
    like_count number(7) default 0,

    status varchar2(50)
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
    reg_date date default sysdate,
    user_id number(7) not null,
    guest_num number(7) not null,
    transportation varchar2(50)
);

create sequence seq_lodging_ticket
    increment by 1
    start with 1;

drop table tour;


create table tour( 
    idx number(7) primary key,
    type varchar2(10) unique not null,
    tour_num varchar2(10) not null,
    country varchar2(10) not null,
    address varchar2(30) not null,
    manager_name varchar2(30) not null,
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
 table reservation;

select * from users;

create table reservation(
    idx number(10) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    rev_name varchar2(20) not null,
    email varchar2(30) not null,
    hp varchar2(20) not null,
    emergency_hp varchar2(20) not null,
    user_id number(7) not null,
    title varchar2(30) not null,
    content varchar2(30) not null,
    rev_date date default sysdate,
    service_life varchar2(10) not null
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


create table admin_user(
    idx number(7) primary key,
    userid varchar2(20) not null,
    userpw varchar2(20) not null,
    name varchar2(20) not null,
    hp varchar2(20) not null,
    department varchar2(20) not null,
    email varchar2(20) not null,
    position varchar2(20) not null,
    status varchar2(10) not null,
    reg_date date default sysdate
);

create sequence seq_adminuser
    increment by 1
    start with 1;
 
 drop table PACKAGE;

 select * from package;
 select * from round_ticket_reservation;
 create table PACKAGE(
    idx number(7) primary key,
    country varchar2(40) not null,
    title varchar2(200) not null,
    upload_path varchar2(200) not null,
    file_name varchar2(200) not null,
    keyword varchar2(60) not null,
    adult_pr number(10) not null,
    kid_pr number(10) not null,
    infant_pr number(10) not null,
    adult_infant_pr number(10) not null,
    program varchar2(1000) not null,
    contained varchar2(400) not null,
    not_contained varchar2(400) not null,
    contained varchar2(1000) not null,
    not_contained varchar2(1000) not null,
    adminuser_id varchar2(40) not null,
    adminuser_name varchar2(40) not null,
    reg_date date default sysdate  
);

create sequence seq_package
    increment by 1
    start with 1;   


drop table spot;

select * from spot;

create table spot(
    idx number(7) primary key,
    country varchar2(30) not null,
    city varchar2(30) not null,
    place_name varchar2(100) not null,
    title varchar2(100) not null,
    upload_path1 varchar2(200) not null,
    file_name1 varchar2(200) not null,
    subtitle1 varchar2(200) not null,
    content1 varchar2(1000) not null,
    upload_path2 varchar2(200) not null,
    file_name2 varchar2(200) not null,
    subtitle2 varchar2(200) not null,
    content2 varchar2(1000) not null,
    upload_path3 varchar2(200) not null,
    file_name3 varchar2(200) not null,
    thing1 varchar2(100),
    summary1 varchar2(1000),
    upload_path4 varchar2(200),
    file_name4 varchar2(200),
    thing2 varchar2(100),
    summary2 varchar2(100),
    upload_path5 varchar2(200),
    file_name5 varchar2(200),
    thing3 varchar2(100),
    summary3 varchar2(100),
    recommend_time varchar2(100),
    road varchar2(200) not null,
    available_at varchar2(200) not null,
    price varchar2(200),
    using varchar2(500) not null,
    reg_date date default sysdate,
    like_count number(7) default 0,
    review_count number(7) default 0
);

create sequence seq_spot
    increment by 1
    start with 1;


create table spot_review(
    idx number(7) primary key,
    post_id number(7) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_email varchar2(100) not null,
    upload_path varchar2(200),
    file_name varchar2(200),
    like_count number(5) default 0,
    reply_count number(5) default 0,
    reg_date date default sysdate,
    star_count number(5) default 0
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
select * from airport;

select * from restaurant;

create table restaurant(
    idx number(7) primary key,
    country varchar2(300) not null,
    city varchar2(300) not null,
    location varchar2(2000) not null,
    title varchar2(2000) not null,
    summary varchar2(2000) not null,
    menu_name1 varchar2(600) not null,
    menu_description1 varchar2(5000) not null,
    menu_price1 varchar2(300) not null,
    menu_name2 varchar2(600) not null,
    menu_description2 varchar2(500) not null,
    menu_price2 varchar2(300) not null,
    menu_name3 varchar2(600) not null,
    menu_description3 varchar2(500) not null,
    menu_price3 varchar2(300) not null,
    how_togo varchar2(2000),
    available_at varchar2(2000),
    tip varchar2(5000),
    etc varchar2(5000),
    upload_path1 varchar2(2000),
    file_name1 varchar2(2000),
    upload_path2 varchar2(2000),
    file_name2 varchar2(2000),
    upload_path3 varchar2(2000),
    file_name3 varchar2(2000),
    upload_path4 varchar2(2000),
    file_name4 varchar2(2000),
    adminuser_id varchar2(500),
    adminuser_name varchar2(500),
    reg_date date default sysdate,
    like_count number(7) default 0,
    total_star number(10) default 0,
    star_count number(3,1) default 0,
    review_count number(7) default 0
);

create sequence seq_restaurant
    increment by 1
    start with 1;
    
    
    

drop table restaurant_review;
delete from restaurant_review where idx = 7;

select *from restaurant_review;


create table restaurant_review(
    idx number(7) primary key,
    post_id number(7) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(50) not null,
    user_email varchar2(50) not null,
    upload_path varchar2(200),
    file_name varchar2(200),
    like_count number(5) default 0,
    reply_count number(5) default 0,
    reg_date date default sysdate,
    star_count number(3) default 0
);

create sequence seq_restaurant_review
    increment by 1
    start with 1;
    
    
update restaurant set review_count=0;

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

select * from spot;
select * from tour;
select * from restaurant;
select * from coupon;
insert into coupon values (1, 1, '[8�� ����]���� ���� ���� 3,000��', 'LODGING', 3000, '5���� �̻� ���� ��', 'USABLE', 'a111', null, '2022-08-31', 'USABLE');
insert into coupon values (2, 2, '[8�� ����]���� ���� 3,000��', 'TOUR', 3000, '5���� �̻� ���� ��', 'USABLE', 'a333', null, '2022-08-31', 'USABLE');
insert into coupon values (3, 3, '[8�� ����]�װ� ���� 3,000��', 'AIR', 3000, '5���� �̻� ���� ��', 'USABLE', 'a222', null, '2022-08-31', 'USABLE');
insert into coupon values (4, 4, '[7�� ����]���� ���� ���� 3,000��', 'LODGING', 3000, '5���� �̻� ���� ��', 'EXPIRED', 'a111', null, '2022-08-31', 'USED');
insert into coupon values (1, 1, '[8�� ����]���� ���� ���� 3,000��', 'LODGING', 3000, '5���� �̻� ���� ��', 'USABLE', 'a111', null, '2022-08-31', 'USABLE');
insert into coupon values (2, 2, '[8�� ����]���� ���� 3,000��', 'TOUR', 3000, '5���� �̻� ���� ��', 'USABLE', 'a333', null, '2022-08-31', 'USABLE');
insert into coupon values (3, 3, '[8�� ����]�װ� ���� 3,000��', 'AIR', 3000, '5���� �̻� ���� ��', 'USABLE', 'a222', null, '2022-08-31', 'USABLE');
insert into coupon values (4, 4, '[7�� ����]���� ���� ���� 3,000��', 'LODGING', 3000, '5���� �̻� ���� ��', 'EXPIRED', 'a111', null, '2022-08-31', 'USED');

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
    
    

drop table guide;   

select * from guide;

create table guide(
    idx number(7) primary key,
    country varchar2(30) not null,
    city varchar2(30) not null,
    title varchar2(100) not null,
    upload_path varchar2(200) not null,
    file_name varchar2(200) not null,
    content varchar2(500) not null,
    language varchar2(50) not null,
    area varchar2(50) not null,
    population varchar2(50) not null,
    time_difference varchar2(100) not null,
    myth varchar2(50) not null,
    voltage varchar2(200) not null,
    currency varchar2(50) not null,
    country_code varchar2(50) not null,
    visa varchar2(500) not null,
    prices varchar2(500) not null,
    air varchar2(600) not null,
    climate varchar2(500) not null,
    best_time varchar2(200) not null,
    simple_conversation varchar2(1000) not null,
    reg_date date default sysdate,
    review_count number(7) default 0,
    total_star number(10) default 0,
    star_count number(10) default 0
);
alter table guide modify star_count number(3,1);
 
create sequence seq_guide
    increment by 1
    start with 1;
    
drop table guide_review;

drop table guide_review; 



create table guide_review(
    idx number(7) primary key,
    post_id number(7) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(50) not null,
    user_email varchar2(50) not null,
    upload_path varchar2(200),
    file_name varchar2(200),
    like_count number(5) default 0,
    reply_count number(5) default 0,
    reg_date date default sysdate,
    star_count number(5) default 0
);

create sequence seq_guide_review
    increment by 1
    start with 1;
    
    

drop table guide_review;    


select * from guide_review;

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
    inquiry_id number(7),
    ticket_num number(7),
    user_id number(7) not null,
    type_category varchar2(20) not null,
    type_detail varchar2(20),
    title varchar2(100) not null,
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
    reg_date date default sysdate,
    upload_path varchar2(200)
);

create sequence seq_mysave
    increment by 1
    start with 1;
    
insert into mysave values(1, 3, 111, 'Y', null, '���̵�', '2022-08-01');
insert into mysave values(2, 3, 222, 'Y', null, '���̵�', '2022-08-01');
insert into mysave values(3, 3, 333, 'Y', null, '����', '2022-08-01');
insert into mysave values(4, 3, 444, 'Y', null, '����', '2022-08-01');
insert into mysave values(5, 3, 555, 'Y', null, '����', '2022-08-01');
insert into mysave values(6, 3, 666, 'Y', null, '����', '2022-08-01');
insert into mysave values(7, 3, 777, 'Y', null, '����', '2022-08-01');
insert into mysave values(8, 3, 888, 'Y', null, '����', '2022-08-01');
insert into mysave values(9, 3, 999, 'Y', null, '����', '2022-08-01');
insert into mysave values(10, 3, 1010, 'Y', null, '����', '2022-08-01');

alter table mysave add upload_path varchar2(200);
   
   
   
select * from notice;

create table notice(
    idx number(7),
    adminuser_id varchar2(100) not null,
    adminuser_name varchar2(20) not null,
    notice_type varchar2(30) not null,
    title varchar2(100) not null,
    content varchar2(4000) not null,
    upload_path varchar2(200),
    file_name varchar2(200),
    reg_date date default sysdate
);

create sequence seq_notice
    increment by 1
    start with 1;
    
create table event(
    idx number(7),
    adminuser_id varchar2(100) not null,
    adminuser_name varchar2(20) not null,
    event_type varchar2(30) not null,
    title varchar2(100) not null,
    content varchar2(2000) not null,
    upload_path varchar2(200),
    file_name varchar2(200),
    reg_date date default sysdate
);

create sequence seq_event
    increment by 1
    start with 1;

create table faq(
    idx number(7),
    faq_category varchar2(20) not null,
    adminuser_id varchar2(20) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(600) not null,
    content varchar2(4000) not null,
    reg_date date default sysdate
);


create sequence seq_faq
    increment by 1
    start with 1;



insert into faq values(1, 'SERVICE', 1, '���???', '������ ���??? �� �� �ֳ���?', 'ȸ�� Ż���??? �Ʒ��� �����??? ���� �����մϴ�.

- �̸��� ȸ��

Ʈ���� ����Ʈ ���� > ���� ���??? ���������� > ���� > ���� Ż�� > ��й��? �Է� > Ż���մϴ� ����

- ����α���??? ȸ��(īī��, ���̹�, ���̽���, ����)

Ʈ���� ����Ʈ ���� > ���� ���??? ���������� > ���� > ���� Ż�� > ����α���??? ���� ���� > Ż���մϴ� ����', '2022-08-05');
insert into faq values(1, 'AIR', 1, '���???', '�װ�Ƽ���� ���⼭ ��������', '������ �� �װ��翡�� �����ø� �˴ϴ�', '2022-08-05');
insert into faq values(1, 'LODGING', 1, '���???', '���ұ��� ��� ������', '���̹� ������ �̿��ϼ���', '2022-08-05');
insert into faq values(1, 'TOUR', 1, '���???', 'Ƽ���� �Ҿ���Ⱦ��', '�߱�ó�� �������ּ���', '2022-08-05');
insert into faq values(1, 'COMMON', 1, '���???', 'Ƽ���� �Ҿ���Ⱦ��', '�߱�ó�� �������ּ���', '2022-08-05');


commit;


--����
create table reservation_airuse(
    idx number(7) primary key,
    user_id number(7) not null,
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
    reg_date date default sysdate,
    passenger_name varchar2(20) not null
);

insert into faq values(1, 'SERVICE', 1, '���???', '������ ���??? �� �� �ֳ���?', 'ȸ�� Ż���??? �Ʒ��� �����??? ���� �����մϴ�.

- �̸��� ȸ��

Ʈ���� ����Ʈ ���� > ���� ���??? ���������� > ���� > ���� Ż�� > ��й��? �Է� > Ż���մϴ� ����

- ����α���??? ȸ��(īī��, ���̹�, ���̽���, ����)

Ʈ���� ����Ʈ ���� > ���� ���??? ���������� > ���� > ���� Ż�� > ����α���??? ���� ���� > Ż���մϴ� ����', '2022-08-05');
--insert into faq values(1, 'AIR', 1, '���???', '�װ�Ƽ���� ���⼭ ��������', '������ �� �װ��翡�� �����ø� �˴ϴ�', '2022-08-05');
--insert into faq values(1, 'LODGING', 1, '���???', '���ұ��� ��� ������', '���̹� ������ �̿��ϼ���', '2022-08-05');
--insert into faq values(1, 'TOUR', 1, '���???', 'Ƽ���� �Ҿ���Ⱦ��', '�߱�ó�� �������ּ���', '2022-08-05');
--insert into faq values(1, 'COMMON', 1, '���???', 'Ƽ���� �Ҿ���Ⱦ��', '�߱�ó�� �������ּ���', '2022-08-05');


commit;



--����
create table reservation_airuse(
    idx number(7) primary key,
    user_id number(7) not null,
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
    reg_date date default sysdate,
    passenger_name varchar2(20) not null
);
select * from restaurant;
select * from restaurant_review;

select * from admin_user;

create table admin_user(
    idx number(7) primary key,
    userid varchar2(20) not null,
    userpw varchar2(20) not null,
    name varchar2(20) not null,
    hp varchar2(20) not null,
    department varchar2(20) not null,
    email varchar2(20) not null,
    position varchar2(20) not null,
    status varchar2(10) not null,
    reg_date date default sysdate
);

create sequence seq_admin_user
    increment by 1
    start with 2;
    

insert into room_reservation values(2,31,'handho121@naver.com', '2022-09-01', '2022-09-11', '��','��ȣ','����','����','��û����',1000);

select * from room_reservation;
commit;
create table room_reservation(
    idx number(7) primary key,
    room_id number(7) not null,
    user_email varchar2(40) not null,
    start_date varchar2(50) not null,
    end_date varchar2(50) not null,
    last_name varchar2(40) not null,
    first_name varchar2(40) not null,
    birth varchar2(40) not null,
    gender varchar2(40) not null,
    request varchar2(1000) not null,
    total_price number(10) not null
    reg_date date default sysdate
);


create sequence seq_room_reservation
    increment by 1
    start with 1;


set autocommit off;
set autocommit on;
show autocommit;