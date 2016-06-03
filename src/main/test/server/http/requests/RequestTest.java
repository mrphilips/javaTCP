package main.test.server.http.requests;

import org.junit.Test;
import main.java.server.http.requests.Request;

import static org.junit.Assert.*;

/**
 * Created by david on 03/06/2016.
 */
public class RequestTest {

    String fullRequest = "GET /test.html HTTP/1.1\n" +
            "Host: localhost:8080\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 6.2; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0\n" +
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
            "Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3\n" +
            "Accept-Encoding: gzip, deflate\n" +
            "Cookie: _ga=GA1.1.198304642.1446804796\n" +
            "Connection: keep-alive";

    Request request;

    @Test
    public void extractTest(){
        request = new Request(fullRequest);

        request.extractDatas();

        assertEquals("/test.html",request.getURL());
    }
}