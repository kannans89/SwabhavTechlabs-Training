package com.swabhavtechlabs.managertest;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.managerapp.Administrator;
import com.swabhavtechlabs.managerapp.BankMenu;
import com.swabhavtechlabs.managerapp.CodeIsNotUnique;
import com.swabhavtechlabs.managerapp.GetAndPrintDetails;
import com.swabhavtechlabs.managerapp.JoindateBeforeBirthDate;
import com.swabhavtechlabs.managerapp.Manager;
import com.swabhavtechlabs.managerapp.Specilization;

class AdministratorTest {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	Administrator admin = new Administrator();
	GetAndPrintDetails getAndPrint = new GetAndPrintDetails();
	
	@Test
	void BankTest() throws ParseException, JoindateBeforeBirthDate, CodeIsNotUnique {
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager("abc", "101", Specilization.EQUITY, sdf.parse("1997-03-03"), sdf.parse("2015-06-20"), true, 1500));
		getAndPrint.printDetails(managers);
	}

	@Test
	void addManagerToList() throws ParseException, JoindateBeforeBirthDate, CodeIsNotUnique {
		List<Manager> managers = new ArrayList<>();
		admin.addManager(new Manager("abc", "101", Specilization.EQUITY, sdf.parse("1997-03-03"), sdf.parse("2015-06-20"), true, 1500));
	}
}
