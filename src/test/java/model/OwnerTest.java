package model;

import exceptions.InvalidData;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class OwnerTest {

    @Test(expected = InvalidData.class)
    public void setId() throws InvalidData {
        Owner owner=new Owner();
        owner.setId("kókusz");
    }

    @Test(expected = InvalidData.class)
    public void setDate_of_birth() throws InvalidData {
        Owner owner=new Owner();
        owner.setDate_of_birth(LocalDate.of(2100,10,11));
    }
}