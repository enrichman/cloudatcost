package cloudatcost;

import cloudatcost.request.*;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class CACClient {

    private CACHttpClient cacHttpClient;

    public CACClient(String apiKey, String login) {
        CACHttpClient.Builder builder = new CACHttpClient.Builder(apiKey, login);
        this.cacHttpClient = builder.build();
    }

    public CACClient(CACHttpClient cacHttpClient) {
        this.cacHttpClient = cacHttpClient;
    }

    public ListServersRequest listServers() {
        return new ListServersRequest(cacHttpClient);
    }

    public ListTemplatesRequest listTemplates() {
        return new ListTemplatesRequest(cacHttpClient);
    }

    public ListTasksRequest listTasks() {
        return new ListTasksRequest(cacHttpClient);
    }

    public PowerOpRequest powerOp() {
        return new PowerOpRequest(cacHttpClient);
    }

    public RunModeRequest runMode() {
        return new RunModeRequest(cacHttpClient);
    }

    public RenameServerRequest renameServer() {
        return new RenameServerRequest(cacHttpClient);
    }

    public RDNSRequest rdns() {
        return new RDNSRequest(cacHttpClient);
    }

}
