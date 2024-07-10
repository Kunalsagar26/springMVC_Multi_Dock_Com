package service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import entity.User;


@Component
public interface Userservice {

    public User getUsers();
    public void updateUser (String username , String address);

    
}
