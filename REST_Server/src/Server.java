import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by s-gheldd on 22.06.17.
 */

@ApplicationPath("/")
public class Server extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();

        classes.add(DJService.class);


        return classes;
    }
}
