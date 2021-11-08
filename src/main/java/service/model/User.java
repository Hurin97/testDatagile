package service.model;

import java.time.LocalDateTime;

public class User {
    public long id;
    public String nickname;
    public String name;
    public String surname;
    public String patronymic;
    public Short age;
    public LocalDateTime dateOfLastUpdate;
    public LocalDateTime dateOfCreation;
    public boolean isDeleted;

    public User(long id, String nickname, String name, String surname, String patronymic, Short age, LocalDateTime dateOfLastUpdate, LocalDateTime dateOfCreation, boolean isDeleted) {
        this.id = id;
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.dateOfCreation = dateOfCreation;
        this.isDeleted = isDeleted;
    }

    public User(String nickname, String name, String surname, String patronymic, Short age, LocalDateTime dateOfLastUpdate, LocalDateTime dateOfCreation, boolean isDeleted) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.dateOfCreation = dateOfCreation;
        this.isDeleted = isDeleted;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
