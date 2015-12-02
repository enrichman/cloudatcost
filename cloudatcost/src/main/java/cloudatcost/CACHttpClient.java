package cloudatcost;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by enrico on 02/12/15.
 */
public class CACHttpClient {

    private OkHttpClient client;
    private String baseUrl;
    private Gson gsonParser;

    private String apiKey;
    private String login;

    public CACHttpClient(String apiKey, String login) {
        this.baseUrl = "https://panel.cloudatcost.com/api/v1";
        this.client = new OkHttpClient();
        this.gsonParser = new Gson();
        this.apiKey = apiKey;
        this.login = login;
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

}
