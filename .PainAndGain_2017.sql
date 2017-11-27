DROP DATABASE IF EXISTS painandgain_2017;
create database PainAndGain_2017 char set = 'utf8';
use PainAndGain_2017;


create table DANH_MUC(
MA_DM int auto_increment primary key,
TEN_DM nvarchar(200) not null
);
insert into danh_muc(TEN_DM) values (N'Quần'), (N'Áo'), (N'Phụ kiện');


create table LOAI_SP(
MA_LOAI int auto_increment primary key,
TEN_LOAI nvarchar(300) not null,
MA_DM int null,
foreign key (MA_DM) references DANH_MUC(MA_DM)
);
insert into loai_sp(TEN_LOAI,MA_DM) values
	(N'Áo ba lỗ',1), 
    (N'Áo cộc tay',1), 
    (N'Áo dài tay',1), 
    (N'Áo khoác',1),
    (N'Quần đùi',2), 
    (N'Quần jogger',2), 
    (N'Quần legging',2),
    (N'Đai lưng',3), 
    (N'Cuốn cổ tay',3), 
    (N'Găng tay',3), 
    (N'Bình nước',3),
    (N'Túi thể thao',3);

create table SAN_PHAM(
MA_SP int auto_increment primary key,
TEN_SP nvarchar(300) not null,
SO_LUONG int not null default 0,
DON_GIA_BAN int not null default 0,
DON_GIA_NHAP int default 0,
MA_LOAI int null,
foreign key(MA_LOAI) references LOAI_SP(MA_LOAI)
);
insert into san_pham(TEN_SP,SO_LUONG,DON_GIA_BAN,DON_GIA_NHAP,MA_LOAI) values
	(N'Áo ba lỗ bản to',30,220000,130000,1),
	(N'Áo thun Nike Pro Combat',50,230000,150000,2),
	(N'Quần short Nike dù',50,180000,100000,5),
	(N'Găng tay Muscletech',40,320000,180000,10),
	(N'Cuốn cổ tay Muscltech',45,200000,90000,9),
	(N'Túi thể thao 3 ngăn Adidas',25,350000,150000,12),
	(N'Bình nước PowerTrain',40,150000,70000,11),
	(N'Cuốn gối Muscletech',32,450000,200000,9),
	(N'Dây Lifting Muscletech',30,150000,80000,9),
	(N'Đai lưng Muscletech',10,550000,25000,8);

create table NHA_CC(
MA_NCC int  auto_increment primary key,
TEN_NCC nvarchar(300) not null,
DIA_CHI nvarchar(300) null,
SO_DT varchar(12) not null
);
insert into Nha_CC(TEN_NCC,DIA_CHI,SO_DT) values 
	('Little Rock','Thai lan','653276432'),
	('Nike','America','2183138512'),
	('Adidas','America','1203120802'),
	('Muscletech','Australia','9988910183'),
	('PowerTrain','Australia','9812738121');
    
create table NHACC_SANPHAM(
	MA_NHACC_SANPHAM int auto_increment primary key,
    MA_NCC int,
    MA_SP int,
    foreign key (MA_NCC) references NHA_CC(MA_NCC),
    foreign key (MA_SP) references SAN_PHAM(MA_SP)
);
insert into nhacc_sanpham(MA_NCC,MA_SP) values
	(1,1),
    (2,1),
    (2,2);
    
create table NHAN_VIEN(
MA_NV int auto_increment primary key,
TEN_NV nvarchar(100) not null,
GIOI_TINH bit,
DIA_CHI nvarchar(300) null,
NGAY_VAO_LAM date null

);
insert into Nhan_Vien(TEN_NV,GIOI_TINH,DIA_CHI,NGAY_VAO_LAM) 
values 
		('Huy',1,'Thanh Xuân','2017-11-27'),
		('Manh',1,'Lương Định Của','2015-11-20'),
		('Chieu',1,'ĐHXD','2017-11-11'),
		('Trang',0,'Học viện NH','2017-01-01');

create table CA_LAM(
MA_CA int auto_increment primary key,
GIO_BAT_DAU time not null,
GIO_KET_THUC time not null,
LUONG_GIO int not null
);
insert into CA_LAM(GIO_BAT_DAU,GIO_KET_THUC,LUONG_GIO) values
		('9:00','13:00',20000),
        ('13:00','18:00',20000),
        ('18:00','21:00',20000);
        
create table CHAM_CONG(
MA_CC int auto_increment primary key,
MA_NV int not null,
NGAY date not null,
GIO_BAT_DAU time not null,
GIO_KET_THUC time not null,
MA_CA int,
foreign key (MA_CA) references CA_LAM(MA_CA),
foreign key (MA_NV) references NHAN_VIEN(MA_NV)
);
insert into cham_cong(NGAY,MA_NV,GIO_BAT_DAU,GIO_KET_THUC,MA_CA) values
	('2017/04/01',1,'9:00','13:00',1),
	('2017/04/01',2,'13:30','18:00',2),
	('2017/04/01',3,'18:15','21:00',3),
	('2017/04/02',3,'9:00','13:00',1),
	('2017/04/02',2,'13:00','18:00',2),
	('2017/04/02',1,'18:00','21:00',3),
	('2017/04/03',4,'9:00','12:45',1),
	('2017/04/03',3,'13:00','18:00',2),
	('2017/04/03',1,'18:10','21:00',3),
	('2017/04/04',2,'9:00','13:00',1),
	('2017/04/04',4,'13:00','17:30',2),
	('2017/04/04',3,'18:00','21:00',3);

create table THUONG_PHAT(
MA_TP int auto_increment primary key,
GIA_TRI int not null default 0,
LA_THUONG boolean not null default 0,
LA_PHAT boolean not null default 0,
NGAY date not null,
LI_DO text null,
MA_NV int,
foreign key (MA_NV) references NHAN_VIEN(MA_NV)
);
insert into thuong_phat(GIA_TRI,LA_THUONG,LA_PHAT,NGAY,LI_DO,MA_NV) values
	(50000,1,0,'2017-11-7','den som',3),
	(50000,0,1,'2017-11-7','di muon',2),
	(50000,0,1,'2017-11-10','di muon',1),
	(50000,1,0,'2017-11-10','lam them gio',4),
	(1500000,1,0,'2016-12-31','thuong cuoi nam',1),
	(1300000,1,0,'2016-12-31','thuong cuoi nam',2),
	(1700000,1,0,'2016-12-31','thuong cuoi nam',3),
	(1000000,1,0,'2016-12-31','thuong cuoi nam',4);

create table PHIEU_NHAP(
MA_PN int auto_increment primary key,
NGAY_LAP date not null
);
insert into phieu_nhap(NGAY_LAP) values 
	('2017-10-10'),
	('2017-10-22'),
	('2017-11-13'),
	('2017-11-26');

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
insert into chi_tiet_phieu_nhap(MA_PN, MA_SP, DON_GIA, SO_LUONG, MA_NCC) values
	(1,1,130000,20,1),
	(1,2,150000,24,2),
	(2,3,100000,28,2),
	(3,4,180000,20,4),
	(3,5,90000,32,4),
	(4,6,150000,25,2),
	(4,2,90000,32,2);

create table KHACH_HANG(
MA_KH int auto_increment primary key,
TEN_KH nvarchar(200) not null,
DIA_CHI nvarchar(300) null,
SO_DT varchar(12) null
);
insert into khach_hang(TEN_KH,DIA_CHI,SO_DT) values
	(N'Anh Long',N'102 Thanh Xuân','0987123999'),
    (N'Chị Phương',N'298 Vương Thừa Vũ','0979926189'),
    (N'Chị Hòa',N'56 Trường Chinh','01623554932'),
    (N'Chị Xuân',N'67 Láng Hạ','08463826384'),
    (N'Chị Phượng',N'32 Vũ Tông Phan','09362836443'),
    (N'Anh Huy',N'45 Hai Bà Trưng','0937482648'),
    (N'Anh Vũ',N'67 Khương Trung','09439534833'),
    (N'Anh Tuấn',N'32 Thượng Đình','0933827492'),
    (N'Anh Minh',N'54 Đoàn Thị Điểm','096364823'),
    (N'Anh Phan',N'21 Hoàn Kiếm','0975372821'),
    (N'Anh Đạt',N'231 Trường Chinh','017383846'),
    (N'Chị Linh',N'43 Nguyễn Văn Cừ','09372438436'),
    (N'Anh Mạnh',N'731 Giải Phóng','09763547262'),
    (N'Anh Thi',N'43 Định Công Hạ','03347352374'),
    (N'Chị Ngọc',N'54 Tôn Thất Tùng','0823727838'),
    (N'Trương Quỳnh Trang ',N'43 Trần duy hưng','01662108386'),
    (N'Chị Ngân',N'65 Lò Đúc','0934434567');
    
create table HOA_DON(
MA_HD int auto_increment primary key,
NGAY_LAP date,
MA_KH int,
foreign key (MA_KH) references KHACH_HANG(MA_KH)
);
insert into hoa_don(NGAY_LAP,MA_KH) values
	('2017-11-5',1),
	('2017-11-5',2),
	('2017-11-5',5),
	('2017-11-6',8),
	('2017-11-6',12);

create table CHI_TIET_HOA_DON(
MA_CT_HD int auto_increment primary key,
MA_HD int,
MA_SP int,
SO_LUONG int not null,
GIAM_GIA int,
LA_PHAN_TRAM boolean default 0,
foreign key (MA_HD) references HOA_DON(MA_HD),
foreign key (MA_SP) references SAN_PHAM(MA_SP)
);
insert into chi_tiet_hoa_don(MA_HD, MA_SP, SO_LUONG, GIAM_GIA, LA_PHAN_TRAM) values
	(1,1,2,10,true),
	(2,1,1,0,false),
	(2,4,1,0,false),
	(3,2,2,10,true),
	(3,3,2,10,true);

create table ACCOUNTs(
MA_AC int primary key,
USER_NAME varchar(20),
PASS varchar(20),
foreign key (MA_AC) references NHAN_VIEN(MA_NV)
);
insert into ACCOUNTs values
	(1,'huy',12345),
	(2,'manh',12345),
	(3,'chieu',12345),
	(4,'trang',12345);

/*
select * from danh_muc;
select * from nhan_vien;
select * from nha_cc;
select * from danh_muc;
select * from loai_sp;
select * from san_pham;
select * from chi_tiet_hoa_don;

select nhacc_sanpham.MA_NCC, nha_cc.TEN_NCC, san_pham.TEN_SP
from nha_cc join nhacc_sanpham on nha_cc.MA_NCC = nhacc_sanpham.MA_NCC
			join san_pham on nhacc_sanpham.MA_SP = san_pham.MA_SP
-- where nhacc_sanpham.MA_NCC=1
order by MA_NCC    */

DROP TRIGGER IF EXISTS after_del_CTHD;
DELIMITER $$
CREATE TRIGGER after_del_CTHD AFTER DELETE ON chi_tiet_hoa_don
FOR EACH ROW
BEGIN
	UPDATE san_pham 
    SET SO_LUONG = SO_LUONG + chi_tiet_hoa_don.SO_LUONG
    WHERE san_pham.MA_SP = chi_tiet_hoa_don.MA_SP;
END; $$
DELIMITER ;


DROP TRIGGER IF EXISTS after_ins_CTHD;
DELIMITER $$
CREATE TRIGGER after_ins_CTHD AFTER INSERT ON chi_tiet_hoa_don
FOR EACH ROW
BEGIN
	UPDATE san_pham
    SET san_pham.SO_LUONG = san_pham.SO_LUONG - chi_tiet_hoa_don.SO_LUONG
    WHERE san_pham.MA_SP = chi_tiet_hoa_don.MA_SP;
END; $$ 
DELIMITER ;

DROP TRIGGER IF EXISTS after_ins_PhieuNhap;
DELIMITER $$
CREATE TRIGGER after_ins_PhieuNhap AFTER INSERT ON chi_tiet_phieu_nhap
FOR EACH ROW
BEGIN
	UPDATE san_pham
    SET san_pham.SO_LUONG = san_pham.SO_LUONG + chi_tiet_phieu_nhap.SO_LUONG
    WHERE san_pham.MA_SP = chi_tiet_phieu_nhap.MA_SP;
END; $$
DELIMITER ;

DROP TRIGGER IF EXISTS before_ins_ChamCong;
DELIMITER $$
CREATE TRIGGER before_ins_ChamCong BEFORE INSERT ON cham_cong
FOR EACH ROW
BEGIN
	IF isnull(NEW.NGAY) THEN
		SET NEW.NGAY = CURDATE();
        END IF;
	IF isnull(NEW.GIO_BAT_DAU) THEN
		SET NEW.GIO_BAT_DAU = CURTIME();
        END IF;
END; $$
DELIMITER ;

DROP TRIGGER IF EXISTS before_updt_ChamCong;
DELIMITER $$
CREATE TRIGGER before_updt_ChamCong BEFORE UPDATE ON cham_cong
FOR EACH ROW
BEGIN
	IF isnull(NEW.GIO_KET_THUC) THEN
		SET NEW.GIO_KET_THUC = CURTIME();
        END IF;
END; $$
DELIMITER ;

DROP TRIGGER IF EXISTS before_ins_HoaDon;
DELIMITER $$
CREATE TRIGGER before_ins_HoaDon BEFORE INSERT ON hoa_don
FOR EACH ROW
BEGIN
	IF isnull(NEW.NGAY_LAP) THEN
		SET NEW.NGAY_LAP = CURDATE();
    END IF;
END; $$
DELIMITER ;

DROP TRIGGER IF EXISTS before_ins_PhieuNhap;
DELIMITER $$
CREATE TRIGGER before_ins_PhieuNhap BEFORE INSERT ON phieu_nhap
FOR EACH ROW
BEGIN
	IF isnull(NEW.NGAY_LAP)
	THEN SET NEW.NGAY_LAP = CURDATE();
    END IF;
END; $$
DELIMITER ;
