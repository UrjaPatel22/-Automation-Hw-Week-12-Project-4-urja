package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";



    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. userShouldLoginSuccessfullyWithValidCredentials
@Test

public void userShouldLoginSuccessfullyWithValidCredentials(){

    //* Enter “standard_user” username

    sendTextToElement(By.id("user-name"),"standard_user");
//* Enter “secret_sauce” password
sendTextToElement(By.id("password"),"secret_sauce");
//* Click on ‘LOGIN’ button
    clickOnElement(By.id("login-button"));
//* Verify the text “PRODUCTS”
    String expectedMessage= "Products";
    String actualMessage=getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
    Assert.assertEquals("Error Message displayed",expectedMessage,actualMessage);



}

//2. verifyThatSixProductsAreDisplayedOnPage




@Test
public void  verifyThatSixProductsAreDisplayedOnPage(){
    //* Enter “standard_user” username
    sendTextToElement(By.id("user-name"),"standard_user");
//* Enter “secret_sauce” password
    sendTextToElement(By.id("password"),"secret_sauce");
//* Click on ‘LOGIN’ button
    clickOnElement(By.id("login-button"));

    //* Verify that six products are displayed on page
    List<WebElement> labelsListOfWebElements = driver.findElements(By.xpath("//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']"));

    ArrayList<String> actualList = new ArrayList<>();
    for (WebElement element : labelsListOfWebElements) {
        actualList.add(element.getText());


    }
    int actual = actualList.size();
    String actualNumberOfItems = Integer.toString(actual);

    int expected = 6;
    String expectedNumberOfItems = Integer.toString(expected);
    Assert.assertEquals("Number of items are not matching", expectedNumberOfItems, actualNumberOfItems);


}

    @After
    public void tearDown() {

        closeBrowser();
    }

}
