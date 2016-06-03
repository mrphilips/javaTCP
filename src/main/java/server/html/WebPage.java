package main.java.server.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by david on 03/06/2016.
 */
public class WebPage {
    private String localUrl;
    private String serverURL;

    private File file;

    public WebPage(String localUrl){
        this.localUrl=localUrl;
    }

    public void load(){
        file = new File(localUrl);
    }

    public void setServerUrl(String serverURL){
        this.serverURL = serverURL;
    }

   public String readFile() {

       try {
           BufferedReader br = new BufferedReader(new FileReader(localUrl));

               StringBuilder sb = new StringBuilder();
               String line = br.readLine();

               while (line != null) {
                   sb.append(line);
                   sb.append("\n");
                   line = br.readLine();
               }

           br.close();
           return sb.toString();
       }

       catch (Exception e){
            return "";
       }
    }
}
