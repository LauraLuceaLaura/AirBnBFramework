package shareData;


import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShareData {

    public WebDriver driver;


    @Test
    public void prepareDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com.ro/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        By clickCookie = new By.ByCssSelector("button[class='_148dgdpk']");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(clickCookie));
        WebElement clickOk = driver.findElement(clickCookie);
        clickOk.click();


        By clickLocator = By.xpath("//div[@data-testid='little-search']/button[1]/div");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(clickLocator));

        WebElement clickSearch = driver.findElement(clickLocator);
        clickSearch.click();

        WebElement selectLocation = driver.findElement(By.id("bigsearch-query-location-input"));
        selectLocation.click();
        selectLocation.sendKeys("Rome, Italy");

        WebElement selectCheckinDate = driver.findElement(By.cssSelector("div[data-testid='structured-search-input-field-split-dates-0']"));
        selectCheckinDate.click();
        WebElement selectDate = driver.findElement(By.cssSelector("div[data-testid='calendar-day-13.09.2022']"));
        selectDate.click();

        WebElement selectCheckoutDate = driver.findElement(By.cssSelector("div[data-testid='calendar-day-20.09.2022']"));
        selectCheckoutDate.click();

        WebElement addGuests = driver.findElement(By.cssSelector("div[data-testid='structured-search-input-field-guests-button']"));
        addGuests.click();

        WebElement increaseAdults = driver.findElement(By.cssSelector("button[data-testid='stepper-adults-increase-button']"));
        increaseAdults.click();
        increaseAdults.click();

        WebElement increaseChildren = driver.findElement(By.cssSelector("button[data-testid='stepper-children-increase-button']"));
        increaseChildren.click();

        WebElement searchButton = driver.findElement(By.cssSelector("button[data-testid='structured-search-input-search-button']"));
        searchButton.click();

        Thread.sleep(3500);

        WebElement verifyLocation = driver.findElement(By.xpath("//button[@data-index='0']/div"));
        String actualLocation = verifyLocation.getText();
        String expectedLocation = "Rome";
        Assert.assertEquals(actualLocation,expectedLocation);

        WebElement verifyDate = driver.findElement(By.cssSelector("button[data-index='1']>div"));
        String actualDate =verifyDate.getText();
        String expectedDate = "13–20 sept.";
        Assert.assertEquals(actualDate,expectedDate);

        WebElement verifyGuest = driver.findElement(By.cssSelector("button[data-index='2']>div"));
        String actualGuests = verifyGuest.getText();
        Assert.assertTrue(actualGuests.contains("3"));

//        WebElement filterElement = driver.findElement(By.cssSelector("span[class='t1psh3xd dir dir-ltr']"));
//        filterElement.click();

        By validateText = By.xpath("//div[@data-section-id='EXPLORE_STRUCTURED_PAGE_TITLE']");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(validateText));

        By filterElement = By.cssSelector("span[class='t1psh3xd dir dir-ltr']");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(filterElement));
        WebElement click = driver.findElement(filterElement);
        click.click();

//        WebElement roomNumber = driver.findElement(By.xpath("//div[@aria-label='Dormitoare']/div[2]//div[@id='menuItemButton-5']/button"));
//        roomNumber.click();

    }



}
