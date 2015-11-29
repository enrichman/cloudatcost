package it.enricocandino.cloudatcost.response;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public class CACErrorResponse extends CACResponse {

    private Integer error;
    @SerializedName("error_description")
    private String errorDescription;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
