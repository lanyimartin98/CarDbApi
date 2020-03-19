package database;

import java.util.ArrayList;

public class StatementBuilder {
    public StatementBuilder(){};
    public static String BuildInsert(String database, ArrayList<Object> c ){
        StringBuilder builder=new StringBuilder();
        builder.append("insert into \"");
        builder.append(database);
        builder.append("\" values(");
        for (int i = 0; i < c.size(); i++) {
            if(i<c.size()-1) {
                builder.append("\'" + c.get(i).toString() + "\',");
            }
            else{
                builder.append("\'"+c.get(i).toString()+"\'");
            }
        }

        builder.append(");");
        return builder.toString();
    }
    public static String BuildQuery(String database){
        StringBuilder builder=new StringBuilder();
        builder.append("select * from ");
        builder.append("\""+database+"\";");
        return builder.toString();
    }
    public static String BuildSingleSelect(String database, String identifier, String id){
        StringBuilder builder=new StringBuilder();
        builder.append("select * from \"");
        builder.append(database);
        builder.append("\" where \"");
        builder.append(identifier);
        builder.append("\"=\'");
        builder.append(id);
        builder.append("\';");
        return builder.toString();
    }
    public static String BuildDelete(String database,String identifier,String id){
        StringBuilder builder=new StringBuilder();
        builder.append("delete from \"");
        builder.append(database);
        builder.append("\" where \"");
        builder.append(identifier);
        builder.append("\"=\'");
        builder.append(id);
        builder.append("\';");
        return builder.toString();
    }

}
