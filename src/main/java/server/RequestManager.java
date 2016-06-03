package main.java.server;

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

        request.extractDatas();

        //System.out.println(request);

        this.response = new Response(200);
    }

    public Request getRequest(){return request;}

    public String getResponse(){
        if(request.getURL().equals("/mystyle.css"))
            return "h1{background-color:grey;" +
                    "text-align:center;}";
        return response.getResponseString();
    }
}
