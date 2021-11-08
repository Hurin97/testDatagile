package service;

import java.util.List;

public interface UserService {
    List<String> usersYoungerThen(short age);
    long usersSuffixOfSurname(String suffix);
}
