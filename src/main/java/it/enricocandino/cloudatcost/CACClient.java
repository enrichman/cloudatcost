package it.enricocandino.cloudatcost;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import it.enricocandino.cloudatcost.request.*;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class CACClient {

    private static final String BASE_URL = "https://panel.cloudatcost.com/api/v1";

    private OkHttpClient client;
    private Gson gson;

    private String apiKey;
    private String login;

    public CACClient(String apiKey, String login) {
        this.client = new OkHttpClient();
        this.gson = new Gson();

        this.apiKey = apiKey;
        this.login = login;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public <T> T parseJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
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

    public RunModeRequest runMode() {
        return new RunModeRequest(this);
    }

    public RenameServerRequest renameServer() {
        return new RenameServerRequest(this);
    }

    public RDNSRequest rdns() {
        return new RDNSRequest(this);
    }

}
