package dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import database.Connector;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public  class DAO implements IDAO {

    private ObjectMapper mapper;
    private TypeReference listReference;
    private String stm;

    private Logger logger=Logger.getLogger(DAO.class);

    public DAO(TypeReference referencedType,String stm) {

        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.listReference = referencedType;
        this.stm=stm;
        logger.info("DAO initialized");
    }
    public Collection<Car> getAllData(){
        Collection<Car> result = new ArrayList();
        try {
            result = mapper.readValue(Connector.execStatement(stm).toString(), listReference);
        } catch (JsonParseException e) {
            logger.error("JSONException occured");
            e.printStackTrace();

        }catch (IOException e) {
            logger.error("IOException occured");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public void addData(Object data) throws AnotherFound, NotFound {


    }



    public Car getDataByID(String title) throws NotFound {
        Collection<Car> cars = this.getAllData();


            for (Car c : cars) {
                if (c.getTitle().equalsIgnoreCase(title)) {
                    logger.info(c.getTitle() + " was returned");
                    return c;

                }
            }

            logger.error(title + " was not found in the database");
            throw new NotFound(title);


        }
    }





