package com.example.gwt.server;

import com.example.gwt.client.LoginService;
import com.example.gwt.shared.LoginResponse;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Server-side implementation of the GWT-RPC LoginService.
 * Uses raw JDBC (DriverManager) against PostgreSQL rather than the JPA
 * repository layer, per the proof-of-concept requirements.
 */
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/gwt_login_db";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    private static final String COUNT_QUERY =
            "SELECT count(*) FROM app_user WHERE username = ? AND password = ?";

    @Override
    public LoginResponse authenticate(String username, String password) {

        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return new LoginResponse(false, "Username and password must not be empty.");
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(COUNT_QUERY)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next() && resultSet.getLong(1) > 0) {
                    return new LoginResponse(true, "Login successful.");
                }
                return new LoginResponse(false, "Invalid username or password.");
            }

        } catch (SQLException e) {
            return new LoginResponse(false, "Server error: " + e.getMessage());
        }
    }
}
