package database;

import benchmark.Bench;
import exceptions.AnotherFound;
import exceptions.NotFound;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.*;

public class Connector {
    //Connector is a Singleton class to create connection and execute SQL queries from the database.
    private Connector() {
    };
    private static Connection con = null;
    //This method creates the instance of the connection, if it's already open it only
    public static Connection getConnection() {
        if(con==null) {
            try {
                con = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/CarDatabase",
                                "postgres", "pw");
                return con;
            } catch (Exception e) {

            }}
        else{
            return con;
        }
        return null;
    }
    public static void execInsert(String SQL) throws AnotherFound, NotFound {
        con = Connector.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        } catch (SQLException ex) {
            if(ex.getSQLState().equals("23505")){
                throw new AnotherFound();
            } } }
    public static void execUpdate(String SQL){
        con=Connector.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        } catch (SQLException ex) {

        } }

    public static void execDelete(String SQL) throws AnotherFound, NotFound {
        con = Connector.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        } catch (SQLException ex) {
            if(ex.getSQLState().equals("02000")){
                throw new AnotherFound();
            } } }

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
                throw new NotFound();
            } else {
                return arr;
            }
        } catch (SQLException | JSONException e) {
            e.printStackTrace();
        }
            throw new NotFound();
    }

}
