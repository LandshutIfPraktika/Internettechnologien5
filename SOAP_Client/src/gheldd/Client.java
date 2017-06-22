package gheldd;

/**
 * Created by s-gheldd on 22.06.17.
 */
public class Client {
    public static void main(String[] args) {
        final PartyService partyService = new PartyService();
        final Party partyPort = partyService.getPartyPort();

        System.out.println(partyPort.amountOfGuests());
        System.out.println(partyPort.invite("Hallo"));
        System.out.println(partyPort.invite("Welt"));
        System.out.println(partyPort.getDatum());
        System.out.println(partyPort.getGuestList().getItem().stream().reduce((s, s2) -> s +", "+ s2).get());

        final WeatherService weatherService = new WeatherService();
        final Weather weatherPort = weatherService.getWeatherPort();
        System.out.println(weatherPort.getTemperature(partyPort.getDatum()));
        System.out.println(weatherPort.getRain(partyPort.getDatum()));


    }
}
