package service.impl;

import service.UserService;
import service.dao.SimpleDAO;
import service.dao.impl.SimpleDAOImpl;
import service.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    SimpleDAO simpleDAO= new SimpleDAOImpl();

    @Override
    public List<String> usersYoungerThen(short age) {
        List<String> usersYoungerThen =simpleDAO.getAllUsers()
                .stream()
                .filter(user -> user.getAge()<age)
                .map(user -> user.getNickname())
                .collect(Collectors.toList());
        return usersYoungerThen;
    }

    @Override
    public long usersSuffixOfSurname(String suffix) {
        long userSuffix =simpleDAO.getAllUsers()
                .stream()
                .filter(user -> user.getSurname().length()>suffix.length())
                .filter(user ->user.getSurname().substring(user.getSurname().length() - suffix.length()).equals(suffix))
                .count();
        return userSuffix;
    }
}
