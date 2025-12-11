import HomePage.Locators;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReusableMethods;

public class runDownload extends ReusableMethods {

    private static int counter = 0;
    private static int totalLinks = 0;

    @DataProvider
    public Object[] musLinks() {
        Object[] links = new Object[]{
                ""
        };

        totalLinks = links.length;
        return links;
    }

    @Test(dataProvider = "musLinks")
    public void run(String link) {
        Locators loc = new Locators();

        driver.get("https://y2mate.nu/ysM1/");

        mySendKeys(loc.inputLink, link);
        myClick(loc.convertBtn);

        verifyContainsText(loc.downloadBtn, "Download");
        myClick(loc.downloadBtn);

        counter++;
        threadWait(2);
        myClick(loc.nextBtn);

        if (counter == totalLinks) {
            threadWait(5);
        }
    }
}
