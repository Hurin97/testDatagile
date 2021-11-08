package settings;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import service.UserService;
import service.dao.SimpleDAO;
import service.dao.impl.SimpleDAOImpl;
import service.impl.UserServiceImpl;
import web.controllers.UserController;
import web.controllers.impl.UsersControllerImpl;

public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(UsersControllerImpl.class).to(UserController.class);
                bind(UserServiceImpl.class).to(UserService.class);
                bind(SimpleDAOImpl.class).to(SimpleDAO.class);
            }
        });
        // Now you can expect validation errors to be sent to the
        // client.
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}