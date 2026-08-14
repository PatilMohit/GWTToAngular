package com.example.gwt.client;

import com.example.gwt.shared.LoginResponse;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * GWT entry point that renders a simple login form and authenticates the
 * user against the server via GWT-RPC.
 */
public class LoginEntryPoint implements EntryPoint {

    private final LoginServiceAsync loginService = GWT.create(LoginService.class);

    private final TextBox usernameBox = new TextBox();
    private final PasswordTextBox passwordBox = new PasswordTextBox();
    private final Button loginButton = new Button("Login");
    private final Label statusLabel = new Label();

    @Override
    public void onModuleLoad() {

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(12);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setStyleName("login-panel");

        Label usernameLabel = new Label("Username");
        usernameBox.setStyleName("login-input");

        Label passwordLabel = new Label("Password");
        passwordBox.setStyleName("login-input");

        loginButton.setStyleName("login-button");
        statusLabel.setStyleName("status-label");

        panel.add(usernameLabel);
        panel.add(usernameBox);
        panel.add(passwordLabel);
        panel.add(passwordBox);
        panel.add(loginButton);
        panel.add(statusLabel);

        loginButton.addClickHandler(this::doLogin);

        passwordBox.addKeyUpHandler((KeyUpEvent event) -> {
            if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                doLogin(null);
            }
        });

        RootPanel.get("loginContainer").add(panel);
    }

    private void doLogin(ClickEvent event) {
        String username = usernameBox.getText();
        String password = passwordBox.getText();

        statusLabel.setStyleName("status-label");
        statusLabel.setText("Authenticating...");

        loginButton.setEnabled(false);

        loginService.authenticate(username, password, new AsyncCallback<LoginResponse>() {

            @Override
            public void onSuccess(LoginResponse result) {
                loginButton.setEnabled(true);
                if (result.isSuccess()) {
                    statusLabel.setStyleName("success-label");
                } else {
                    statusLabel.setStyleName("error-label");
                }
                statusLabel.setText(result.getMessage());
            }

            @Override
            public void onFailure(Throwable caught) {
                loginButton.setEnabled(true);
                statusLabel.setStyleName("error-label");
                statusLabel.setText("Server error: " + caught.getMessage());
            }
        });
    }
}
