create sequence auto_increment
    increment by 1
    start with 1;

create table tb_users(
    idx number(7) primary key,
    userid varchar2(30) not null,
    email varchar2(30) not null,
    userpw varchar2(20) not null,
    nickname varchar2(20) not null,
    country_code varchar2(4) not null,
    zipcode number(6),
    address1 varchar2(30),
    address2 varchar2(20),
    address3 varchar2(20),
    reg_date date default sysdate,
    status varchar2(10) not null,
    TOS_agree not null
);

create table tb_terms(
    idx number(7) primary key,
    terms_name varchar2(30) not null,
    reg_date date default sysdate,
    content varchar2(300) not null,
    if_required varchar2(2) not null,
    if_use varchar2(2) not null
);

create table tb_airport(
    idx number(7)  primary key,
    airport_num varchar2(10) not null,
    airport_name varchar2(20) not null,
    airport_code varchar2(10) not null,
    country varchar2(20) not null,
    city varchar2(20) not null  
);

create table tb_airline(
    idx number(7) primary key,
    airline_num number(7) not null,
    kr_name varchar2(20) not null,
    en_name varchar2(20) not null,
    airline_code varchar2(10) not null,
    address varchar2(30) not null,
    contact_num1 varchar2(20) not null,
    contact_num2 varchar2(20)
);

create table tb_aircraft(
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

create table tb_air_ticket(
    idx number(7) primary key,
    ticket_type varchar2(10),
    ticket_num varchar2(10),
    airline_id number(7) not null,
    aircraft_id number(7) not null,
    departure_airport varchar2(20) not null,
    landing_airport varchar2(20) not null,
    departure_date date not null,
    landing_date date not null,
    price number(8) not null,
    seat_num varchar2(10) not null,
    seat_grade varchar2(10) not null,
    baggage varchar2(10) not null,
    rev_date date,
    stauts varchar2(10) not null
);

create table tb_lodging(
    idx number(7) primary key,
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

create table tb_lodging_room(
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

create table tb_lodging_ticket(
    idx number(7) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    room_num varchar2(10) not null,
    reg_date date default sysdate
);

create table tb_tour( 
    idx number(7) primary key,
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

create table tb_tour_ticket(
    idx number(7) primary key,
    ticket_type varchar2(10)  not null,
    ticket_num varchar2(10) not null,
    reg_date date default sysdate
);

create table tb_reservation(
    idx number(10) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    rev_name varchar2(20) not null,
    email varchar2(30) not null,
    hp varchar2(20) not null,
    emergency_hp varchar2(20) not null
);

create table tb_review(
    idx number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    star_count varchar2(20) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    like_count number(5) default 0,
    reg_date date default sysdate,
    ticket_num varchar2(10) not null
);

create table tb_magazine(
    idx number(7) primary key,
    adminuser_id number(7) not null,
    adminuser_name varchar2(20) not null,
    magazine_num number(7) not null,
    magazine_type varchar2(10) not null,
    title varchar2(20) not null,
    content varchar2(500) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    reg_date date default sysdate
);

create table tb_adminuser(
    idx number(7) primary key,
    admin_id varchar2(20) unique not null,
    admin_pw varchar2(20) not null,
    admin_name number(7) not null,
    reg_date date default sysdate
);

create table tb_spot(
    idx number(7) primary key,
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

create table tb_spot_review(
    idx number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    like_count number(5),
    reply_count number(5) default 0,
    reg_date date default sysdate,
    star_count varchar2(20) not null
);

create table tb_tourspot_review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create table tb_restaurant(
    idx number(7) primary key,
    rest_num number(7) unique not null,
    rest_name varchar2(20) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    hp varchar2(20) not null,
    address varchar2(30) not null,
    title varchar2(500) not null,
    content varchar2(500) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    operation_status varchar2(4),
    reg_date date default sysdate,
    like_count number(7) default 0,
    review_count number(7) default 0
);

create table tb_restaurant_review(
    idx number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    like_count number(5) default 0,
    reply_count number(5),
    reg_date date default sysdate,
    star_count varchar2(20) not null
);

create table tb_restaurant_review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create table tb_coupon(
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

create table tb_user_coupon(
    idx number(7) primary key,
    userid varchar(10),
    coupon_id number(7),
    reg_date date default sysdate
);

create table tb_guide(
    idx number(7) primary key,
    guide_num number(7) not null,
    adminuser_id varchar2(10) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(30) not null,
    content varchar2(500),
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    reg_date date default sysdate,
    review_count number(7) default 0
);

create table tb_guide_review(
    idx number(7) primary key,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(300) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    uploadPath varchar2(200),
    fileName varchar2(200),
    fileType varchar2(10),
    reg_date date default sysdate,
    like_count number(5) default 0,
    reply_count number(5)
);

create table tb_guide_review_reply(
    idx number(7) primary key,
    reply_num number(7) not null,
    review_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);

create table tb_question(
    idx number(7) primary key,
    inquary_id number(7) not null,
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

create table tb_answer(
    idx number(7) primary key,
    answer_num number(7) not null,
    inquary_id number(7) not null,
    adminuser_id number(8) not null,
    adminuser_name varchar2(20) not null,
    title varchar2(20) not null,
    content varchar2(300) not null,
    reg_date date default sysdate
);

create table tb_tripler(
    idx number(7) primary key,
    tripler_num number(7) not null,
    userid varchar2(10) not null,
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

create table tb_tripler_reply(
    idx number(7) primary key,
    reply_num number(7)	not null,
    tripler_num number(7) not null,
    title varchar2(50) not null,
    content varchar2(100) not null,
    nickname varchar2(20) not null,
    user_id varchar2(30) not null,
    like_count number(5) default 0,
    reg_date date default sysdate
);












