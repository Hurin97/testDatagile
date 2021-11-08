package web.controllers.impl;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.UserService;
import service.dao.SimpleDAO;
import service.dao.impl.SimpleDAOImpl;
import service.impl.UserServiceImpl;
import service.model.User;
import web.controllers.UserController;

import java.util.List;

@Path("users")
public class UsersControllerImpl implements UserController {
    private UsersControllerImpl usersController;
    @Inject
    public UsersControllerImpl(UsersControllerImpl usersController) {
        this.usersController=usersController;
    }

    SimpleDAO simpleDAO =new SimpleDAOImpl();
    UserService userService =new UserServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<User> getAllUsers() {
        return simpleDAO.getAllUsers();
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public User getUserById(@PathParam(value = "userId")Long userId) {
        return simpleDAO.findById(userId);
    }

    @GET
    @Path("{userNick}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public User getUserByNick(@PathParam(value = "userNick")String userNick) {
        return simpleDAO.findByNickname(userNick);
    }

    @PUT
    @Path("{userId}")
    @Override
    public String updateUser(@PathParam(value = "userId")Long userId, @Valid User user) {
        user.setId(userId);
        String result =simpleDAO.updateUser(user);
        return result;
    }

    @POST
    @Path("loadScript")
    @Override
    public String loadSQLScript(String script) {
        boolean res =simpleDAO.loadScript(script);
        String result ="fail";
        if(res==true) {
            result ="success";
        }
        return result;
    }

    @GET
    @Path("younger/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<String> getUsersYoungerAge(@PathParam(value = "age") short age) {
        return userService.usersYoungerThen(age);
    }

    @GET
    @Path("suffixSurname/{suffix}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public long getSumUsersWithSuffixOfSurname(@PathParam(value = "suffix") String suffix) {
        return userService.usersSuffixOfSurname(suffix);
    }
}
