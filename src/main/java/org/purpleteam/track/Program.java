package org.purpleteam.track;

import java.util.List;

public class Program {

    public static void main(String[] args) throws Exception {
        HttpListener rs = new HttpListener();
        System.out.println("Service listener started");
        HttpData request;
        while (true) {
            request = rs.listen();
            // some operation with request
            System.out.println(request);
            HttpData httpData = new HttpData();
            httpData.setBody("<p>Hello!</p>");
            rs.sendResponse(httpData);
        }
    }
}
