package service;

import exceptions.AnotherFound;
import exceptions.InvalidData;
import exceptions.MilageCanNotBeLowered;
import exceptions.NotFound;
import model.Car;
import model.enums.inUse;
import model.enums.usageType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    static CarService service;
    @Test
    void setup(){
         service=new CarService();
    }

    @Test
    void getAllData() throws NotFound, IOException, AnotherFound {

        System.out.println(service.getAllData());
    }

    @Test
    void getDataByTitle() throws NotFound, IOException {
        service=new CarService();

        Throwable exception = assertThrows(NotFound.class, () -> service.getDataByTitle("NNN-107"));
        assertEquals(null, exception.getMessage());
    }


    @Test
    void deleteDataByTitle() {
        service=new CarService();
        service.deleteDataByTitle("PKJ-888");
    }

    @Test
    void addData() throws InvalidData, MilageCanNotBeLowered, AnotherFound, IOException, NotFound {
        Car car=new Car("BMW","325i","01234567","PKJ-888", LocalDate.of(1998,10,22),192, inUse.InUse,false, usageType.personal,1200000,"null");
        service=new CarService();
        service.addData(car.toString());

    }
}