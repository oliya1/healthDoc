package com.nicico.healthDoc.response;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BaseResponse<T> {

    private int status;
    private String message;
    private T data;
}
