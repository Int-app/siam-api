package jp.co.siam.restapi.common;

import java.io.Serializable;


public class ResponseResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(int statusCode, String message, T data) {
        this.code = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
