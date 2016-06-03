package main.java.server.http.responses;

import main.java.server.html.WebPage;

/**
 * Created by david on 03/06/2016.
 */
public class Response {
    private String responseString;
    private int status;

    public Response(int status){
        this.status = status;

        makeResponse();
    }

    public void makeResponse(){
        this.responseString = "HTTP/1.1 200 OK\n\n";
    }

    public String getResponseString(){return responseString + new WebPage("resources/html/index.html").readFile();}
}
