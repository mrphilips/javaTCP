package main.java.server.http.responses;

import com.sun.deploy.util.ArrayUtil;
import main.java.server.html.Resource;

import java.io.IOException;

/**
 * Created by david on 03/06/2016.
 */
public class Response {
    private String responseString;
    private byte[] responseBytes;
    private int status;

    private final String path = "resources/";

    public void makeHeader(String header){
        this.responseString = header+ "\n\n";
        this.responseBytes = this.responseString.getBytes();
        this.status = 0;

    }

    public void addResource(String resourceURL) throws IOException{

       // System.out.println(resourceURL);

        if(resourceURL.length()<1)
            //this.responseString+=new Resource(path+"bootstrap/dist/index.html").readFile();
            this.responseBytes = add(this.responseBytes,new Resource(path+"bootstrap/dist/index.html").fileBytes());

        else
            this.responseBytes = add(this.responseBytes,new Resource(path+resourceURL).fileBytes());

    }

    public String getResponseString(){
        //System.out.println(responseString);
        return responseString;}

    public byte[] getResponseBytes(){
        return responseBytes;
    }

    public void setStatus(int status){
        this.status=status;
    }

    public int getStatus(){return status;}

    public static byte[] add(byte[] b1, byte[] b2){
        byte[] b = new byte[b1.length+b2.length];
        for(int i = 0; i < b.length;i++){
            if(i<b1.length)
                b[i]=b1[i];
            else
                b[i]=b2[i-b1.length];
        }

        return b;

    }

}
