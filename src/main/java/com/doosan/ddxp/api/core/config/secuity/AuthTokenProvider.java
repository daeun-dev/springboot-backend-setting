package com.doosan.ddxp.api.core.config.secuity;

public interface AuthTokenProvider<T> {
	T createLoginAuthToken(String id);
    T convertAuthToken(String token);
}
