package dao;

import exceptions.AnotherFound;
import exceptions.InvalidData;
import exceptions.MilageCanNotBeLowered;
import exceptions.NotFound;
import model.Car;
import model.enums.inUse;
import model.enums.usageType;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DAOTest {
    private IDAO dao;
    private int obj;

    @Before
    public void setUp() throws Exception, InvalidData, MilageCanNotBeLowered {
        dao=new DAO("Test","test1");

    }

    @Test
    public void getAllData() throws NotFound, AnotherFound {
        obj=dao.getAllData().length()-1;


    }
    @Test
    public void addData() throws NotFound, AnotherFound {
        ArrayList<String> addable=new ArrayList<>();
        addable.add("56");
        addable.add("Test");
        dao.addData(addable);
        assert(dao.getAllData().length()>obj);
    }

    @Test
    public void deleteByID() throws NotFound, AnotherFound {
        dao.deleteByID("56");
        assert(dao.getAllData().length()-1==obj);
    }


    @Test (expected = NullPointerException.class)
    public void getDataByID() throws NotFound {
        dao.getDataByID("107");
    }
}