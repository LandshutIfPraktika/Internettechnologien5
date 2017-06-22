package gheldd;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Random;

/**
 * Created by s-gheldd on 22.06.17.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class Weather {
    final Random rand = new Random();

    @WebMethod
    public int getTemperature(final String datum) {
        return rand.nextInt(30);
    }


    @WebMethod
    public String getRain(final String datum) {

        if (rand.nextBoolean()) {
            return "Sonne";
        }
        return "Regen";
    }

}
