package core;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.*;
import java.util.*;
import org.testng.annotations.*;

public class CreditCardValidationTest  {	
	String csvFile = "./cc.csv";

	@DataProvider(name = "dp")
	public Iterator<String[]> a2d() throws InterruptedException, IOException {
		String cvsLine = "";
		String[] a = null;
		ArrayList<String[]> al = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((cvsLine = br.readLine()) != null) {
			a = cvsLine.split(",");al.add(a);}
			br.close();
		return al.iterator();
	}

	@Test(dataProvider = "dp", enabled = true, groups = "type")
	public void type(String cc_type, String cc_number, String cc_exp, String cc_cvv) {
		assertThat(CreditCardValidation.type(cc_type, cc_number), describedAs("Credit Card Type: " + cc_type + ", should be valid", is(true)));
	}
	
	@Test(dataProvider = "dp", enabled = true, groups = "exp")
	public void exp(String cc_type, String cc_number, String cc_exp, String cc_cvv) {
		assertThat(CreditCardValidation.exp(cc_exp), describedAs("Credit Card Exp: " + cc_exp + ", should be not expired", is(true)));
	}

	@Test(dataProvider = "dp", enabled = true, groups = "cvv")
	public void cvv(String cc_type, String cc_number, String cc_exp, String cc_cvv) {
		assertThat(CreditCardValidation.cvv(cc_type, cc_cvv), describedAs("Credit Card CVV: " + cc_cvv + ", should be valid", is(true)));
	}

	@Test(dataProvider = "dp", enabled = true, groups = "luhn")
	public void luhn(String cc_type, String cc_number, String cc_exp, String cc_cvv) {
		assertThat(CreditCardValidation.luhn(cc_number), describedAs("Luhn of: " + cc_number + ", should be valid", is(true)));
	
	}
	
	@Test
	public void test_05(){
	    CreditCardValidation o = new CreditCardValidation();
	}
	

	
	
	
}
