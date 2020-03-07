package service;

import dao.DAO;
import dao.IDAO;
import database.Connector;
import database.StatementBuilder;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import model.enums.usageType;

import java.util.ArrayList;
import java.util.Collection;

public class CarService implements IDAO {
    private com.fasterxml.jackson.core.type.TypeReference ref;
    private DAO carDAO;



    public CarService(){

        ref = new com.fasterxml.jackson.core.type.TypeReference<ArrayList<Car>>() {
        };
        carDAO = new DAO(ref, StatementBuilder.BuildQuery("Cars"));
    }

    @Override
    public void addData(Object data) throws AnotherFound, NotFound {
        data=(Car)data;
        ArrayList<Object> car=new ArrayList<>();
        car.add(((Car) data).getTitle());
        car.add(((Car) data).getMake());
        car.add(((Car) data).getModel());
        car.add(((Car) data).getOwner_id());
        car.add(((Car) data).getStart_of_use());
        car.add(((Car) data).getHorsepower());
        car.add(((Car) data).getUsage_type());
        car.add(((Car) data).getIn_use());
        car.add(((Car) data).isUnder_custody());
        car.add(((Car) data).getMileage());
        car.add(((Car) data).getPicture());

    }

    @Override
    public Car getDataByID(String id) throws NotFound {
        return carDAO.getDataByID(id);
    }

    @Override
    public Collection getAllData() {
        return carDAO.getAllData();
    }

    @Override
    public void deleteByID(String id) {

    }
    public ArrayList<Object> makeArray(Object data) throws AnotherFound, NotFound {
        Car addingCar=(Car)data;
        ArrayList<Object> car=new ArrayList<>();
        car.add(addingCar.getTitle());
        car.add(addingCar.getMake());
        car.add(addingCar.getModel());
        car.add(addingCar.getOwner_id());
        car.add(addingCar.getStart_of_use());
        car.add(addingCar.getHorsepower());
        car.add(addingCar.getUsage_type().ordinal());
        car.add(addingCar.getIn_use().ordinal());
        car.add(addingCar.isUnder_custody());
        car.add(addingCar.getMileage());
        car.add(addingCar.getPicture());
        return car;

    }
}
