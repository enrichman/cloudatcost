package it.enricocandino.cloudatcost.response;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public abstract class CACResponse {

    private String status;
    private long time;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
