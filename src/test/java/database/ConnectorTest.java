package database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ConnectorTest {

    @Test
    void getInstance() {
        Connector.getConnection();

    }

    @Test
    void getConnection() throws SQLException {
        String sql="select * from \"Cars\";";
        System.out.println(Connector.execStatement(sql));

    }
}