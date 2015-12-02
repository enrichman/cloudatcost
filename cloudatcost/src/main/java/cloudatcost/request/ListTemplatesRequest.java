package cloudatcost.request;

import cloudatcost.CACHttpClient;
import cloudatcost.response.ListTemplatesResponse;
import com.squareup.okhttp.Request;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class ListTemplatesRequest extends CACRequest<ListTemplatesResponse> {

    public ListTemplatesRequest(CACHttpClient cacHttpClient) {
        super(cacHttpClient, ListTemplatesResponse.class, "/listtemplates.php");
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
