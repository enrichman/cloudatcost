package it.enricocandino.cloudatcost.request;

import com.squareup.okhttp.Request;
import it.enricocandino.cloudatcost.CACClient;
import it.enricocandino.cloudatcost.response.ListServersResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class ListServersRequest extends CACRequest<ListServersResponse> {

    public ListServersRequest(CACClient cacClient) {
        super(cacClient, ListServersResponse.class, "/listservers.php");
    }

    @Override
    public Request buildRequest() {
        Request.Builder builder = new Request.Builder();
        String url = CACClient.getBaseUrl()
                + requestPath
                + "?key=" + cacClient.getApiKey()
                + "&login=" + cacClient.getLogin();
        builder.url(url);

        return builder.build();
    }
}
