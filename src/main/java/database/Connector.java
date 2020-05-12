package database;

import exceptions.AnotherFound;
import exceptions.NotFound;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;

public class Connector {
    //Connector is a Singleton class to create connection and execute SQL queries from the database.
    private Connector() {
    };
    private static Connection con = null;
    private static Logger logger=Logger.getLogger(Connector.class);
    //This method creates the instance of the connection, if it's already open it returns it.
    public static Connection getConnection() {
        if(con==null) {
            try {
                con = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/CarDatabase",
                                "postgres", "pw");
                logger.info("Connection opened.");
                return con;


            } catch (Exception e) {
                logger.error("Could not open connection");
            }}
        else{
            return con;
        }
        return null;
    }
    //Executes an Insert query
    public static void execInsert(String SQL) throws AnotherFound, NotFound {
        con = Connector.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23505")){
                logger.error("Another instance found with the same id.");
                throw new AnotherFound();
            } } };
    //Excutes an update query
    public static void execUpdate(String SQL){
        con=Connector.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        } catch (SQLException ex) {
            logger.error("SQL Expcetion occured.");

        } };
    //Executes a delete query
    public static void execDelete(String SQL) throws AnotherFound, NotFound {
        con = Connector.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        } catch (SQLException ex) {
            if(ex.getSQLState().equals("02000")){
                logger.error("Instance not found with the id.");

            } } };
        //Executes a regular query
        public static JSONArray execQuery(String SQL) throws NotFound, AnotherFound {
        con=Connector.getConnection();
        JSONArray arr=new JSONArray();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();
                int size = rs.getRow();
                    while (rs.next()) {
                        JSONObject obj = new JSONObject();
                        for (int i = 0; i < columnCount; i++) {
                            obj.put(rs.getMetaData().getColumnLabel(i + 1)
                            .toLowerCase(), rs.getObject(i + 1));
                }
                arr.put(obj);
            }
            if (arr.toString().equals("[]")) {
                logger.error("No instances found with the parameters.");
                throw new NotFound();
            } else {
                return arr;
            }
        } catch (SQLException | JSONException e) {
            logger.error("SQL expception occured.");
        }
        throw new NotFound();
    }

}
