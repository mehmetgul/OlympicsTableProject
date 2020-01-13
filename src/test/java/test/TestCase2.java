package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.Base;

import java.util.List;

/**
 * Test Case 2: THE FIRST FROM THE BOTTOM
 * Write a method that returns the name of the country with the smallest number of gold medals.
 * Write a method that returns the name of the country with the smallest number of silver medals.
 * Write a method that returns the name of the country with the smallest number of bronze medals.
 */

public class TestCase2 extends Base {

	@Test(description ="Verify the name of the country got least medals by category" )
	public void theLeastMedals() throws InterruptedException {

		Thread.sleep(2000);
		System.out.println(goldMedals());
		System.out.println(silverMedals());
		System.out.println(bronzeMedals());
		System.out.println(leastMedals());

	}

	public String goldMedals() {
		List<WebElement> leastGoldCountry = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		List<WebElement> leastGoldNo = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]"));

		int min = Integer.parseInt(leastGoldNo.get(0).getText());
		int countryRank = 0;

		for (int i = 1; i < leastGoldNo.size() - 1; i++) {
			//in table 11-86 is jumping other table cells and due to that I have put try-catch block to avoid string-integer conversion error.
			try {
				if (Integer.parseInt(leastGoldNo.get(i).getText()) < min) {
					min = Integer.parseInt(leastGoldNo.get(i).getText());
					countryRank = i;
				}
			}catch (Exception e){

			}
		}
		return leastGoldCountry.get(countryRank).getText().trim();

	}


	public String silverMedals() {

		List<WebElement> silverCountry = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		List<WebElement> silverNo = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));

		int min = Integer.parseInt(silverNo.get(0).getText());
		int countryRank = 0;

		for (int i = 1; i < silverNo.size() - 1; i++) {

			try {
				if (Integer.parseInt(silverNo.get(i).getText()) < min) {

					min = Integer.parseInt(silverNo.get(i).getText());
					countryRank = i;

				}
			}catch (Exception e){

			}
		}

		return silverCountry.get(countryRank).getText().trim();
	}

	public String bronzeMedals() {

		List<WebElement> bronzeMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		List<WebElement> bronzeMedalsNo = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]"));

		int min = Integer.parseInt(bronzeMedalsNo.get(0).getText());
		int countryRank = 0;

		for (int i = 1; i < bronzeMedalsNo.size() - 1; i++) {

			try {
				if (Integer.parseInt(bronzeMedalsNo.get(i).getText()) < min) {

					min = Integer.parseInt(bronzeMedalsNo.get(i).getText());
					countryRank = i;

				}
			}catch(Exception e){

			}
		}

		return bronzeMedals.get(countryRank).getText().trim();

	}

	public String leastMedals() {


		List<WebElement> totalMedals = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[5]"));
		List<WebElement> country = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		int min = Integer.parseInt(totalMedals.get(0).getText());
		int countryRank = 0;

		for (int i = 1; i < totalMedals.size() - 1; i++) {

			try {
				if (Integer.parseInt(totalMedals.get(i).getText()) < min) {
					min = Integer.parseInt(totalMedals.get(i).getText());
					countryRank = i;

				}
			}catch (Exception e){

			}
		}

		return country.get(countryRank).getText().trim();
	}

}
