package web.controllers;


import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.model.User;

import java.util.List;

@Path("users")
public interface UserController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers();

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam(value = "userId") Long userId);

    @GET
    @Path("{userNick}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByNick(@PathParam(value = "userNick") String userNick);

    @PUT
    @Path("{userId}")
    public String updateUser(@PathParam(value = "userId") Long userId, @Valid User user);

    @POST
    @Path("loadScript")
    public String loadSQLScript(String script);

    @GET
    @Path("younger/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getUsersYoungerAge(@PathParam(value = "age") short age);

        @GET
        @Path("suffixSurname/{suffix}")
        @Produces(MediaType.APPLICATION_JSON)
    public long getSumUsersWithSuffixOfSurname(@PathParam(value = "suffix") String suffix);


}

/*Нужно реализовать java API для выполнения функций:

1)      поиск в репозитории аккаунта пользователя по имени (имя — уникальный атрибут);

2)      изменения у учётной записи любого атрибута.

3)      тестовый набор данных (загрузка скрипта sql)

4)   Получить список всех пользователей, а затем с помощью stream api найти:

     а) имена всех пользователей, которые младше 20 лет;

     б) посчитать количество пользователей, у которых фамилия оканчивается на "ов";



В качестве репозитория можете использовать СУБД H2, взаимодействие с базой должно идти через jdbc (использовать try with resources).

На реализацию должны быть написаны unit-тесты и интеграционные тесты с использованием Mockito.

Проект должен собираться с помощью maven.

Web-интерфейс разрабатывать не нужно, только серверное java API. (Без использования Spring)

 */