package main.java.server.http.requests;

/**
 * Created by david on 03/06/2016.
 */
public class Request {
    private String fullRequest;
    private String url;

    public Request(String fullRequest){
        this.fullRequest= fullRequest;
    }

    public void extractDatas(){
        String[] lines = fullRequest.split("\n");

        String header = lines[0];

        url = header.split(" ")[1];

        System.out.println(url);

    }

    public String getURL(){return url;}

    @Override
    public String toString(){
        return fullRequest;
    }
}
