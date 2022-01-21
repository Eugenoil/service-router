package org.purpleteam.track;

import java.util.List;

public class Program {

    public static void main(String[] args) throws Exception {
        HttpData httpData = new HttpData();
        String botToken = "5269050893:AAEJw-bjL80xPSZDDPZ_wQCUi4af7hyZdFo";
        String apiMethod = "sendMessage";
        httpData.setUrl("https://api.telegram.org/bot" + botToken + "/" + apiMethod);
        httpData.addParamenets("chat_id", "754857287");
        httpData.addParamenets("text", "Can you see it?");

//        TextMessage
//        String test = "https://api.telegram.org/bot" + botToken + "/" + apiMethod + "?chat_id=754857287&text=Can you see it?";
//        GetUpdates
//        String test = "https://api.telegram.org/bot" + botToken + "/getUpdates?offset=0";

        String test = "https://api.telegram.org/bot\" + botToken + \"/";
        HttpSender httpSender = new HttpSender();
        System.out.println(httpSender.sendRequest(test));
//        HttpData httpData = new HttpData();
//        httpData.addParamenets();

//        HttpListener rs = new HttpListener();
//        System.out.println("Service listener started");
//        HttpData request;
//        while (true) {
//            request = rs.listen();
//            // some operation with request
//            System.out.println(request);
//            HttpData httpData = new HttpData();
//            httpData.setBody("<p>Hello!</p>");
//            rs.sendResponse(httpData);
//        }
    }
}
