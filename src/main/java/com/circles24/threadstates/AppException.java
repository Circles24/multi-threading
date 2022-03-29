package com.circles24.threadstates;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppException extends RuntimeException {
    private String header;

    private String info;

    private long errorCode;

    private long statusCode;
}
