package it.enricocandino.cloudatcost;

import it.enricocandino.cloudatcost.response.CACErrorResponse;
import it.enricocandino.cloudatcost.response.CACResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public interface CACCallback<T extends CACResponse> {

    void onSuccess(T cacResponse);
    void onError(CACErrorResponse errorResponse);
    void onException(CACException e);

}
