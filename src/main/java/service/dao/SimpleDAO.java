package service.dao;

import service.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface SimpleDAO {
    User findById(long id);
    User findByNickname(String nick);
    long createUser(User user);
    boolean loadScript(String script);
    String updateUser(User user);
    List<User> getAllUsers();
}

