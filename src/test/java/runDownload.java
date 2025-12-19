import HomePage.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReusableMethods;

public class runDownload extends ReusableMethods {

    private static int counter = 0;
    private static int downdSong = 0;
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

        int attemps = 0;
        int maxAttemps = 3;

        while (attemps < maxAttemps) {

            mySendKeys(loc.inputLink, link);
            myClick(loc.convertBtn);

            String btnText = wait.until(ExpectedConditions
                    .visibilityOf(loc.downloadBtn)).getText();

            if (btnText.equals("Download")) {
                myClick(loc.downloadBtn);
                System.out.println("\nClicked download ✅");
                System.out.println(getElementText(loc.songText));
                downdSong++;
                break;
            }

            if (btnText.equals("Back")) {
                myClick(loc.downloadBtn); // in this case retry button
                System.out.println("\nRetrying... 🔁");
                attemps++;

                if (attemps == maxAttemps) {
                    System.out.println("\nSong skipped ❌");
                    System.out.println("Song number: " + counter);
                }
            }

            wait.until(ExpectedConditions.visibilityOf(loc.downloadBtn));
        }

        counter++;

        threadWait(2);

        myClick(loc.nextBtn);

        if (counter == totalLinks) {
            threadWait(5);
            System.out.println(downdSong + " out of " + totalLinks + " downloaded");
        }
    }
}
