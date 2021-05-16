package com.doosan.ddxp.api.core.config.secuity;


public interface AuthToken<T> {
    boolean validate();
    T getData();
}
