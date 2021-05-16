package com.doosan.ddxp.api.core.config.secuity;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum Role {
    MASTER("ROLE_MASTER", "관리자권한"),
    SUB("ROLE_SUB", "사용자권한"),
    UNKNOWN("UNKNOWN", "알수없는 권한");

    private String code;
    private String description;

    Role(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Role of(String code) {
        return Arrays.stream(Role.values())
                .filter(r -> r.getCode().equals(code))
                .findAny()
                .orElse(UNKNOWN);
    }
}