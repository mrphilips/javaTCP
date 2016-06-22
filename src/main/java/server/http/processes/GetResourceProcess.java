package main.java.server.http.processes;

import main.java.server.http.requests.Request;
import main.java.server.http.responses.Response;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by david on 04/06/2016.
 */
public class GetResourceProcess extends Process {

    public GetResourceProcess(Request request, Response response) {
        super(request, response);
    }

    @Override
    public void process(){
        super.process();

        if(response.getStatus() != 400){
            String url = request.getURL();

           try{

               response.setStatus(200);
               response.makeHeader("HTTP/1.1 200 OK");
               response.addResource(url);
           }

           catch(IOException e){
               e.printStackTrace();
               response.setStatus(404);
               response.makeHeader("HTTP/1.1 404 Not Found");
               try {
                   response.addResource("html/errors/404.html");
               }

               catch(IOException e2){}
           }
        }
    }
}
