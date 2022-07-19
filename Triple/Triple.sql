create sequence auto_increment
    increment by 1
    start with 1;

create table tb_users(
    id number(7) primary key,
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
    id number(7) primary key,
    terms_name varchar2(30) not null,
    reg_date date default sysdate,
    content varchar2(300) not null,
    ifrequired varchar2(2) not null,
    ifuse varchar2(2) not null
);
create table tb_airport(
    id number(7)  primary key,
    apoort_num varchar2(10) not null,
    aiport_name varchar2(20) not null,
    airport_code varchar2(10) not null,
    country varchar2(20) not null,
    city varchar2(20) not null  
);

create table tb_airline(
    id number(7) primary key,
    airline_num number(7) not null,
    kr_name varchar2(20) not null,
    en_name varchar2(20) not null,
    airline_code varchar2(10) not null,
    address varchar2(30) not null,
    contact_num1 varchar2(20) not null,
    contact_num2 varchar2(20)
);

create table tb_aircraft(
    id number(7) primary key,
    aircraft_num number(7) not null,
    aircraft_name varchar2(20) not null,
    madeby varchar2(20) not null,
    aircraft_capacity number(4) not null,
    normal_seat number(3) not null,
    economy_seat number(3) not null,
    special_seat number(3) not null,
    family_seat number(3) not null,
    vip_seat number(3) not null,
    airline_id number(7) not null
);

create table tb_air_ticket(
    id number(7) primary key,
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
    baggage varchar2(10) not null,
    rev_date varchar2(10),
    stauts varchar2(10) not null
);

create table tb_lodging(
    id number(7) primary key,
    company_num varchar2(10) not null,
    lodging_type varchar2(10) not null,
    company_name varchar2(10) not null,
    introducing varchar2(300) not null,
    country varchar2(20) not null,
    city varchar2(20) not null,
    address varchar2(30) not null,
    contact_num varchar2(20) not null,
    representative varchar2(20) not null,
    email varchar2(30) not null,
    like_num number(5) default 0
);

create table tb_lodging_room(
    id number(7) primary key,
    room_num varchar2(10) not null,
    room_type varchar2(20) not null,
    status varchar2(2) not null,
    check_in date not null,
    check_out date not null,
    width varchar2(30),
    room_capacity number(2),
    room_policy varchar2(30),
    price number(8) not null,
    lodging_id number(7) not null,
    use_date date not null,
    status varchar2(10) not null
);

create table tb_tour( 
    id number(7) primary key,
    tour_num varchar2(10) not null,
    country varchar2(10) not null,
    address varchar2(30) not null,
    manager_name varchar2(20) not null,
    contact_num varchar2(20) not null,
    title varchar2(50) not null,
    info varchar2(20) not null,
    status varchar2(10) not null,
    price number(8) not null,
    time_taken varchar2(20) not null,
    start_date date not null,
    end_date date not null,
    like_num default 0,
    remaining number(5) not null
);

create table tb_tour_ticket(
    id number(7) primary key,
    ticket_type varchar2(10)  not null,
    ticket_num varchar2(10) not null,
    reg_date date default sysdate
);

create table tb_reservation(
    id number(10) primary key,
    ticket_type varchar2(10) not null,
    ticket_num varchar2(10) not null,
    rev_name varchar2(20) not null,
    email varchar2(30) not null,
    hp varchar2(20) not null,
    emergency_hp varchar2(20) not null
);

create table tb_review(
    id number(7) primary key,
    review_num varchar2(10) not null,
    title varchar2(50) not null,
    review_content varchar2(300) not null,
    nickname varchar2(20) not null,
    email varchar2(30) not null,
    uploadPath varchar2(200) not null,
    fileName varchar2(200) not null,
    fileType varchar2(10) not null,
    like_num number(5) default 0,
    reg_date date default sysdate,
    ticket_num varchar2(10) not null
);