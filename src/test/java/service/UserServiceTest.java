//package service;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import service.dao.SimpleDAO;
//import service.dao.impl.SimpleDAOImpl;
//
//import java.sql.*;
//
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    @Mock
//    DriverManager mockDriverManager;
//    @Mock
//    Connection mockConn;
//    @Mock
//    PreparedStatement mockPreparedStatement;
//    @Mock
//    ResultSet mockResultSet;
//    @InjectMocks
//    SimpleDAO msimpleDAO =new SimpleDAOImpl() ;
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//
//    }
//    @AfterClass
//    public static void tearDownClass() {
//
//    }
//
//    @Before
//    public void setUp() throws SQLException {
//        when(mockDriverManager.getConnection(anyString(),anyString(),anyString())).thenReturn(mockConn);
//        doNothing().when(mockConn).commit();
//        when(mockConn.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
//        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
//    }
////    @InjectMocks
////    SimpleDAO dao = msimpleDAO;
//
//
//}
