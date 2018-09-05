package com.swabhavtechlabs.managertest;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.managerapp.CheckParameters;
import com.swabhavtechlabs.managerapp.Manager;
import com.swabhavtechlabs.managerapp.Specilization;

class CheckParameterTest {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	CheckParameters checkParameter = new CheckParameters();
	@Test
	void isCodeUnique() throws ParseException {
		
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager("abc", "101", Specilization.EQUITY, sdf.parse("1997-03-03"), sdf.parse("2015-06-20"), true, 1500));
		assertTrue(checkParameter.codeIsUnique("109") == true);
	}

	@Test
	void shouldJoiningDateBeGreaterThanBirthDate() throws ParseException {
		Date birthDate = sdf.parse("1997-03-03");
		Date joiningdate = sdf.parse("2015-06-20");
		assertTrue(checkParameter.joiningGreaterThanBirthDate(birthDate, joiningdate) == true);
		
	}
}
