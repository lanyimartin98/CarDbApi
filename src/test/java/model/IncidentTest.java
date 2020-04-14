package model;

import exceptions.InvalidData;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class IncidentTest {

    @Test(expected = InvalidData.class)
    public void setInc_date() throws InvalidData {
        Incident inc=new Incident();
        inc.setInc_date(LocalDate.of(2300,10,22));
    }

    @Test (expected = InvalidData.class)
    public void setTitle() throws InvalidData {
        Incident inc=new Incident();
        inc.setTitle("ananász");
    }
}