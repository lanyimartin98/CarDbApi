package service;

import exceptions.AnotherFound;
import exceptions.InvalidData;
import exceptions.NotFound;
import model.Incident;
import model.enums.incidentType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IncidentServiceTest {

    @Test
    void getAllData() throws AnotherFound, IOException, NotFound {
        IncidentService serv=new IncidentService();
        System.out.println(serv.getAllData());
    }

    @Test
    void getDataByID() throws NotFound, IOException {
        IncidentService serv=new IncidentService();
        System.out.println(serv.getDataByID("1"));
    }

    @Test
    void addData() throws AnotherFound, IOException, NotFound, InvalidData {
        IncidentService serv=new IncidentService();
        Incident inc=new Incident(2,LocalDate.of(1998,10,22),false, incidentType.inspection,"NSR-107");
        serv.addData(inc.toString());
    }

    @Test
    void deleteByID() {
    }
}