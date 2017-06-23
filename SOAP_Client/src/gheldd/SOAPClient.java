package gheldd;

import java.net.URL;

/**
 * Created by s-gheldd on 23.06.17.
 */
public class SOAPClient {


    public static void main(String[] args) throws Exception {
        final PartyService partyService1 = new PartyService(new URL("http://localhost:8080/ws/p1?wsdl"));
        final Party partyPort1 = partyService1.getPartyPort();
        final PartyService partyService2 = new PartyService(new URL("http://localhost:8080/ws/p2?wsdl"));
        final Party partyPort2 = partyService2.getPartyPort();
        final PartyService partyService3 = new PartyService(new URL("http://localhost:8080/ws/p3?wsdl"));
        final Party partyPort3 = partyService3.getPartyPort();

        System.out.println(partyPort1.amountOfGuests());
        System.out.println(partyPort1.invite("Hallo"));
        System.out.println(partyPort1.invite("Welt"));
        System.out.println(partyPort1.getDatum());
        System.out.println(partyPort1.getGuestList().getItem().stream().reduce((s, s2) -> s + ", " + s2).get());

        System.out.println(partyPort2.amountOfGuests());
        System.out.println(partyPort2.invite("Hallo"));
        System.out.println(partyPort2.invite("Welt"));
        System.out.println(partyPort2.getDatum());
        System.out.println(partyPort2.getGuestList().getItem().stream().reduce((s, s2) -> s + ", " + s2).get());

        System.out.println(partyPort3.amountOfGuests());
        System.out.println(partyPort3.invite("Hallo"));
        System.out.println(partyPort3.invite("Welt"));
        System.out.println(partyPort3.getDatum());
        System.out.println(partyPort3.getGuestList().getItem().stream().reduce((s, s2) -> s + ", " + s2).get());

        final WeatherService weatherService = new WeatherService();
        final Weather weatherPort = weatherService.getWeatherPort();
        System.out.println(weatherPort.getTemperature(partyPort1.getDatum()));
        System.out.println(weatherPort.getRain(partyPort1.getDatum()));


    }


}
