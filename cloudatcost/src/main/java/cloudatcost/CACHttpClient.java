package cloudatcost;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class CACHttpClient {

    private OkHttpClient client;
    private String baseUrl;
    private Gson gsonParser;

    private String apiKey;
    private String login;

    private CACHttpClient(
            String apiKey,
            String login,
            String baseUrl,
            OkHttpClient client,
            Gson gsonParser
    ) {
        this.apiKey = apiKey;
        this.login = login;
        this.baseUrl = baseUrl;
        this.client = client;
        this.gsonParser = gsonParser;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Gson getGsonParser() {
        return gsonParser;
    }

    public void setGsonParser(Gson gsonParser) {
        this.gsonParser = gsonParser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public <T> T parseJson(String json, Class<T> clazz) {
        return gsonParser.fromJson(json, clazz);
    }

    public static class Builder {

        private String apiKey;
        private String login;
        private String baseUrl;
        private Gson gsonParser;
        private OkHttpClient okHttpClient;

        public Builder(String apiKey, String login) {
            this.apiKey = apiKey;
            this.login = login;
            this.baseUrl = "https://panel.cloudatcost.com/api/v1";
            this.okHttpClient = new OkHttpClient();
            this.gsonParser = new Gson();
        }

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder setGsonParser(Gson gsonParser) {
            this.gsonParser = gsonParser;
            return this;
        }

        public Builder setOkHttpClient(OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
            return this;
        }

        public CACHttpClient build() {
            return new CACHttpClient(apiKey, login, baseUrl, okHttpClient, gsonParser);
        }
    }
}
