package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Test Case 3: COUNTRY BY MEDAL
 * Write a method that returns a list of countries by their silver medal count.
 */
public class TestCase3 extends Base {

	@Test(description = "list of countries by their silver medal count")
	public void countryByMedal() {


		System.out.println(medal18());

	}

	public Map<String,Integer> medal18() {

		List<WebElement> countrySilver18 = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		List<WebElement> silver18 = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));
		List<String> country18Silver = new ArrayList<String>();
		List<Integer> medalNumber = new ArrayList<Integer>();

		Map<String,Integer> results = new HashMap<>();



		for (int i = 1; i < silver18.size() - 1; i++) {
			results.put( countrySilver18.get(i).getText().trim(),Integer.parseInt(silver18.get(i).getText()));
		}

		return results;

	}


}
