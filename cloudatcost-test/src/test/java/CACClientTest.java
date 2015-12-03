import cloudatcost.CACClient;
import cloudatcost.CACHttpClient;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.junit.Test;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class CACClientTest {

    private MockWebServer server = new MockWebServer();

    @Test
    public void testMe() throws Exception {
        MockResponse mockResponse = new MockResponse();
        mockResponse.setBody("{\"status\":\"ok\",\"time\":1425064819,\"id\":\"90000\",\"data\":[]}");
        server.enqueue(mockResponse);

        CACHttpClient.Builder builder = new CACHttpClient.Builder("","");
        builder.setBaseUrl(server.url("").toString());
        CACClient cacClient = new CACClient(builder.build());

        cacClient.listServers().execute();

        System.out.println();
    }

}
