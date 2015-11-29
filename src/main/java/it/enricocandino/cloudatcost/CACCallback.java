package it.enricocandino.cloudatcost;

import it.enricocandino.cloudatcost.response.CACBaseResponse;
import it.enricocandino.cloudatcost.response.CACErrorResponse;

/**
 * Copyright (c) 2015 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
public interface CACCallback<T extends CACBaseResponse> {

    void onSuccess(T cacResponse);
    void onError(CACErrorResponse errorResponse);
    void onException(CACException e);

}
