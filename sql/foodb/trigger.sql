DELIMITER //
create trigger after_insert_fooname
AFTER INSERT ON foo
FOR EACH ROW 
BEGIN
update foo set fooname = upper(NEW.fooname) where id = NEW.id;
END//
DELIMITER ;
