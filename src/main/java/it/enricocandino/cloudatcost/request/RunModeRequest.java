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
public class RunModeRequest extends CACRequest<ResultResponse> {

    public enum MODE {

        NORMAL("normal"), SAFE("safe");

        private String mode;

        MODE(String mode) {
            this.mode = mode;
        }
    }

    private String sid;
    private MODE mode;

    public RunModeRequest(CACClient cacClient) {
        super(cacClient, ResultResponse.class, "/runmode.php");
    }

    public RunModeRequest setMode(MODE mode) {
        this.mode = mode;
        return this;
    }

    public String getSid() {
        return sid;
    }

    public RunModeRequest setSid(String sid) {
        this.sid = sid;
        return this;
    }

    public MODE getMode() {
        return mode;
    }

    @Override
    public Request buildRequest() {
        RequestBody formBody = new FormEncodingBuilder()
                .add("key", cacClient.getApiKey())
                .add("login", cacClient.getLogin())
                .add("sid", sid)
                .add("mode", mode.mode)
                .build();

        Request.Builder builder = new Request.Builder()
                .url(getUrl())
                .post(formBody);

        return builder.build();
    }
}
