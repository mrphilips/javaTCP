package main.java.server.http.processes;

import main.java.server.http.requests.Request;
import main.java.server.http.responses.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by david on 04/06/2016.
 */
public class Process {
    protected Request request;
    protected Response response;

    public Process(Request request, Response response){
        this.request=request;
        this.response=response;
    }

    public void process(){
        String patternGET = "GET|POST \\/([^ ]*) HTTP\\/[0-9]\\.[0-9]" ;
        Pattern pattern = Pattern.compile(patternGET);

        Matcher matcher = pattern.matcher(request.getHeader());

        if(!matcher.find()) {
            response.setStatus(400);
            response.makeHeader("HTTP/1.1 400 Bad Request");
        }

    }

    public Request getRequest(){return request;}

    public Response getResponse(){return response;}
}
