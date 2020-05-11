package dao;

import database.Connector;
import database.StatementBuilder;
import exceptions.AnotherFound;
import exceptions.NotFound;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.util.ArrayList;

public  class DAO implements IDAO {

    //This is the data access object of the project, this class uses JSON objects
    // to communicate between the database and the service.

    private String database;
    private String identifier;
    private Logger logger=Logger.getLogger(DAO.class);

    //Initializes the DAO
    public DAO(String database, String identifier) {
        this.identifier=identifier;
        this.database=database;
        logger.info("DAO initialized");
    }

    //Gets data as a JSONArray from the database
    public JSONArray getAllData() throws NotFound, AnotherFound {
        return Connector.execQuery(StatementBuilder.BuildQuery(database));
    }

    //Deletes data from the database
    @Override
    public void deleteByID(String id) {
        try{
            Connector.execDelete(StatementBuilder.BuildDelete(database,identifier,id));
        } catch (NotFound | AnotherFound notFound) {
            logger.error("Instance was not found");

        }
    }
    //Performs update on the database
    @Override
    public void updateData(ArrayList data, String id) {
        try{
            Connector.execUpdate(StatementBuilder.BuildUpdate(database,identifier,id,data));
        }
        catch(Exception e){

        }
    }
    //Adds data to the database
    @Override
    public void addData(ArrayList data) throws AnotherFound, NotFound {
        try {
            Connector.execInsert(StatementBuilder.BuildInsert(database, data));
        }catch(AnotherFound ex){
            logger.error("Another instance was already found with this id.");
        }
    }
    //Retains data from according to the id of the object
    @Override
    public JSONObject getDataByID(String id) throws NotFound {
        try {
            return Connector.execQuery(StatementBuilder.BuildSingleSelect(database, identifier, id)).getJSONObject(0);
        }
        catch (AnotherFound anotherFound)
        {

        }
        catch (JSONException e)
        {
            logger.error("Json expection occured");
        }
        catch (NotFound e)
        {
            logger.error("Instance not found.");
        }
        throw new NullPointerException();
    }

}






