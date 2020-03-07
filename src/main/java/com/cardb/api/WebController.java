package com.cardb.api;

import dao.DAO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    static String file ="cars.json";
    /*DAO carDao=new DAO();*/

    /*
    @GetMapping("/cars")
    public Collection<Car> getAllCars() throws NotFound, IOException {
        return carDao.getAllData();

    }
    @GetMapping("/car/{title}")
    public Car getCarByTitle(@PathVariable String title) throws NotFound {
        return carDao.getDataByID(title);
    }
    @GetMapping("/owners")
    public Collection<Owner> getAllOwners(){
        return ownerDAO.getAllData();
    }
    @GetMapping("/owner/{id}")
    public Owner getOwnerByID(@PathVariable String id) throws NotFound {
        return ownerDAO.getDataByID(id);
    }


     */

}
