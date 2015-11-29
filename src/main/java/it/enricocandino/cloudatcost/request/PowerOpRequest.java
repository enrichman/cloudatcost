package it.enricocandino.cloudatcost.request;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import it.enricocandino.cloudatcost.CACClient;
import it.enricocandino.cloudatcost.response.ListServersResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class PowerOpRequest extends CACRequest<ListServersResponse> {

    public PowerOpRequest(CACClient cacClient) {
        super(cacClient, ListServersResponse.class, "/powerop.php");
    }

    @Override
    public Request buildRequest() {
        RequestBody formBody = new FormEncodingBuilder()
                .add("key", cacClient.getApiKey())
                .add("login", cacClient.getLogin())
                .add("sid", "")
                .add("action", "poweron")
                .build();

        Request.Builder builder = new Request.Builder()
                .url(CACClient.getBaseUrl() + requestPath)
                .post(formBody);

        return builder.build();
    }
}
