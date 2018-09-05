DELIMITER //
CREATE PROCEDURE logToFoo(id int, des varchar(50))
BEGIN
	insert into foolog(id, des, modified) values(id, des, now());
END //
DELIMITER ;
