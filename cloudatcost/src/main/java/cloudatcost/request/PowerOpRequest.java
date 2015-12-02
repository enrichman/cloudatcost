package cloudatcost.request;

import cloudatcost.CACHttpClient;
import cloudatcost.response.PowerOpResponse;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

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

    private String sid;
    private ACTION action;

    public PowerOpRequest(CACHttpClient cacHttpClient) {
        super(cacHttpClient, PowerOpResponse.class, "/powerop.php");
    }

    public String getSid() {
        return sid;
    }

    public PowerOpRequest setSid(String sid) {
        this.sid = sid;
        return this;
    }

    public ACTION getAction() {
        return action;
    }

    public PowerOpRequest setAction(ACTION action) {
        this.action = action;
        return this;
    }

    @Override
    public Request buildRequest() {
        RequestBody formBody = new FormEncodingBuilder()
                .add("key", cacHttpClient.getApiKey())
                .add("login", cacHttpClient.getLogin())
                .add("sid", sid)
                .add("action", action.action)
                .build();

        Request.Builder builder = new Request.Builder()
                .url(getUrl())
                .post(formBody);

        return builder.build();
    }
}
