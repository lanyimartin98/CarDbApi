package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import model.Incident;
import strategies.MakeArrayStrategy;
import strategies.MakeIncidentArrayStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class IncidentService {
    private IDAO incidentDAO;
    private MakeArrayStrategy as;
    private ObjectMapper mapper;
    private TypeReference ref;
    public IncidentService(){
        this.incidentDAO=new DAO("Incidents","incident_id");
        this.as=new MakeIncidentArrayStrategy();
        this.mapper=new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.ref = new TypeReference<ArrayList<Incident>>() {


        };

    }
    public Collection<Incident> getAllData() throws NotFound, AnotherFound, IOException {
        return mapper.readValue(incidentDAO.getAllData().toString(),ref);
    }
    public Incident getDataByID(String id) throws NotFound, IOException {
        try {
            return mapper.readValue(incidentDAO.getDataByID(id).toString(), Incident.class);
        }catch (NullPointerException e){
            System.out.println("Got it bro!");
        }
        throw new NotFound();
    }
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        incidentDAO.addData(as.MakeArray(mapper.readValue(obj,Incident.class)));
    }
    public void deleteByID(String id){
        incidentDAO.deleteByID(id);
    }
}

