package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Base;

import java.util.ArrayList;
import java.util.List;


/**
 * Test Case 5: GET SUM
 * Write a method that returns a list of two countries whose sum of bronze medals is 18.
 */
public class TestCase5 extends Base {


	@Test(description = "List of Two Countries whose sum of bronze medal is 18")
	public void countryByMedal() {
		System.out.println(bronzeMedalListCountries());
	}

	public List<String> bronzeMedalListCountries() {

		List<WebElement> countryNameBronze18 = driver.findElements(By.xpath("//table[9]/tbody[1]/tr/th[1]"));

		List<WebElement> bronzeMedal18 = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));

		List<String> countryHaving18BronzeMedal = new ArrayList<String>();

		for (int i = 1; i < bronzeMedal18.size() - 1; i++) {

			if (Integer.parseInt(bronzeMedal18.get(i).getText()) == 18) {
				countryHaving18BronzeMedal.add(countryNameBronze18.get(i).getText().trim());
			}
		}
		return countryHaving18BronzeMedal;

	}

}
