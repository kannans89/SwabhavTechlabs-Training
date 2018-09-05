DELIMITER //
drop trigger if exists insert_before_fooname;
create trigger insert_before_fooname
before insert ON foo
FOR EACH ROW 
BEGIN
set New.fooname = UCASE(NEW.fooname);
END//
DELIMITER ;
