package dao;

import exceptions.AnotherFound;
import exceptions.NotFound;
import org.junit.jupiter.api.Test;

class DAOTest {

    @Test
    void getAllCars() throws NotFound, AnotherFound {
        DAO dao=new DAO("Cars","title");
        System.out.println(dao.getAllData());
    }
    @Test
    void Delete(){
        DAO dao=new DAO("Cars","title");
        dao.deleteByID("NNN-999");
    }
    @Test
    void getDataById() throws NotFound {
        DAO dao=new DAO("Cars","title");
        System.out.println(dao.getDataByID("NSR-107"));

    }
}
