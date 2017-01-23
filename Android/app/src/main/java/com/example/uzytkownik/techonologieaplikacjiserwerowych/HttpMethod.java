package com.example.uzytkownik.techonologieaplikacjiserwerowych;

/**
 * Created by uzytkownik on 17.01.2017.
 */

public enum HttpMethod {
    GET("GET"), POST("POST");

    private final String method;

    HttpMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
