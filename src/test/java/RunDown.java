import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ReusableMethods;

public class RunDown extends ReusableMethods {

    @DataProvider
    public Object[] musLinks() {
        return new Object[]{
                "https://music.youtube.com/watch?v=XTWCQohpYTA&list=PLBwHLBEVeuF3Q96s_ee3duu2CJpU5Z9ru",
                "https://music.youtube.com/watch?v=wXbPo9fYf2E&list=PLBwHLBEVeuF2i1B9b0AfeHugQuilcuy3r",
                "https://music.youtube.com/watch?v=Ucmo6hDZRSY&list=PLBwHLBEVeuF2i1B9b0AfeHugQuilcuy3r",
                "https://music.youtube.com/watch?v=j65_xyAlkns&list=PLBwHLBEVeuF2i1B9b0AfeHugQuilcuy3r",
                "https://music.youtube.com/watch?v=dEOmR6b0IqM&list=PLBwHLBEVeuF2i1B9b0AfeHugQuilcuy3r"
        };
    }

    @Test(dataProvider = "musLinks")
    public void run(String link) {
        Locators loc = new Locators();

        driver.get("https://y2mate.nu/ysM1/");

        mySendKeys(loc.inputLink, link);

        myClick(loc.convertBtn);

        verifyContainsText(loc.downloadBtn, "Download");
        myClick(loc.downloadBtn);

        myClick(loc.nextBtn);
        threadWait(2);
    }
}
