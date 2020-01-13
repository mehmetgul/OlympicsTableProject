package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Base;
import java.util.List;

/**
 * Test Case 4: GET INDEX
 * Write a method that takes country name and returns the row and column number of
 * that country in that table. Return type must be an array of ints. Array length must be 2.
 */

public class TestCase4 extends Base {


	@Test(description = "Find the given country row and column number")
	public void getIndex() {

		String desiredCountry="Japan";

		System.out.println("Row and Column Nanumber of " +desiredCountry+ " is "+ rowColumn(desiredCountry));
		// System.out.println(rowColumn());
	}

	public String rowColumn(String country) {

		List<WebElement> desiredCountryList = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		String rowColumn = "";
		for (int i = 0; i < desiredCountryList.size(); i++) {

			if (country.equalsIgnoreCase(desiredCountryList.get(i).getText().trim().substring(0, desiredCountryList.get(i).getText().trim().indexOf(" ")))) {
				rowColumn += (i + 1) + " 2";
			}
		}
		return rowColumn;
	}
}
