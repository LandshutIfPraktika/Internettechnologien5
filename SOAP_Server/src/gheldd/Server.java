package gheldd;

import javax.xml.ws.Endpoint;

/**
 * Created by s-gheldd on 21.06.17.
 */
public class Server {

    public static void main(String[] args) {
        final String baseAdress = "http://localhost:8080";
        final Endpoint naz = Endpoint.publish(baseAdress + "/ws/p1", new Party("2017-08-27", "Naz", 200));
        Endpoint.publish(baseAdress + "/ws/p2", new Party("2017-09-21", "Flo", 10));
        Endpoint.publish(baseAdress + "/ws/p3", new Party("2017-10-01", "Cham", 1));
        Endpoint.publish(baseAdress + "/ws/w", new Weather());


        System.out.println("is running!");
    }


}
