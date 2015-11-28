DROP PROCEDURE IF EXISTS newAuthor;;
DROP FUNCTION IF EXISTS maxBookPriceOfAuthor;;
DROP TABLE IF EXISTS Books_by_Author;;
DROP TABLE IF EXISTS Customer;;
DROP TABLE IF EXISTS Author;;
DROP TABLE IF EXISTS Book;;

CREATE TABLE Customer (
	CustomerID	INTEGER PRIMARY KEY,
	FirstName	VARCHAR(20),
	LastName	VARCHAR(30),
	EMail		VARCHAR(50),
	Phone		VARCHAR(30)
);;

CREATE TABLE Author (
	AuthorID	INTEGER PRIMARY KEY,
	FirstName	VARCHAR(20),
	LastName	VARCHAR(30)
);;

CREATE TABLE Book (
	ISBN		VARCHAR(20) PRIMARY KEY,
	Title		VARCHAR(30),
	PubDate		VARCHAR(10),
	Format		VARCHAR(15),
	Price		FLOAT
);;

CREATE TABLE Books_by_Author (
	AuthorID	INTEGER FOREIGN KEY REFERENCES Author,
	ISBN		VARCHAR(20)  FOREIGN KEY REFERENCES Book
);;

INSERT INTO Customer VALUES (5000, 'John', 'Smith', 'john@gmail.com', '552-456-453');;
INSERT INTO Customer VALUES (5001, 'Anthony', 'Wallace', 'anthony@gmail.com', '355-456-453');;
INSERT INTO Customer VALUES (5002, 'Thomas', 'Anderson', 'thomas@gmail.com', '855-456-453');;
INSERT INTO Customer VALUES (5003, 'Anna', 'Kournikova', 'anna@gmail.com', '955-456-453');;
INSERT INTO Customer VALUES (5004, 'Peter', 'Stoneman', 'peter@gmail.com', '755-456-453');;

INSERT INTO Author VALUES (1000, 'Rick', 'Riordan');;
INSERT INTO Author VALUES (1001, 'Nancy', 'Cowell');;
INSERT INTO Author VALUES (1002, 'Ally', 'Freisner');;
INSERT INTO Author VALUES (1003, 'Christina', 'Harch');;
INSERT INTO Author VALUES (1004, 'Lauren', 'Farmer');;
INSERT INTO Author VALUES (1005, 'Mary', 'Rodgers');;
INSERT INTO Author VALUES (1006, 'Heather', 'Condie');;

INSERT INTO Book VALUES ('0123456789', 'The Lost Hero', '2004-10-12', 'Hardcover', 10.95);;
INSERT INTO Book VALUES ('2342343342', 'Howliday Inn', '2003-10-12', 'Paperback', 12.95);;
INSERT INTO Book VALUES ('0564545667', 'The Last Leopard', '2008-10-12', 'Hardcover', 10.95);;
INSERT INTO Book VALUES ('0346545875', 'The White Giraffe', '2002-10-12', 'Paperback', 13.95);;
INSERT INTO Book VALUES ('0776655447', 'Freaky Monday', '2003-11-12', 'Paperback', 7.95);;
INSERT INTO Book VALUES ('7765674556', 'The Kane Chronicles', '2011-10-12', 'Hardcover', 10.95);;
INSERT INTO Book VALUES ('7776567333', 'The House Of Scorpion', '2012-10-12', 'Hardcover', 4.95);;
INSERT INTO Book VALUES ('0222333344', 'The Light', '2010-03-12', 'Paperback', 10.95);;
INSERT INTO Book VALUES ('0867667676', 'Batman', '1970-10-12', 'Paperback', 5.95);;

INSERT INTO Books_by_Author VALUES (1000, '0123456789');;
INSERT INTO Books_by_Author VALUES (1000, '2342343342');;
INSERT INTO Books_by_Author VALUES (1001, '0564545667');;
INSERT INTO Books_by_Author VALUES (1002, '0564545667');;
INSERT INTO Books_by_Author VALUES (1003, '0346545875');;
INSERT INTO Books_by_Author VALUES (1004, '0776655447');;
INSERT INTO Books_by_Author VALUES (1005, '7765674556');;
INSERT INTO Books_by_Author VALUES (1006, '7776567333');;
INSERT INTO Books_by_Author VALUES (1006, '0222333344');;

CREATE PROCEDURE newAuthor(AuthorID INTEGER, FirstName VARCHAR(20), LastName VARCHAR(30))
MODIFIES SQL DATA
	INSERT INTO Author VALUES (AuthorID, FirstName, LastName);;

CREATE FUNCTION maxBookPriceOfAuthor (IN AuthorID_p INTEGER)
RETURNS FLOAT READS SQL DATA
BEGIN ATOMIC
	DECLARE maxPrice FLOAT;
	SET maxPrice = SELECT MAX(Book.Price) 
		FROM Book, Books_by_Author, Author
		WHERE Book.ISBN = Books_by_Author.ISBN 
			AND Author.AuthorID = Books_by_Author.AuthorID
			AND Author.AuthorID = AuthorID_p;
	RETURN maxPrice;
END;;
