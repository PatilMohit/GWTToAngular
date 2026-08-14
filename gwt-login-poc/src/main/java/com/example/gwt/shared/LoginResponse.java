package com.example.gwt.shared;

import java.io.Serializable;

/**
 * Shared DTO carrying the result of an authentication attempt between the
 * GWT client and the server. Must remain GWT-serializable (plain fields,
 * no-arg constructor, simple getters/setters).
 */
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
