package jp.co.siam.restapi.common;

import java.io.Serializable;


public class ResponseResult<T> implements Serializable {

    private String statusCode;

    private String message;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(String statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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
