package service.dao.impl;

import service.dao.SimpleDAO;
import service.model.User;
import settings.ApplicationPropertyReader;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleDAOImpl implements SimpleDAO {

    private static final String FIND_USER_BY_ID ="Select id,nickname,name,surname,patronymic,age,dateOfLastUpdate," +
            "dateOfCreation,isDeleted from test_ex.users where id=?;";
    private static final String FIND_USER_BY_NICKNAME ="Select id,nickname,name,surname,patronymic,age,dateOfLastUpdate," +
            "dateOfCreation,isDeleted from test_ex.users where nickname=?;";
    private static final String CREATE_USER ="insert into test_ex.users(nickname,NAME, SURNAME, PATRONYMIC, AGE, " +
            "DATEOFLASTUPDATE, DATEOFCREATION, ISDELETED) values(?,?,?,?,?,?,?,?)";
    private static final String ALL_USERS_BY_ID ="Select id,nickname,name,surname,patronymic,age,dateOfLastUpdate," +
            "dateOfCreation,isDeleted from test_ex.users ;";
    private static final String UPDATE_USER ="Update test_ex.users set name=?,surname=?,patronymic=?,age=?," +
            "dateOfLastUpdate=? where id=?;";

    Map<String,String> props= ApplicationPropertyReader.getInstance().getProperties();
    private String hostname=props.get("db_hostname");
    private String username=props.get("db_username");
    private String port=props.get("db_port");
    private String dbname=props.get("db_name");
    private String passwd=props.get("db_user_password");
    private String url="jdbc:h2:tcp://"+hostname+":"+port+"/~/"+dbname;
    @Override


    public User findById(long id) {
        User user =null;
        try (Connection connection = DriverManager.getConnection(url,username,passwd);
             PreparedStatement preparedStatement =connection.prepareStatement(FIND_USER_BY_ID)) {
            preparedStatement.setLong(1,id);
            try (ResultSet resultSet =preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    user = new User(resultSet.getLong("id"), resultSet.getString("nickname"),
                            resultSet.getString("name"), resultSet.getString("surname"),
                            resultSet.getString("patronymic"), resultSet.getShort("age"),
                            resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                            resultSet.getObject("dateOfCreation", LocalDateTime.class),
                            resultSet.getBoolean("isDeleted"));
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByNickname(String nick) {
        User user =null;
        try (Connection connection = DriverManager.getConnection(url,username,passwd);
             PreparedStatement preparedStatement =connection.prepareStatement(FIND_USER_BY_NICKNAME)) {
            preparedStatement.setString(1,nick);
            try (ResultSet resultSet =preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    user = new User(resultSet.getLong("id"), resultSet.getString("nickname"),
                            resultSet.getString("name"), resultSet.getString("surname"),
                            resultSet.getString("patronymic"), resultSet.getShort("age"),
                            resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                            resultSet.getObject("dateOfCreation", LocalDateTime.class),
                            resultSet.getBoolean("isDeleted"));
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public long createUser(User user) {
        Long idret =null;
        try (Connection connection = DriverManager.getConnection(url,username,passwd);
             PreparedStatement preparedStatement =connection.prepareStatement(CREATE_USER,new String[]{"id"})) {
            preparedStatement.setString(1,user.getNickname());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurname());
            preparedStatement.setString(4,user.getPatronymic());
            preparedStatement.setShort(5,user.getAge());
            preparedStatement.setObject(6,user.getDateOfLastUpdate());
            preparedStatement.setObject(7,user.getDateOfCreation());
            preparedStatement.setBoolean(8,user.isDeleted());
            preparedStatement.executeQuery();
            try(ResultSet resultSet =preparedStatement.getGeneratedKeys()) {
                resultSet.next();
                idret = resultSet.getLong(1);
            }
            catch (SQLException e2) {
                e2.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idret;
    }

    @Override
    public boolean loadScript(String script) {
        boolean result =false;
        try(Connection connection =DriverManager.getConnection(url,username,passwd);
            Statement statement =connection.createStatement()){
            Arrays.stream(script.split(";")).forEach(s -> {
                try {
                    statement.execute(s+";");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            });
            result=true;
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String updateUser(User user) {
        String result ="";
        try (Connection connection = DriverManager.getConnection(url,username,passwd);
             PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_USER,new String[]{"id"})) {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPatronymic());
            preparedStatement.setShort(4,user.getAge());
            preparedStatement.setObject(5,user.getDateOfLastUpdate());
            preparedStatement.setLong(6,user.getId());
            int rowAffected =preparedStatement.executeUpdate();
            if (rowAffected>0) {
                result="success";
            } else {
                result="fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users =new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,username,passwd);
            PreparedStatement preparedStatement =connection.prepareStatement(ALL_USERS_BY_ID)) {
            try(ResultSet resultSet =preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    users.add(new User(resultSet.getLong("id"), resultSet.getString("nickname"),
                            resultSet.getString("name"), resultSet.getString("surname"),
                            resultSet.getString("patronymic"), resultSet.getShort("age"),
                            resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                            resultSet.getObject("dateOfCreation", LocalDateTime.class),
                            resultSet.getBoolean("isDeleted")));
                }
            } catch (SQLException e2){
                e2.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}
