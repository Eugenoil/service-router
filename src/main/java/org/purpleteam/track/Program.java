package org.purpleteam.track;

public class Program {

    public static void main(String[] args) throws Exception {
        RequestListener rs = new RequestListener("serviceAccountant");
        System.out.println("Service listener started");
        String request;
        while (true) {
            request = rs.listen();
            // some operation with request
            System.out.println(request);
            rs.sendResponse("<p>Hello!</p>");
        }
    }
}
