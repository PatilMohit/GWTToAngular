package com.example.gwt.client;

import com.example.gwt.shared.LoginResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Asynchronous counterpart of {@link LoginService}, used by client-side code.
 */
public interface LoginServiceAsync {

    void authenticate(String username, String password, AsyncCallback<LoginResponse> callback);
}
