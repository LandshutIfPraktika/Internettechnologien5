import javax.ws.rs.*;
import java.util.HashMap;

/**
 * Created by s-gheldd on 22.06.17.
 */

@Path("/dj")
public class DJService {

    private final HashMap<String, String> memory;

    public DJService() {
        memory = new HashMap<>();


        memory.put("Naz", "Spotify");
        memory.put("Flo", "RadioX");

    }


    @GET
    @Produces("text/plain")
    public String getDjs() {
        return memory.keySet().stream().reduce((s, s2) -> s + ", " + s2).orElse("");
    }

    @POST
    @Produces("text/plain")
    @Consumes("text/plain")
    public String getPlayLists(final String dj) {
        final String playList = memory.get(dj);
        if (playList != null) {
            return playList;
        }

        return "no dj of name " + dj + "found";
    }

}
