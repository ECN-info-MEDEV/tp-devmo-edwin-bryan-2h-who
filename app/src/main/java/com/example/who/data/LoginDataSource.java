package com.example.who.data;

import android.util.Log;

import com.example.who.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            if (username.equals("admin") && password.equals("admin")){
                LoggedInUser admin =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Admin");
                return new Result.Success<>(admin);
            } else {
                return new Result.Error(new Exception("Failed to log in"));
            }

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}