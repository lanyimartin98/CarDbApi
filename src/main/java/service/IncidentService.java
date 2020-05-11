package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
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
    //Returns the content of the "Incidents" table
    public Collection<Incident> getAllData() throws NotFound, AnotherFound, IOException {
        return mapper.readValue(incidentDAO.getAllData().toString(),ref);
    }
    //Returns the "Incident" instance with the given id
    public Incident getDataByID(String id) throws NotFound, IOException {
        try {
            return mapper.readValue(incidentDAO.getDataByID(id).toString(), Incident.class);
        }catch (NullPointerException e){

        }
        throw new NotFound();
    }
    //Specifies the add operation for the DAO.
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        incidentDAO.addData(as.MakeAdd(mapper.readValue(obj,Incident.class)));
    }
    //Deletes the instance with the given id
    public void deleteByID(String id){
        incidentDAO.deleteByID(id);
    }
}

