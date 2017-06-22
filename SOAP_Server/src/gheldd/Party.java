package gheldd;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Created by s-gheldd on 21.06.17.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)


public class Party {


    final ArrayList<String> guestList;
    final int max;
    final String datum;
    final String dj;


    public Party(final String datum, final String dj, final int max) {

        this.datum = datum;
        this.dj = dj;
        this.max = max;
        guestList = new ArrayList<>();
    }

    @WebMethod
    public String getDatum() {
        return this.datum;
    }

    @WebMethod
    public String getDj() {
        return this.dj;
    }

    @WebMethod
    public int amountOfGuests() {
        return this.guestList.size();
    }

    @WebMethod
    public String[] getGuestList() {
        return this.guestList.toArray(new String[guestList.size()]);
    }

    @WebMethod
    public synchronized boolean invite(final String guest) {
        System.err.println("Adding guest " + guest + " to list.");
        if (guestList.size() < max) {
            guestList.add(guest);
            return true;
        }

        return false;
    }
}
