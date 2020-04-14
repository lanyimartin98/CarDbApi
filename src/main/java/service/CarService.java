package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import org.json.JSONArray;
import org.json.JSONObject;
import strategies.MakeArrayStrategy;
import strategies.MakeCarArrayStrategy;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CarService {
    private IDAO carDAO;
    private MakeArrayStrategy as;
    private ObjectMapper mapper;
    private TypeReference ref;


    public CarService(){
        this.carDAO=new DAO("Cars","title");
        this.as=new MakeCarArrayStrategy();
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.ref = new TypeReference<ArrayList<Car>>() {


        };

    }
    public Collection<Car> getAllData() throws NotFound, IOException, AnotherFound {
        return mapper.readValue(carDAO.getAllData().toString(),ref);
    }
    public Car getDataByTitle(String title) throws NotFound, IOException {
        try {
            return mapper.readValue(carDAO.getDataByID(title).toString(), Car.class);
        }catch (NullPointerException e){
            System.out.println("Got it bro!");
        }
        throw new NotFound();
    }
    public void deleteDataByTitle(String title){
        carDAO.deleteByID(title);
    }
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        carDAO.addData(as.MakeArray(mapper.readValue(obj.toString(),Car.class)));
    }
    public void updateCar(String obj) throws IOException {
        Car car=mapper.readValue(obj.toString(),Car.class);
        carDAO.updateData(as.MakeUpdate(car),car.getTitle());
    }

}
