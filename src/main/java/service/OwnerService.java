package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Owner;
import org.apache.log4j.Logger;
import strategies.MakeArrayStrategy;
import strategies.MakeOwnerArrayStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class OwnerService {
    private IDAO ownerDAO;
    private MakeArrayStrategy as;
    private ObjectMapper mapper;
    private TypeReference ref;
    private Logger logger=Logger.getLogger(OwnerService.class);

    public OwnerService(){
        this.ownerDAO=new DAO("Owners","id");
        this.as=new MakeOwnerArrayStrategy();
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.ref = new TypeReference<ArrayList<Owner>>() {
        };
        logger.info("OwnerService initialized.");
    }
    //Returns the content of the "Owners" table
    public Collection<Owner> getAllData() throws NotFound, IOException, AnotherFound {
        logger.info("All data of owners were returned.");
        return mapper.readValue(ownerDAO.getAllData().toString(),ref);
    }
    //Returns the "Owner" instance with the given id
    public Owner getDataById(String id) throws NotFound, IOException {
        try {
            logger.info("Data of owner under id:"+id+" was returned.");
            return mapper.readValue(ownerDAO.getDataByID(id).toString(), Owner.class);
        }catch (NullPointerException e){
            logger.error("NullPointer exception occured");
        }
        logger.error("Instance not found under the id:"+id+".");
        throw new NotFound();

    }
    //Deletes the instance with the given id
    public void deleteDataByID(String id){
        ownerDAO.deleteByID(id);
        logger.info("The owner under the id "+id+" was deleted.");
    }
    //Specifies the add operation for the DAO.
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        ownerDAO.addData(as.MakeAdd(mapper.readValue(obj.toString(),Owner.class)));
        logger.info("Insert of a new owner performed.");
    }
    //Specifies the modify operation for the DAO.
    public void updateOwner(String obj) throws IOException {
        Owner owner=mapper.readValue(obj.toString(),Owner.class);
        ownerDAO.updateData(as.MakeUpdate(owner),owner.getId());
        logger.info("The owner under the id "+owner.getId()+" was updated.");
    }
}
