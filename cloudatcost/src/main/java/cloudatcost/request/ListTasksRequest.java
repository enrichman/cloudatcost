package cloudatcost.request;

import cloudatcost.CACHttpClient;
import cloudatcost.response.ListTasksResponse;
import com.squareup.okhttp.Request;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class ListTasksRequest extends CACRequest<ListTasksResponse> {

    public ListTasksRequest(CACHttpClient cacHttpClient) {
        super(cacHttpClient, ListTasksResponse.class, "/listtasks.php");
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
