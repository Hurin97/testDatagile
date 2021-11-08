//package service.dao;
//
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import service.dao.impl.SimpleDAOImpl;
//
//import java.sql.*;
//
//import static org.mockito.Matchers.anyLong;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SimpleDaoTest {
//    @Mock
//    DriverManager mockDriverManager;
//    @Mock
//    Connection mockConn;
//    @Mock
//    PreparedStatement mockPreparedStatement;
//    @Mock
//    ResultSet mockResultSet;
//    @InjectMocks
//    SimpleDAOImpl msimpleDAO ;
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
//
//    @After
//    public void tearDown() {
//
//    }
//
//    @Test
//    public void testFindById() {
//        msimpleDAO.findById(1);
//        verify(msimpleDAO).findById(anyLong());
//    }
//
//
//
//
//}
