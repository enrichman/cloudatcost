package it.enricocandino.cloudatcost.request;

import com.squareup.okhttp.Request;
import it.enricocandino.cloudatcost.CACClient;
import it.enricocandino.cloudatcost.response.ListTasksResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class ListTasksRequest extends CACRequest<ListTasksResponse> {

    public ListTasksRequest(CACClient cacClient) {
        super(cacClient, ListTasksResponse.class, "/listtasks.php");
    }

    @Override
    public Request buildRequest() {
        Request.Builder builder = new Request.Builder();
        String url = getUrl()
                + "?key=" + cacClient.getApiKey()
                + "&login=" + cacClient.getLogin();
        builder.url(url);

        return builder.build();
    }
}
