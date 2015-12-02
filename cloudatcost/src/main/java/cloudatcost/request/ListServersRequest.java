package cloudatcost.request;

import cloudatcost.CACHttpClient;
import cloudatcost.response.ListServersResponse;
import com.squareup.okhttp.Request;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class ListServersRequest extends CACRequest<ListServersResponse> {

    public ListServersRequest(CACHttpClient cacClient) {
        super(cacClient, ListServersResponse.class, "/listservers.php");
    }

    @Override
    public Request buildRequest() {
        Request.Builder builder = new Request.Builder();
        String url = getUrl()
                + "?key=" + cacHttpClient.getApiKey()
                + "&login=" + cacHttpClient.getLogin();
        builder.url(url);

        return builder.build();
    }
}
