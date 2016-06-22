package main.test.server.http.processes;

import main.java.server.http.processes.GetResourceProcess;
import main.java.server.http.requests.Request;
import main.java.server.http.responses.Response;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by david on 04/06/2016.
 */
public class ProcessResourceTest {



    String fullRequest = "GET /resources/html/tuto.html HTTP/1.1\n" +
            "Host: localhost:8080\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 6.2; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0\n" +
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
            "Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3\n" +
            "Accept-Encoding: gzip, deflate\n" +
            "Cookie: _ga=GA1.1.198304642.1446804796\n" +
            "Connection: keep-alive";

    Request request;
    Response response;
    GetResourceProcess getResourceProcess;

    @Test
    public void test(){
        request = new Request(fullRequest);

        request.extractDatas();
        response = new Response();

        getResourceProcess = new GetResourceProcess(request,response);
        getResourceProcess.process();

        assertEquals(getResourceProcess.getResponse().getStatus(),200);
    }

    @Test
    public void regexTest(){
        String patternGET = "GET|POST \\/([^ ]*) HTTP\\/[0-9]\\.[0-9]" ;
        Pattern pattern = Pattern.compile(patternGET);

        Matcher matcher = pattern.matcher(request.getHeader());
    }
}
