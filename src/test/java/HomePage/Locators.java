package HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;
import utils.ReusableMethods;

public class Locators extends ReusableMethods {

    public Locators () {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//*[@id='v']")
    public WebElement inputLink;

    @FindBy(xpath = "//form/div[2]/button[2]")
    public WebElement convertBtn;

    @FindBy(xpath = "//form/div[2]/button[1]")
    public WebElement downloadBtn;

    @FindBy(xpath = "//form/div[2]/button[2]")
    public WebElement nextBtn;
}
