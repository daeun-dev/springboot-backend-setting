package com.doosan.ddxp.api.core.config.secuity;

public interface AuthTokenProvider<T> {
	//T createLoginAuthToken(String id);
	T createLoginAuthToken();
    T convertAuthToken(String token);
}
