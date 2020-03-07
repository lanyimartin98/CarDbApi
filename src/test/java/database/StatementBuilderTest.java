package database;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StatementBuilderTest {

    @Test
    void builtQuery() {
        StatementBuilder builder=new StatementBuilder();
        System.out.println(builder.BuildQuery("Cars"));
        System.out.println(Connector.execStatement(builder.BuildQuery("Cars")));
    }
    @Test
    void buildAdd(){
        ArrayList<Object> ob=new ArrayList<Object>();
        ob.add("String");
        ob.add("String");
        ob.add("String");
        ob.add("String");
        StatementBuilder builder=new StatementBuilder();
        System.out.println(builder.BuildInsert("Cars",ob));
    }
}