package org.kurdev.YM_music_down.util;
/*1.Захардкодить список песен из листа 3-5шт
 * 2.Найти сайт с которого можно скачать музыку (чтобы скачивание начиналось сразу)
 * 2.1 Сайт https://ru.hitmotop.com/
 * 3.При помощи селениум(Selenium) попробовать скачать одну песню с сайта
 * 4.Сделать обработку списка*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MusicDownloader {

    public void downloadList(List<String> strings) {
        strings.forEach(this::download);
    }

    public void download(String s) {
        s = s.replaceAll(" ", "+").toLowerCase();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Пользователь\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ru.hitmotop.com/search?q=" + s);
        WebElement buttonDownloadFirst = driver.findElement(By.className("track__download-btn"));
        buttonDownloadFirst.click();
        driver.close();
    }
}
