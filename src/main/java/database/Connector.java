package database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;

public class Connector {
    private Connector() {
    };
    private static Connection con = null;



    public static Connection getConnection() {
        if(con==null) {
            try {

                con = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/CarDatabase",
                                "postgres", "Martinka22");
                return con;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());

            }
        }
        else{
            return con;
        }
        return null;
    }

    public static JSONArray execStatement(String SQL) {

        con=Connector.getConnection();
        JSONArray arr=new JSONArray();
        JSONObject obj=new JSONObject();

        try (

                Statement stmt = con.createStatement();


                ResultSet rs = stmt.executeQuery(SQL)) {
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            while(rs.next()){

                for (int i = 0; i < columnCount; i++) {

                    obj.put(rs.getMetaData().getColumnLabel(i + 1)
                            .toLowerCase(), rs.getObject(i + 1));

                }
                arr.put(obj);

            }
            return arr;

        } catch (SQLException | JSONException ex) {
            System.out.println(ex.getMessage());
            return null;
        }


    }

}
