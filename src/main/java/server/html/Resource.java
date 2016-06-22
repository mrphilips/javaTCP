package main.java.server.html;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by david on 03/06/2016.
 */
public class Resource {
    private String localUrl;
    private String serverURL;

    private File file;

    public Resource(String localUrl){
        this.localUrl=localUrl;
    }

    public void load(){
        file = new File(localUrl);
    }

    public void setServerUrl(String serverURL){
        this.serverURL = serverURL;
    }

   public String readFile() throws IOException {
       return new String(fileBytes(),"UTF-8");
    }

    public byte[] fileBytes() throws IOException{
        load();
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try
        {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            for (int i = 0; i < bFile.length; i++)
            {
               // System.out.print((char) bFile[i]);
            }
        }
        catch (Exception e)
        {
            System.out.println(localUrl);
            //e.printStackTrace();
        }
        return bFile;
    }


}
