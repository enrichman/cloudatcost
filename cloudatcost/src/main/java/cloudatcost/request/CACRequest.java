package cloudatcost.request;

import cloudatcost.CACCallback;
import cloudatcost.CACException;
import cloudatcost.CACHttpClient;
import cloudatcost.response.CACErrorResponse;
import cloudatcost.response.CACResponse;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public abstract class CACRequest<T extends CACResponse> {

    protected CACHttpClient cacHttpClient;
    protected String requestPath;

    private Class<T> clazz;
    private CACCallback<T> callback;

    public CACRequest(CACHttpClient cacHttpClient, Class<T> clazz, String requestPath) {
        this.cacHttpClient = cacHttpClient;
        this.clazz = clazz;
        this.requestPath = requestPath;
    }

    public CACRequest callback(CACCallback<T> cacCallback) {
        this.callback = cacCallback;
        return this;
    }

    public String getUrl() {
        return cacHttpClient.getBaseUrl() + requestPath;
    }

    public abstract Request buildRequest();

    public void execute() {
        try {
            Request request = buildRequest();
            Response response = cacHttpClient.getClient().newCall(request).execute();
            handleResponse(response);

        } catch (IOException e) {
            handleException(e);
        }
    }

    public void async() {
        Request request = buildRequest();
        cacHttpClient.getClient().newCall(request).enqueue(new Callback() {

            public void onFailure(Request request, IOException e) {
                handleException(e);
            }

            public void onResponse(Response response) throws IOException {
                handleResponse(response);
            }
        });
    }

    private void handleResponse(Response response) {
        try {
            String jsonResp = response.body().string();

            if (response.isSuccessful()) {
                T resp = cacHttpClient.parseJson(jsonResp, clazz);
                callback.onSuccess(resp);
            } else {
                CACErrorResponse resp = cacHttpClient.parseJson(jsonResp, CACErrorResponse.class);
                callback.onError(resp);
            }

        } catch (IOException e) {
            handleException(e);
        }
    }

    private void handleException(IOException e) {
        CACException exception = new CACException(e);
        callback.onException(exception);
    }
}
