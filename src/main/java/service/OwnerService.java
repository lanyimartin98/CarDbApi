package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import model.Owner;
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
    public OwnerService(){
        this.ownerDAO=new DAO("Owners","id");
        this.as=new MakeOwnerArrayStrategy();
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.ref = new TypeReference<ArrayList<Owner>>() {


        };
    }
    public Collection<Owner> getAllData() throws NotFound, IOException, AnotherFound {
        return mapper.readValue(ownerDAO.getAllData().toString(),ref);
    }
    public Owner getDataByTitle(String id) throws NotFound, IOException {
        try {
            return mapper.readValue(ownerDAO.getDataByID(id).toString(), Owner.class);
        }catch (NullPointerException e){
            System.out.println("Got it bro!");
        }
        throw new NotFound();
    }
    public void deleteDataByTitle(String id){
        ownerDAO.deleteByID(id);
    }
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        ownerDAO.addData(as.MakeArray(mapper.readValue(obj.toString(),Owner.class)));
    }
}
