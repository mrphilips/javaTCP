package main.test.server.html;

import main.java.server.html.Resource;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by david on 03/06/2016.
 */
public class WebTest {
    String url = "resources/html/tuto.html";
    Resource resource;

    @Test
    public void readTest(){
        resource = new Resource(url);
        try {
            System.out.println(resource.readFile());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
