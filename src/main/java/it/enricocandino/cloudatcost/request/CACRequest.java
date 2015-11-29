package it.enricocandino.cloudatcost.request;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import it.enricocandino.cloudatcost.CACCallback;
import it.enricocandino.cloudatcost.CACClient;
import it.enricocandino.cloudatcost.CACException;
import it.enricocandino.cloudatcost.response.CACBaseResponse;
import it.enricocandino.cloudatcost.response.CACErrorResponse;

import java.io.IOException;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public abstract class CACRequest<T extends CACBaseResponse> {

    protected CACClient cacClient;
    protected String requestPath;
    private Class<T> clazz;

    private CACCallback<T> callback;

    public CACRequest(CACClient cacClient, Class<T> clazz, String requestPath) {
        this.cacClient = cacClient;
        this.clazz = clazz;
        this.requestPath = requestPath;
    }

    public CACRequest callback(CACCallback<T> cacCallback) {
        this.callback = cacCallback;
        return this;
    }

    public String getUrl() {
        return CACClient.getBaseUrl() + requestPath;
    }

    public abstract Request buildRequest();

    public void execute() {
        try {
            Request request = buildRequest();
            Response response = cacClient.getClient().newCall(request).execute();
            handleResponse(response);

        } catch (IOException e) {
            handleException(e);
        }
    }

    public void async() throws IOException {
        Request request = buildRequest();
        cacClient.getClient().newCall(request).enqueue(new Callback() {

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

            if(response.isSuccessful()) {
                T resp = new Gson().fromJson(jsonResp, clazz);
                callback.onSuccess(resp);
            } else {
                CACErrorResponse resp = new Gson().fromJson(jsonResp, CACErrorResponse.class);
                callback.onError(resp);
            }

        } catch (IOException e) {
            handleException(e);
        }
    }

    private void handleException(IOException e) {
        CACException exception = new CACException();
        callback.onException(exception);
    }
}
