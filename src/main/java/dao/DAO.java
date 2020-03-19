package dao;

import database.Connector;
import database.StatementBuilder;
import exceptions.AnotherFound;
import exceptions.NotFound;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public  class DAO implements IDAO {


    private String database;
    private String identifier;

    private Logger logger=Logger.getLogger(DAO.class);


    public DAO(String database, String identifier) {

        this.identifier=identifier;
        this.database=database;


        logger.info("DAO initialized");
    }
    public JSONArray getAllData() throws NotFound, AnotherFound {
        return Connector.execQuery(StatementBuilder.BuildQuery(database));
    }

    @Override
    public void deleteByID(String id) {
        try{
            Connector.execDelete(StatementBuilder.BuildDelete(database,identifier,id));
        } catch (AnotherFound | NotFound notFound) {
            System.out.println("Got that too");
        }
    }


    @Override
    public void addData(ArrayList data) throws AnotherFound, NotFound {
        System.out.println(StatementBuilder.BuildInsert(database,data));
        try {
            Connector.execInsert(StatementBuilder.BuildInsert(database, data));
        }catch(AnotherFound ex){
            System.out.println("Found that");
        }
    }

    @Override
    public JSONObject getDataByID(String title) throws NotFound {
        try {
            return Connector.execQuery(StatementBuilder.BuildSingleSelect(database, identifier, title)).getJSONObject(0);

        } catch (AnotherFound anotherFound) {

        } catch (JSONException e) {

        } catch (NotFound e) {
            System.out.println("Gooooot that");
        }
        throw new NullPointerException();
    }

    }






