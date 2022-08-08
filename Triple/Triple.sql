create sequence auto_increment
    increment by 1
    start with 1;

select * from users;

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

create sequence seq_aircraft
    increment by 1
    start with 1;
    

create table air_ticket(
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
    status varchar2(10) not null,
    user_id number(7) not null
);

create sequence seq_air_ticket
    increment by 1
    start with 1;
    
insert into air_ticket values(1, 'AIR', 'a111', '2222', '3333', '김포공항', '제주공항', '2022-08-20', '2022-08-20', '150000', '4444', 'a', 'Y', sysdate, 'AVAILABLE', 3);
insert into air_ticket values(2, 'AIR', 'a112', '2222', '3333', '김포공항', '제주공항', '2022-08-20', '2022-08-20', '150000', '4444', 'a', 'Y', sysdate, 'AVAILABLE', 4);

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

create sequence seq_reservation_airuse
    increment by 1
    start with 1;
    
insert into reservation_airuse values(1, 3, 'AIR', 'a111', 'a', 'pple', '001010', 'MALE', '010-1111-1111', '대한민국', '1111', '1111', '대한민국', 'Y', '2022-08-01', '김사과');

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
    like_count number(5) default 0,
    homepage varchar2(30)
);

create sequence seq_lodging
    increment by 1
    start with 1;

insert into lodging values(1, 'LODGING', 'asdf', '1박', '두짓 타니 괌 리조트', 'ㅁㄴㅇㄹ', '미국', '괌', 'Tamuning 1227 Pale San Vitores Road', '+16716488000', 'aaaa', 'dusit@dusit.com', 0, 'https://www.dusit.com');

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
    
insert into lodging_room values (1, 'b555', '호텔', 'AVAILABLE', TO_DATE('2022-08-01 15:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2022-08-02 11:00:00','YYYY-MM-DD HH24:MI:SS'), '32평', 5, '객실정책', 200000, 999, '2022-08-01', 'SOLDOUT');

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
    
insert into lodging_ticket values(1, '숙소', 'b111', 'b555', '김사과', '010-1111-1111', 'apple@apple.com', 'a', 'pple', '001010', null, 'Y', sysdate, 3, 2, '자가용 이동');
insert into lodging_ticket values(2, '숙소', 'b112', 'b556', '이메론', '010-1111-1111', 'melon@melon.com', 'm', 'elon', '000810', null, 'Y', sysdate, 4, 2, '자가용 이동');

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
    reg_date date default sysdate,
    user_id number(7) not null
);

create sequence seq_tour_ticket
    increment by 1
    start with 1;
    
insert into tour_ticket values(1, '투어', 'c111', '김사과', '010-1111-1111', 'apple@apple.com', '010-1111-1111', 'a', 'pple', '001010', 'apple', null, 'a', 'pple', sysdate, 3);
insert into tour_ticket values(2, '투어', 'c112', '이메론', '010-2222-2222', 'melon@melon.com', '010-2222-2222', 'm', 'elon', '000810', 'melon', null, 'm', 'elon', sysdate, 4);

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
    
insert into reservation values (1, 'AIR', 'a111', '김사과', 'apple@apple.com', '010-1111-1111', '010-1111-1111', 3, 'CJU-GMP', '[편도]제주 - 서울 항공권', '2022-07-30', 'USABLE');
insert into reservation values (2, 'LODGING', 'b111', '김사과', 'apple@apple.com', '010-1111-1111', '010-1111-1111', 3, '괌', '두짓 타니 괌 리조트', '2022-07-30', 'USABLE');
insert into reservation values (3, 'TOUR', 'c111', '김사과', 'apple@apple.com', '010-1111-1111', '010-1111-1111', 3, '괌', '괌 항공 + 호텔 포함 자유여행 4박 5일', '2022-07-30' ,'USABLE');

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
    

create table magazine(
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

create sequence seq_magazine
    increment by 1
    start with 1;
    
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
    start with 1;
    
<<<<<<< HEAD
insert into admin_user values(1, 'apple123', 'apple123!', '源??궗怨?', '010-1111-1111', '愿?由ъ옄', 'apple@naver.com', 'ceo', 'REGISTERED', sysdate);
=======
insert into admin_user values(1, 'apple123', 'apple123!', '김사과', '010-1111-1111', '관리자', 'apple@naver.com', 'ceo', 'REGISTERED', sysdate);
>>>>>>> 2c3980fece3607f185c34f20895706cb44ce3928
    

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
    

create table restaurant(
    idx number(7) primary key,
    type varchar2(10) unique not null,
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

insert into coupon values (1, 1, '[8월 혜택]국내 숙소 할인 3,000원]', 'LODGING', 3000, '5만원 이상 예약 시', 'USABLE', 'bbb', null, '2022-08-31', 'USABLE');
insert into coupon values (2, 1, '[7월 혜택]국내 숙소 할인 3,000원]', 'LODGING', 3000, '5만원 이상 예약 시', 'unUSABLE', 'bbb', null, '2022-07-31', 'EXPIRED');

create table user_coupon(
    idx number(7) primary key,
    user_id number(7) not null,
    coupon_id number(7),
    reg_date date default sysdate
);

create sequence seq_user_coupon
    increment by 1
    start with 1;

insert into user_coupon values(1, 3, 1, '2022-08-01');

create table guide(
    idx number(7) primary key,
    type varchar2(10) unique not null,
    guide_num number(7) not null,
    adminuser_id number(7) not null,
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
    
insert into mysave values(1, 3, 111, 'Y', null, '가이드', '2022-08-01');
insert into mysave values(2, 3, 222, 'Y', null, '가이드', '2022-08-01');
insert into mysave values(3, 3, 333, 'Y', null, '관광', '2022-08-01');
insert into mysave values(4, 3, 444, 'Y', null, '관광', '2022-08-01');
insert into mysave values(5, 3, 555, 'Y', null, '맛집', '2022-08-01');
insert into mysave values(6, 3, 666, 'Y', null, '맛집', '2022-08-01');
insert into mysave values(7, 3, 777, 'Y', null, '숙소', '2022-08-01');
insert into mysave values(8, 3, 888, 'Y', null, '숙소', '2022-08-01');
insert into mysave values(9, 3, 999, 'Y', null, '투어', '2022-08-01');
insert into mysave values(10, 3, 1010, 'Y', null, '투어', '2022-08-01');


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


insert into faq values (1, 1, '항공', 1, '사과', '항공티켓은 여기서 받으세요', '공항의 각 항공사에서 받으시면 됩니다', null, null, null, '2022-08-01');





