package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestStudent{
	Student st = new Student();
	
	 @Test
	   public void cgpa() {
	   
	    
	      st.setName("abdulla");
	      st.setRoll(007);
	      double cgp = st.cgpa(9);
	      Assert.assertEquals(9, cgp, 0.0, "9");
	   }
}