package it.enricocandino.cloudatcost.request;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import it.enricocandino.cloudatcost.CACClient;
import it.enricocandino.cloudatcost.response.PowerOpResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class PowerOpRequest extends CACRequest<PowerOpResponse> {

    public enum ACTION {

        ON("poweron"), OFF("poweroff"), RESET("reset");

        private String action;

        ACTION(String action) {
            this.action = action;
        }
    }

    private ACTION action;
    private String sid;

    public PowerOpRequest(CACClient cacClient) {
        super(cacClient, PowerOpResponse.class, "/powerop.php");
    }

    public ACTION getAction() {
        return action;
    }

    public PowerOpRequest setAction(ACTION action) {
        this.action = action;
        return this;
    }

    public String getSid() {
        return sid;
    }

    public PowerOpRequest setSid(String sid) {
        this.sid = sid;
        return this;
    }

    @Override
    public Request buildRequest() {
        RequestBody formBody = new FormEncodingBuilder()
                .add("key",     cacClient.getApiKey())
                .add("login",   cacClient.getLogin())
                .add("sid", sid)
                .add("action",  action.action)
                .build();

        Request.Builder builder = new Request.Builder()
                .url(getUrl())
                .post(formBody);

        return builder.build();
    }
}
