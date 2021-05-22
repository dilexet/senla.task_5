package com.senla.povargo.hotel.tools;

public class Response {
    private final int code;
    private final String message;
    private final Object data;


    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
