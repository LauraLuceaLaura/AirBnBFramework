package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import shareData.ShareData;

public class CheckingPage {

    @FindBy(css = "div[data-testid='little-search-icon']")
    private WebElement clickSearch;

    @FindBy(id = "bigsearch-query-location-input")
    private WebElement selectLocation;

    @FindBy(css = "div[data-testid='structured-search-input-field-split-dates-0']")
    private WebElement selectCheckinDate;

    @FindBy(css = "div[data-testid='structured-search-input-field-split-dates-1']")
    private WebElement selectCheckoutDate;

    @FindBy(css = "div[data-testid='structured-search-input-field-guests-button']")
    private WebElement addGuests;

    @FindBy(css = "button[data-testid='stepper-adults-increase-button']")
    private WebElement increaseAdults;

    @FindBy(css = "button[data-testid='stepper-children-increase-button']")
    private WebElement increaseChildren;

    @FindBy(css = "button[data-testid='structured-search-input-search-button']")
    private WebElement searchButton;



    public void aboutVacation()
    {
        clickSearch.click();
        selectLocation.click();
        selectLocation.sendKeys("Rome, Italy");
        selectCheckinDate.click();
        selectCheckinDate.sendKeys("13");
        selectCheckoutDate.click();
        selectCheckoutDate.sendKeys("20");
        addGuests.click();
        increaseAdults.click();
        increaseAdults.click();
        increaseChildren.click();
        searchButton.click();
    }


}
