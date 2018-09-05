package com.swabhavtechlabs.managertest;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.managerapp.Manager;

class ManagerTest {
	Manager manager = new Manager();
	@Test
	void checkFormattedString() {
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date = new Date();
		String formattedDate = formatter.format(date);
		formattedDate = manager.modifyString(formattedDate);
		System.out.println(formattedDate);
	}

}
