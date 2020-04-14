package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.AnotherFound;
import exceptions.NotFound;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public interface IDAO<T> {
    void addData(ArrayList<Object> data) throws AnotherFound, NotFound;
    JSONObject getDataByID(java.lang.String id) throws NotFound;
    JSONArray getAllData() throws NotFound, AnotherFound;
    void deleteByID(java.lang.String id);
    void updateData(ArrayList<String> data, String id);
}
