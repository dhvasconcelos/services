package org.newapp.antofucker.service.userservice;


import org.newapp.antofucker.othershits.User;
import org.newapp.antofucker.service.Service;

/**
 * Created by cadet on 02/11/15.
 */
public interface UserService extends Service {

    public boolean authenticate(String user, String password);

    public void addUser(User user);


    public User findByName(String user);

    public int count();



}
