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
public class RenameServerRequest extends CACRequest<ResultResponse> {

    private String sid;
    private String name;

    public RenameServerRequest(CACClient cacClient) {
        super(cacClient, ResultResponse.class, "/renameserver.php");
    }

    public String getSid() {
        return sid;
    }

    public RenameServerRequest setSid(String sid) {
        this.sid = sid;
        return this;
    }

    public String getName() {
        return name;
    }

    public RenameServerRequest setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Request buildRequest() {
        RequestBody formBody = new FormEncodingBuilder()
                .add("key", cacClient.getApiKey())
                .add("login", cacClient.getLogin())
                .add("sid", sid)
                .add("name", name)
                .build();

        Request.Builder builder = new Request.Builder()
                .url(getUrl())
                .post(formBody);

        return builder.build();
    }
}
