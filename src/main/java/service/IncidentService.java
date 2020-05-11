package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Incident;
import org.apache.log4j.Logger;
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
    private Logger logger=Logger.getLogger(IncidentService.class);
    public IncidentService(){
        this.incidentDAO=new DAO("Incidents","incident_id");
        this.as=new MakeIncidentArrayStrategy();
        this.mapper=new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.ref = new TypeReference<ArrayList<Incident>>() {
        };
        logger.info("IncidentService initialized.");
    }
    //Returns the content of the "Incidents" table
    public Collection<Incident> getAllData() throws NotFound, AnotherFound, IOException {
        logger.info("All data of incidents were returned.");
        return mapper.readValue(incidentDAO.getAllData().toString(),ref);
    }
    //Returns the "Incident" instance with the given id
    public Incident getDataByID(String id) throws NotFound, IOException {
        try {
            logger.info("Data of incident under id:"+id+" was returned.");
            return mapper.readValue(incidentDAO.getDataByID(id).toString(), Incident.class);
        }catch (NullPointerException e){
            logger.error("NullPointerException occured");
        }
        logger.error("Instance not found under the id:"+id+".");
        throw new NotFound();
    }
    //Specifies the add operation for the DAO.
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        incidentDAO.addData(as.MakeAdd(mapper.readValue(obj,Incident.class)));
        logger.info("Insert of a new Incident was performed.");
    }
    //Deletes the instance with the given id
    public void deleteByID(String id){
        incidentDAO.deleteByID(id);
        logger.info("The incident under the id "+id+" was deleted.");
    }
    //Specifies the modify operation for the DAO.
    public void updateIncident(String obj) throws IOException {
        Incident inc=mapper.readValue(obj.toString(),Incident.class);
        incidentDAO.updateData(as.MakeUpdate(inc),String.valueOf(inc.getIncident_id()));
        logger.info("The incident under the id "+inc.getIncident_id()+" was updated.");
    }
}

