package service;

import exceptions.AnotherFound;
import exceptions.InvalidData;
import exceptions.MilageCanNotBeLowered;
import exceptions.NotFound;
import model.Car;
import model.enums.inUse;
import model.enums.usageType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CarServiceTest {
    CarService service;
    private int obj;
    private Car car;

    @Before
    public void setUp() throws Exception, NotFound, AnotherFound, InvalidData, MilageCanNotBeLowered {
        service=new CarService();
        car=new Car("BMW","325i","012345PA","MMM-888", LocalDate.of(1998,10,22),192, inUse.InUse,false, usageType.personal,120000,"smg");
    }

    public void addData() throws AnotherFound, IOException, NotFound {
        obj=service.getAllData().size();
        service.addData(car.toString());
        assert(obj<service.getAllData().size());
    }


    public void getDataByTitle() throws NotFound, IOException {
        assertEquals(service.getDataByTitle("MMM-888"),car);

    }


    public void deleteDataByTitle() throws AnotherFound, IOException, NotFound {
        obj=service.getAllData().size();
        service.deleteDataByTitle("MMM-888");
        assert(obj>service.getAllData().size());
    }
    @Test
    public void UnitTest() throws AnotherFound, IOException, NotFound {
        addData();
        getDataByTitle();
        deleteDataByTitle();
    }

}