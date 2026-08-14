package com.example.gwt.client;

import com.example.gwt.shared.LoginResponse;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * GWT RPC synchronous service interface for authenticating users.
 */
@RemoteServiceRelativePath("Login")
public interface LoginService extends RemoteService {

    LoginResponse authenticate(String username, String password);
}
