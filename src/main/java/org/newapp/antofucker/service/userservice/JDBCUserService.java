package org.newapp.antofucker.service.userservice;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.newapp.antofucker.othershits.User;
import org.newapp.antofucker.persistance.ConnectionManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cadet on 13/11/15.
 */
public class JDBCUserService implements UserService {

    Connection dbConnection;

    public JDBCUserService(ConnectionManager connectionManager) {
        this.dbConnection = connectionManager.getConnection();
    }

    @Override
    public boolean authenticate(String string, String string2) {
        String password = null;
        String encryptedPassword = null;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "SELECT username, password FROM user WHERE username = '" + string + "';";

            ResultSet resultSet = statement.executeQuery(query);

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(string2.getBytes());
            byte[] hash = messageDigest.digest();
            encryptedPassword = Base64.encode(hash);


            if (resultSet.next()) {
                password = resultSet.getString("password");
                System.out.println("Working");

            } else {
                return false;
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure authenticating: " + e.getMessage());
        } catch (NoSuchAlgorithmException d) {
            System.out.println("Password encryption failed: " + d.getMessage());
        }

        return encryptedPassword != null && encryptedPassword.equals(password);
    }

    @Override
    public void addUser(User user) {

        try {
            Statement statement = dbConnection.createStatement();

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(user.getPassword().getBytes());
            byte[] hash = messageDigest.digest();
            String encryptedPassword = Base64.encode(hash);


            String query = "INSERT INTO user (username, password, email) VALUES ('" +
                    user.getUsername() + "', '" +
                    encryptedPassword + "', '" +
                    user.getEmail() + "');";

            statement.execute(query);

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure adding user: " + e.getMessage());
        } catch (NoSuchAlgorithmException d) {
            System.out.println("Password encryption failed: " + d.getMessage());
        }
    }

    @Override
    public User findByName(String name) {
        User user = null;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "SELECT * FROM user WHERE username = '" + name + "';";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                user = new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure finding user: " + e.getMessage());
        }

        return user;
    }

    @Override
    public int count() {
        int count = 0;

        try {
            Statement statement = dbConnection.createStatement();

            String query = "SELECT COUNT(*) FROM user";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Failure counting results: " + e.getMessage());
        }

        return count;
    }
}
