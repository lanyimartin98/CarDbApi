package model;

import exceptions.InvalidData;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CarTest {

    @Test(expected = InvalidData.class)
    public void setTitle() throws InvalidData {
        Car car=new Car();
        car.setTitle("narancs");
    }

    @Test(expected = InvalidData.class)
    public void setStart_of_use() throws InvalidData {
        Car car=new Car();
        car.setStart_of_use(LocalDate.of(2400,10,22));
    }

    @Test(expected = InvalidData.class)
    public void setOwner_id() throws InvalidData {
        Car car=new Car();
        car.setOwner_id("paprika");
    }

}