import cloudatcost.CACClient;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.junit.Test;

/**
 * Created by enrico on 01/12/15.
 */
public class CACClientTest {

    private MockWebServer server = new MockWebServer();

    @Test
    public void testMe() throws Exception {

        CACClient cacClient = new CACClient("", "");
        System.out.println();
    }

}
