package database;

import exceptions.AnotherFound;
import exceptions.NotFound;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ConnectorTest {

    @Test
    void getInstance() {
        Connector.getConnection();

    }

    @Test
    void getConnection() throws SQLException, NotFound, AnotherFound {
        String sql=StatementBuilder.BuildSingleSelect("Cars","title","MNN-207");
        System.out.println(Connector.execQuery(sql));

    }
}