delimiter //
DROP FUNCTION IF EXISTS getFormattedDate;
create function getFormattedDate() RETURNS varchar(25)
BEGIN
	DECLARE dayOfMonth INT;
	DECLARE monthOfYear INT;
	DECLARE year INT;
	DECLARE date1 varchar(20);
	DECLARE todayDate DATE;
	SELECT CURDATE() INTO todayDate;

	select day(todayDate) into dayOfMonth;
	select month(todayDate) into monthOfYear;
	select year(todayDate) into year;
	select concat(dayOfMonth, "/", monthOfYear, "/", year) into date1;
	return date1;
END;//

delimiter ;
