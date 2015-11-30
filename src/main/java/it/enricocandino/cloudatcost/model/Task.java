package it.enricocandino.cloudatcost.model;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class Task {

    private String cid;
    private String idf;
    private String serverid;
    private String action;
    private String status;
    private String starttime;
    private String finishtime;
    private String servername;
    private String ip;
    private String label;
    private String rdns;
    private String rdnsdefault;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRdns() {
        return rdns;
    }

    public void setRdns(String rdns) {
        this.rdns = rdns;
    }

    public String getRdnsdefault() {
        return rdnsdefault;
    }

    public void setRdnsdefault(String rdnsdefault) {
        this.rdnsdefault = rdnsdefault;
    }
}
