package database;

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
    public void execInsert() {

    }

    @Test
    public void execUpdate() {
    }

    @Test
    public void execDelete() {
    }

    @Test
    public void execQuery() {
    }
}