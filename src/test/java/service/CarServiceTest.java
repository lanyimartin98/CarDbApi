package service;

import database.Connector;
import database.StatementBuilder;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import model.enums.inUse;
import model.enums.usageType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void addData() throws NotFound, AnotherFound {
        CarService service=new CarService();
       Car car=new Car("BMW","535i","01234567","MNS-128", LocalDate.of(2007,10,22),360, inUse.InUse,false, usageType.advertisement,270000,"null");
        ArrayList<Object> cars=service.makeArray(car);
        System.out.println(StatementBuilder.BuildInsert("Cars",cars));
        Connector.execStatement(StatementBuilder.BuildInsert("Cars",cars));
        System.out.println(service.getAllData());

    }
}