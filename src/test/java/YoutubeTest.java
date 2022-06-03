import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class YoutubeTest {
    public static WebDriver webDriver;
    private final String URL = "https://www.youtube.com/";

    @BeforeAll
    public static void setDriverProperty() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeEach
    public void setWebDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void videoPlayTest() throws InterruptedException {
        // webDriver.get(URL);
        webDriver.get("https://www.youtube.com/watch?v=1CqGeAmVu1I");
        webDriver.manage().deleteAllCookies();

        // Thread.sleep(1500);
        WebElement refuseCookieButton = webDriver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div/div[6]/div[1]/ytd-button-renderer[1]/a/tp-yt-paper-button"));
        refuseCookieButton.click();


        // Play/Stop
        Thread.sleep(1500);
        WebElement playButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[33]/div[2]/div[1]/button"));
        playButton.click();
        Thread.sleep(5000);
        WebElement stopButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[33]/div[2]/div[1]/button"));
        stopButton.click();

        // Screen size
        WebElement miniPlayerButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[33]/div[2]/div[2]/button[6]"));
        miniPlayerButton.click();
        WebElement stretchButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[15]/div/button[2]"));
        stretchButton.click();

        WebElement movieModeButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[2]/button[8]"));
        movieModeButton.click();
        WebElement normalLookButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[2]/button[8]"));
        normalLookButton.click();

        WebElement fullScreenButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[2]/button[10]"));
        fullScreenButton.click();
        WebElement exitFullScreenButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[2]/button[10]"));
        exitFullScreenButton.click();

        // Video setting (annotations, speed, quality)
        playButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[1]/button"));
        playButton.click();
        WebElement videoSettingsButton = webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[2]/button[4]"));
        videoSettingsButton.click();
        WebElement annotationsButton = webDriver.findElement(By.xpath("//*[@id=\"ytp-id-17\"]/div/div/div[1]"));
        annotationsButton.click();
        WebElement playSpeedButton = webDriver.findElement(By.xpath("//*[@id=\"ytp-id-17\"]/div/div/div[2]/div[2]"));
        playSpeedButton.click();
        videoSettingsButton.click();
        videoSettingsButton.click();
        WebElement qualityButton = webDriver.findElement(By.xpath("//*[@id=\"ytp-id-17\"]/div/div/div[4]/div[2]"));
        qualityButton.click();
        videoSettingsButton.click();
    }

    @Test
    public void ChannelTest() throws InterruptedException {
        webDriver.get("https://www.youtube.com/");
        WebElement popupkiller = webDriver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div/div[6]/div[1]/ytd-button-renderer[1]/a/tp-yt-paper-button"));
        popupkiller.click();
        WebElement login = webDriver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer"));
        login.click();


        WebElement loginemail = webDriver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        loginemail.sendKeys("tesztelek19841@freemail.hu\n");
        WebElement loginpassw = webDriver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        loginpassw.sendKeys("TEsztelek19841\n");

        Thread.sleep(1500);
        webDriver.get("https://www.youtube.com/user/PamKutya");

        WebElement subscribeButton = webDriver.findElement(By.xpath("//*[@id=\"subscribe-button\"]/ytd-subscribe-button-renderer/tp-yt-paper-button"));
        subscribeButton.click();

        Thread.sleep(5000);
        subscribeButton.click();
        WebElement unsubscribeButton = webDriver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/yt-confirm-dialog-renderer/div[2]/div/yt-button-renderer[3]/a/tp-yt-paper-button"));
        unsubscribeButton.click();
    }

    @Test
    public void TestPlayList() throws InterruptedException {
        webDriver.get("https://www.youtube.com/");
        webDriver.manage().deleteAllCookies();
        WebElement popupkiller = webDriver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div/div[6]/div[1]/ytd-button-renderer[1]/a/tp-yt-paper-button"));
        popupkiller.click();
        WebElement login = webDriver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer"));
        login.click();


        WebElement loginemail = webDriver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        loginemail.sendKeys("tesztelek19841@freemail.hu\n");
        WebElement loginpassw = webDriver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        loginpassw.sendKeys("TEsztelek19841\n");

        // First video
        Thread.sleep(1500);
        webDriver.get("https://www.youtube.com/watch?v=lnyZv9Vslts");

        // WebDriverWait wait = new WebDriverWait(webDriver, 20);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ad-text:6\"]"))).click();

        WebElement saveButton = webDriver.findElement(By.xpath("//*[@id=\"top-level-buttons-computed\"]/ytd-button-renderer[3]/a"));
        saveButton.click();
        WebElement createNewPlaylist = webDriver.findElement(By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item"));
        createNewPlaylist.click();
        WebElement inputPlaylistName = webDriver.findElement(By.xpath("//*[@id=\"input-1\"]/input"));
        inputPlaylistName.sendKeys("My new Playlist\n");

        // Second video
        // Thread.sleep(1500);
        webDriver.get("https://www.youtube.com/watch?v=dpmAY059TTY");
        // WebDriverWait wait = new WebDriverWait(webDriver, 20);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ad-text:6\"]"))).click();
        saveButton = webDriver.findElement(By.xpath("//*[@id=\"top-level-buttons-computed\"]/ytd-button-renderer[3]/a"));
        saveButton.click();
        WebElement addToMyPlaylist = webDriver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[2]/ytd-playlist-add-to-option-renderer[2]/tp-yt-paper-checkbox/div[2]/div/div/yt-formatted-string[1]"));
        addToMyPlaylist.click();

        // Third video
        // Thread.sleep(1500);
        webDriver.get("https://www.youtube.com/watch?v=zRIbf6JqkNc");
        // WebDriverWait wait = new WebDriverWait(webDriver, 20);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ad-text:6\"]"))).click();
        saveButton = webDriver.findElement(By.xpath("//*[@id=\"top-level-buttons-computed\"]/ytd-button-renderer[3]/a"));
        saveButton.click();
        addToMyPlaylist = webDriver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-add-to-playlist-renderer/div[2]/ytd-playlist-add-to-option-renderer[2]/tp-yt-paper-checkbox/div[2]/div/div/yt-formatted-string[1]"));
        addToMyPlaylist.click();

        webDriver.get("https://www.youtube.com/feed/library");

        WebElement lookPlaylist = webDriver.findElement(By.xpath("//*[@id=\"view-more\"]/a"));
        lookPlaylist.click();

        WebElement firstVideoOptions = webDriver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-playlist-video-list-renderer/div[3]/ytd-playlist-video-renderer[1]/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon"));
        firstVideoOptions.click();
        WebElement removeFromPlaylist = webDriver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[4]/tp-yt-paper-item/yt-formatted-string/span[1]"));
        removeFromPlaylist.click();
    }
}



