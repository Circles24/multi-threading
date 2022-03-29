package com.circles24.threadstates;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Error {
    INVALID_OPTION(AppException.builder().header("invalid option").info("invalid option selected").errorCode(1001).statusCode(400).build());

    private final AppException appException;

    public AppException build() {
        return appException;
    }
}
