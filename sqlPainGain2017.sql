create database PainAndGain_2017 char set = 'utf8';
use PainAndGain_2017;

create table NHA_CC(
MA_NCC int  auto_increment primary key,
TEN_NCC nvarchar(300) not null,
DIA_CHI nvarchar(300) null,
SO_DT varchar(12) not null
);

create table DANH_MUC(
MA_DM int auto_increment primary key,
TEN_DM nvarchar(200) not null
);



create table LOAI_SP(
MA_LOAI int auto_increment primary key,
TEN_LOAI nvarchar(300) not null,
MA_DM int null,
foreign key (MA_DM) references DANH_MUC(MA_DM)
);

create table SAN_PHAM(
MA_SP int auto_increment primary key,
TEN_SP nvarchar(300) not null,
SO_LUONG int not null default 0,
DON_GIA_BAN int not null default 0,
DON_GIA_MUA int default 0,
MA_LOAI int null,
foreign key(MA_LOAI) references LOAI_SP(MA_LOAI)
);

create table NHACC_SANPHAM(
	MA_NHACC_SANPHAM int auto_increment primary key,
    MA_NCC int,
    MA_SP int,
    foreign key (MA_NCC) references NHA_CC(MA_NCC),
    foreign key (MA_SP) references SAN_PHAM(MA_SP)
);
create table NHAN_VIEN(
MA_NV int auto_increment primary key,
TEN_NV nvarchar(100) not null,
GIOI_TINH bit,
DIA_CHI nvarchar(300) null,
NGAY_VAO_LAM date null

);
insert into Nhan_Vien(TEN_NV,GIOI_TINH,DIA_CHI,NGAY_VAO_LAM) values ('Huy',1,'Thanh Xuân','2017-11-27');

create table CA_LAM(
MA_CA int auto_increment primary key,
GIO_BAT_DAU time not null,
GIO_KET_THUC time not null,
LUONG_GIO int not null
);

insert into CA_LAM(GIO_BAT_DAU,GIO_KET_THUC,LUONG_GIO) value ('2:26','3:45',23000);

create table CHAM_CONG(
MA_CC int auto_increment primary key,
MA_NV int not null,
GIO_BAT_DAU time not null,
GIO_KET_THUC time not null,
NGAY date not null,
MA_CA int,
foreign key (MA_CA) references CA_LAM(MA_CA),
foreign key (MA_NV) references NHAN_VIEN(MA_NV)
);

create table THUONG_PHAT(
MA_TP int auto_increment primary key,
GIA_TRI int not null default 0,
LA_THUONG boolean not null default 0,
LA_PHAT boolean not null default 0,
LI_DO text null,
MA_NV int,
foreign key (MA_NV) references NHAN_VIEN(MA_NV)
);

create table PHIEU_NHAP(
MA_PN int auto_increment primary key,
NGAY_LAP date not null
);

create table CHI_TIET_PHIEU_NHAP(
MA_CT_PN int auto_increment primary key,
MA_PN int,
MA_SP int,
DON_GIA int not null default 0,
SO_LUONG int not null default 0,
MA_NCC int,
foreign key (MA_SP) references SAN_PHAM(MA_SP),
foreign key (MA_NCC) references NHA_CC(MA_NCC),
foreign key (MA_PN) references PHIEU_NHAP(MA_PN)
);

create table KHACH_HANG(
MA_KH int auto_increment primary key,
TEN_KH nvarchar(200) not null,
DIA_CHI nvarchar(300) null,
SO_DT varchar(12) null
);
insert into Khach_Hang(TEN_KH,DIA_CHI,SO_DT) values ('Trương Quỳnh Trang ','43 Trần duy hưng','01662108386');
create table HOA_DON(
MA_HD int auto_increment primary key,
NGAY_LAP date,
MA_KH int,
foreign key (MA_KH) references KHACH_HANG(MA_KH)
);

create table CHI_TIET_HOA_DON(
MA_CT_HD int auto_increment primary key,
MA_HD int,
MA_SP int,
SO_LUONG int not null default 0,
GIAM_GIA int,
LA_PHAN_TRAM boolean default 0,
foreign key (MA_HD) references HOA_DON(MA_HD),
foreign key (MA_SP) references SAN_PHAM(MA_SP)
);
create table ACCOUNT(
MA_AC int primary key,
USER_NAME varchar(20),
PASS varchar(20),
foreign key (MA_AC) references NHAN_VIEN(MA_NV)
);
insert into ACCOUNT values (1,'huy',12345);

select * from danh_muc;
insert into danh_muc (TEN_DM) values ('xxx');

select * from nhan_vien;
select * from account;