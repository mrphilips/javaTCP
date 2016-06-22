package main.java.server;

import main.java.server.http.processes.GetResourceProcess;
import main.java.server.http.processes.Process;
import main.java.server.http.requests.Request;
import main.java.server.http.responses.Response;

/**
 * Created by david on 03/06/2016.
 */
public class RequestManager {
    private Request request;
    private Response response;

    public RequestManager(Request request){
        this.request=request;
        this.response = new Response();

    }

    public void handleRequest(){
        request.extractDatas();

        Process process = new GetResourceProcess(request,response);
        process.process();

        response = process.getResponse();


    }

    public Request getRequest(){return request;}

    public Response getResponse(){
        return response;
    }
}
