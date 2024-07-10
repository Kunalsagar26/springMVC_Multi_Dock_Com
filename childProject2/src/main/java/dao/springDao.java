package dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.User;

@Component
public interface springDao {

	public User getUser();
    public void updateUser (String username , String address);

    
	
}
