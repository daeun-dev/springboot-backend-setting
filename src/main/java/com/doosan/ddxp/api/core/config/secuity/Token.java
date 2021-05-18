package com.doosan.ddxp.api.core.config.secuity;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class Token implements Serializable {


    @NonNull
    private String id;
    private Date expiredDate;



}
