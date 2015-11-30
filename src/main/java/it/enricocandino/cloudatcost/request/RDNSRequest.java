package it.enricocandino.cloudatcost.request;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import it.enricocandino.cloudatcost.CACClient;
import it.enricocandino.cloudatcost.response.ResultResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class RDNSRequest extends CACRequest<ResultResponse> {

    private String sid;
    private String hostname;

    public RDNSRequest(CACClient cacClient) {
        super(cacClient, ResultResponse.class, "/rdns.php");
    }

    public String getSid() {
        return sid;
    }

    public RDNSRequest setSid(String sid) {
        this.sid = sid;
        return this;
    }

    public String getHostname() {
        return hostname;
    }

    public RDNSRequest setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    @Override
    public Request buildRequest() {
        RequestBody formBody = new FormEncodingBuilder()
                .add("key", cacClient.getApiKey())
                .add("login", cacClient.getLogin())
                .add("sid", sid)
                .add("hostname", hostname)
                .build();

        Request.Builder builder = new Request.Builder()
                .url(getUrl())
                .post(formBody);

        return builder.build();
    }
}
