package dal.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class MSSQLConnection {

    public static Connection get(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("Pa$$w0rd");
        ds.setServerName("127.0.0.1");
        ds.setPortNumber(1433);
        ds.setDatabaseName("progeait");

        Connection connection = null;
        try {
            connection = ds.getConnection();

        } catch (SQLServerException e) {
            e.printStackTrace();
        }
        finally {
            return connection;
        }
    }
}
