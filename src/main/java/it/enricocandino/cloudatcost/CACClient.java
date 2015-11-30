package it.enricocandino.cloudatcost;

import com.squareup.okhttp.OkHttpClient;
import it.enricocandino.cloudatcost.request.ListServersRequest;
import it.enricocandino.cloudatcost.request.ListTasksRequest;
import it.enricocandino.cloudatcost.request.ListTemplatesRequest;
import it.enricocandino.cloudatcost.request.PowerOpRequest;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class CACClient {

    private static final String BASE_URL = "https://panel.cloudatcost.com/api/v1";

    private OkHttpClient client;
    private String apiKey;
    private String login;

    public CACClient(String apiKey, String login) {
        this.client = new OkHttpClient();
        this.apiKey = apiKey;
        this.login = login;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getLogin() {
        return login;
    }

    public ListServersRequest listServers() {
        return new ListServersRequest(this);
    }

    public ListTemplatesRequest listTemplates() {
        return new ListTemplatesRequest(this);
    }

    public ListTasksRequest listTasks() {
        return new ListTasksRequest(this);
    }

    public PowerOpRequest powerOp() {
        return new PowerOpRequest(this);
    }

}
