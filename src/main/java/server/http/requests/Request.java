package main.java.server.http.requests;

/**
 * Created by david on 03/06/2016.
 */
public class Request {
    private String fullRequest;

    private String header;
    private String url;

    public Request(String fullRequest){
        this.fullRequest= fullRequest;
    }

    public void extractDatas(){
        String[] lines = fullRequest.split("\n");

        header = lines[0];

        url = header.split(" ")[1];
        if(url.startsWith("/"))
            url = url.substring(1,url.length());

        System.out.println(url);

    }

    public String getURL(){return url;}

    public String getHeader(){return header;}

    @Override
    public String toString(){
        return fullRequest;
    }
}
