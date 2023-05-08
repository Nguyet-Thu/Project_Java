CREATE DATABASE ShopClothes_P4
GO 
USE ShopClothes_P4
CREATE TABLE Admin(
	Id int PRIMARY KEY IDENTITY(1,1),
	AdminName varchar(50),
	Password varchar(100) ,
	Email nvarchar(100) NULL,
	Address nvarchar(250) NULL,
	Phone int NULL
)
CREATE TABLE Category(
	Id int PRIMARY KEY IDENTITY(1,1),
	NameCategory nvarchar(100),
	Description ntext NULL,
	Status bit NULL
)

CREATE TABLE Product(
	Id int PRIMARY KEY IDENTITY(1,1),
	ProductName nvarchar(250),
	ProductContent ntext,
	Description ntext ,
	Price float ,
	Image nvarchar(100) NULL,
	Quantity int,
	Category_Id int FOREIGN KEY REFERENCES Category(id),
	Status bit NULL,
)
drop table Bills
CREATE TABLE Customer(
	Id int PRIMARY KEY IDENTITY(1,1),
	UserName varchar(50),
	Password varchar(100) ,
	FullName nvarchar(250),
	Email nvarchar(100) NULL,
	Gender varchar(50),
	Address nvarchar(100) NULL,
	Phone varchar(15) NULL,
)
CREATE TABLE Bills(
	Id int PRIMARY KEY IDENTITY(1,1),
	FullName nvarchar(250) NOT NULL,
	Phone varchar(15) NOT NULL,
	Email nvarchar(100),
	Address nvarchar(100) NOT NULL,
	Total float,
	Quantity int NOT NULL,
	Note ntext,
	Status bit NULL
)
select 
CREATE TABLE BillDetail(
	Id int PRIMARY KEY IDENTITY(1,1),
	ProductId int FOREIGN KEY REFERENCES Product(Id),
	Bill_Id int FOREIGN KEY REFERENCES Bills(Id),
	Quantity int,
	Total float,
	
)
INSERT INTO Category (NameCategory) VALUES(N'Áo phông'),(N'Váy'),(N'Đồ bộ'),(N'Quần Jeans'),(N'Mũ')
INSERT INTO [dbo].[Product]([ProductName],[ProductContent],[Description],[Price],[Image],[Quantity],[Category_Id],[Status])
VALUES(N'Mũ lưỡi trai nâu',N'Mũ lưỡi trai nâu trơn',N'Kiểu mẫu mới nhất 2022, trẻ trung, năng động,tránh nắng.',10000,N'/mu_luoi_trai_nau.jpg',20,15,1)
GO
INSERT INTO [dbo].[Product]([ProductName],[ProductContent],[Description],[Price],[Image],[Quantity],[Category_Id],[Status])
VALUES(N'Chân váy',N'Chân váy bò xanh',N'Kiểu váy hot của các bạn nữ bên trong năm vừa qua.',250000,N'/chan_vay.jpg',22,13,1)
GO
INSERT INTO Customer(UserName ,Password,FullName,Email ,Gender ,Address ,Phone) VALUES ('thu','1234',N'Nguyệt Thu',N'kendy@gmail.com','Female',N'tqh','0945186341')
 GO
 INSERT INTO Admin(AdminName ,Password,Address ,Email  ,Phone) VALUES ('Admin','admin1234',N'tqh',N'kendy@gmail.com','0945186341')
 GO
  INSERT INTO Admin(AdminName ,Password,Address ,Email  ,Phone) VALUES ('Thu','nguyetthu1234',N'tqh',N'kendy@gmail.com','0945186341')
 GO
 select * from BillDetail
  select * from Bills
  SELECT * FROM BillDetail WHERE Bill_Id = 1 OrderByDescending(b => b.ProductID).Where(c => c.ClientID == clientid));
SELECT * FROM Admin WHERE AdminName = 'Admin'