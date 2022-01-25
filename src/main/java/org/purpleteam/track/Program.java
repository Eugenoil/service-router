package org.purpleteam.track;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Program {
    /***
     * Example of creating listening server. Var <request> receive HttpData which contains
     * Map httpData.parameters() and httpData.method() to understand what data need to put in sendResponse()
     */
    public static void listen() throws Exception {
        HttpListener rs = new HttpListener();
        System.out.println("Service listener started");
        HttpData request;
        while (true) {
            request = rs.listen();
            // some operation with request
            // check request.parameters() and request.getMethod();
            System.out.println(request);
            HttpData httpData = new HttpData();
            httpData.setBody("<p>Hello!</p>");
            rs.sendResponse(httpData);
        }
    }

    /***
     * Example of sending request in form of HttpData. Parameters included in headers, not inside URL
     */
    public static void sendHttpData() {
        HttpData httpData = new HttpData();
        httpData.setUrl("localhost:8080");
        httpData.addParamenets("trackings", "new");
        httpData.addParamenets("id", "1");
        httpData.addParamenets("task_name", "New task started");
        httpData.setHttpMethod("POST");
        System.out.println(new HttpSender().sendRequestInUrl(httpData));
    }

    /***
     * Example of sending HttpData in URL (not headers)
     */
    public static void sendHttpDataInUrl() {
        HttpData httpData = new HttpData();
        httpData.setUrl("localhost:8080");
        httpData.addParamenets("trackings", "list");
        httpData.addParamenets("id", "1");
        httpData.setHttpMethod("GET");
        System.out.println(new HttpSender().sendRequestInUrl(httpData));
    }

    /***
     * Example of using and modifying SOAP
     * @param soap string contents of SOAP(XML)
     */
    public static void string2Xml(String soap) throws Exception {
        FormatUtils fu = new FormatUtils();
        Document root = (Document) fu.string2XML(soap);
        Node test = fu.findNode(root, "symbol", true);
        Node parentNode = test.getParentNode();
        parentNode.removeChild(test);
        for (int i = 0; i < 5; i++) {
            Node newNode = test.cloneNode(true);
            newNode.setTextContent("" + i);
            parentNode.appendChild(newNode);
        }
        System.out.println(fu.xml2String(root));
    }

    public static void xml2json(String soap) {
        FormatUtils fu = new FormatUtils();
        JSONObject json = fu.xml2Json(soap);
        Object item = fu.findData(json, "symbol", false);
        if (item instanceof String)
            System.out.println(item);
        System.out.println(json);
    }

    public static void main(String[] args) throws Exception {
//        sendHttpData();
//        listen();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            .append("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">")
            .append("<SOAP-ENV:Body>")
            .append("<ns0:GetUserIdList>")
                .append("<symbol>ALL</symbol>")
            .append("</ns0:GetUserIdList>")
            .append("</SOAP-ENV:Body>")
            .append("</SOAP-ENV:Envelope>");
        string2Xml(sb.toString());
//        xml2json(sb.toString());

//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        File file = new File(rootPath + "jsonfile.txt");
//        String tmp = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
//        ServiceRouter sr = new ServiceRouter();
//        System.out.println(sr.makeTelegramResponse(tmp));
    }
}
