package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import database.StatementBuilder;
import exceptions.NotFound;
import model.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;

class DAOTest {

    @Test
    void getAllCars() throws NotFound {
        TypeReference ref;
        ref = new com.fasterxml.jackson.core.type.TypeReference<ArrayList<Car>>() {
        };

        DAO dao=new DAO(ref,StatementBuilder.BuildQuery("Cars"));
        System.out.println(dao.getDataByID("NSR-107"));
        System.out.println(dao.getAllData());
    }
}