package database;

import exceptions.AnotherFound;
import exceptions.NotFound;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StatementBuilderTest {

    @Test
    void builtQuery() throws NotFound, AnotherFound {
        StatementBuilder builder=new StatementBuilder();
        System.out.println(builder.BuildQuery("Cars"));
        System.out.println(Connector.execQuery(builder.BuildQuery("Cars")));
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
    @Test
    void TestSingleSelect(){
        System.out.println(StatementBuilder.BuildSingleSelect("Cars","title","NSR-107"));
    }
    @Test
    void buildDelete(){
        System.out.println(StatementBuilder.BuildDelete("Cars","title","NSR-107"));
    }
}
