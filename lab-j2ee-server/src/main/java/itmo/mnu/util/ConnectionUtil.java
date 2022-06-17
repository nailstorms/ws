package itmo.mnu.util;

import itmo.mnu.service.impl.EmployeeWebServiceImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {

    public static Connection getConnection(DataSource dataSource) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
