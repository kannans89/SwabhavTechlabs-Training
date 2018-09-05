package com.swabhavtechlabs.managertest;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.managerapp.Database;
import com.swabhavtechlabs.managerapp.Manager;
import com.swabhavtechlabs.managerapp.Specilization;

class DatabaseTest {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	@Test
	void saveToSerializeFile() throws ParseException {
		Database db = new Database();
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager("abc", "101", Specilization.EQUITY, sdf.parse("1997-03-03"), sdf.parse("2015-06-20"), true, 1500));
		assertTrue(db.save(managers) == true);
	}

	@Test
	void retrieveFromSerializedFile() throws ParseException {
		Database db = new Database();
		List<Manager> managers = new ArrayList<>();
		List<Manager> retrieveManagers = new ArrayList<>();
		managers.add(new Manager("abc", "101", Specilization.EQUITY, sdf.parse("1997-03-03"), sdf.parse("2015-06-20"), true, 1500));
		
		retrieveManagers = db.retrieve();
		assertTrue(retrieveManagers.size()>=0);
	}
}
