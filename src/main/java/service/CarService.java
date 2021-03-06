package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.DAO;
import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import org.apache.log4j.Logger;
import strategies.MakeArrayStrategy;
import strategies.MakeCarArrayStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

//The services are the bridge between the RestHandler and the DAO, these are the ones that specify data types
//to ensure that the right model is used Jackson type reference is being used and the whole model is build upon
//the Composite design pattern.

public class CarService {
    private IDAO carDAO;
    private MakeArrayStrategy as;
    private ObjectMapper mapper;
    private TypeReference ref;
    private Logger logger=Logger.getLogger(CarService.class);

    public CarService(){
        this.carDAO=new DAO("Cars","title");
        this.as=new MakeCarArrayStrategy();
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.ref = new TypeReference<ArrayList<Car>>() {
        };
        logger.info("CarService is initialized");
    }
    //Returns the content of the "Cars" table
    public Collection<Car> getAllData() throws NotFound, IOException, AnotherFound {
        logger.info("All data of cars were returned.");
        return mapper.readValue(carDAO.getAllData().toString(),ref);
    }
    //Returns the "Car" instance with the given title
    public Car getDataByTitle(String title) throws NotFound, IOException {
        try {
            logger.info("Data of car under title "+title+" was returned.");
            return mapper.readValue(carDAO.getDataByID(title).toString(), Car.class);
        }catch (NullPointerException e){
            logger.error("NullPointer exception occured.");
        }
        logger.error("No car was found under the title "+title+".");
        throw new NotFound();
    }
    //Deletes the instance with the given title
    public void deleteDataByTitle(String title){
        carDAO.deleteByID(title);
        logger.info("The car under the title "+title+" was deleted.");
    }
    //Specifies the add operation for the DAO.
    public void addData(String obj) throws IOException, NotFound, AnotherFound {
        carDAO.addData(as.MakeAdd(mapper.readValue(obj.toString(),Car.class)));
        logger.info("Insert of new car completed.");
    }
    //Specifies the modify operation for the DAO.
    public void updateCar(String obj) throws IOException {
        Car car=mapper.readValue(obj.toString(),Car.class);
        carDAO.updateData(as.MakeUpdate(car),car.getTitle());
        logger.info("The car under the title "+car.getTitle()+" was updated.");
    }

}
