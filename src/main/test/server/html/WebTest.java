package main.test.server.html;

import main.java.server.html.WebPage;
import org.junit.Test;

import java.io.File;

/**
 * Created by david on 03/06/2016.
 */
public class WebTest {
    String url = "resources/html/index.html";
    WebPage webPage;

    @Test
    public void readTest(){
        webPage = new WebPage(url);
        System.out.println(webPage.readFile());
    }
}
