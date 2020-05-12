package database;

import exceptions.AnotherFound;
import exceptions.NotFound;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.Collection;

import static org.junit.Assert.*;

public class ConnectorTest {

    Connection con;
    @Before
    public void setUp() throws Exception {
        con=Connector.getConnection();
    }
    @Test
    public void Test() throws NotFound, AnotherFound {
        int obj=execQuery();
        execInsert();
        assert(obj<execQuery());
        execDelete();
        assert(obj==execQuery());
    }

    public void execInsert() throws NotFound, AnotherFound {
        Connector.execInsert("insert into \"Test2\" values('2','Test');");

    }
    @Test
    public void execDelete() throws NotFound, AnotherFound {
        Connector.execDelete("delete from \"Test2\" where \"id\"='2';");

    }

    public int execQuery() throws NotFound, AnotherFound {
        return Connector.execQuery("select * from \"Test2\";").length();
    }
}