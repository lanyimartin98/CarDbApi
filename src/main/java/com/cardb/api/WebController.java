package com.cardb.api;

import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import model.Incident;
import model.Owner;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import service.CarService;
import service.IncidentService;
import service.OwnerService;

import java.io.IOException;
import java.util.Collection;

//This is the RestHandler which connects the backend with the frontend, it uses Spring WebController and it was also made
//using Composite design pattern

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WebController {
    CarService carService=new CarService();
    OwnerService ownerService=new OwnerService();
    IncidentService incidentService=new IncidentService();
    private Logger logger=Logger.getLogger(WebController.class);

    @GetMapping("/cars")
    public Collection<Car> getAllData() throws AnotherFound, IOException, NotFound {
        logger.info("Get request for all cars were made.");
        return carService.getAllData();
    }
    @GetMapping("/owners")
    public Collection<Owner> getAllOwner() throws AnotherFound, IOException, NotFound {
        logger.info("Get request for all owners were made.");
        return ownerService.getAllData();
    }

    @GetMapping("/incidents")
    public Collection<Incident> getAllIncident() throws AnotherFound, IOException, NotFound {
        logger.info("Get request for all incidents were made.");
        return incidentService.getAllData();
    }

    @GetMapping("/car/{title}")
    public Car getCarByTitle(@PathVariable String title) throws NotFound, IOException {
        logger.info("Get request for the car under the title "+title+" was made.");
        return carService.getDataByTitle(title);
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(@PathVariable String id) throws NotFound, IOException {
        logger.info("Get request for the owner under the id "+id+" was made.");
        return ownerService.getDataById(id);
    }

    @GetMapping("/incident/{id}")
    public Incident getIncidentById(@PathVariable String id) throws NotFound, IOException {
        logger.info("Get request for the incident under the id "+id+" was made.");
        return incidentService.getDataByID(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/car/add")
    public void addCar(@RequestBody String json) throws NotFound, AnotherFound, IOException {
        carService.addData(json);
        logger.info("Post request to add car was performed.");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/owner/add")
    public void addOwner(@RequestBody String json) throws NotFound, AnotherFound, IOException {
        ownerService.addData(json);
        logger.info("Post request to add owner was performed.");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/incident/add")
    public void addIncident(@RequestBody String json) throws NotFound, AnotherFound, IOException {
        incidentService.addData(json);
        logger.info("Post request to add incident was performed.");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/car/delete/{title}")
    public void deleteCar(@PathVariable String title){
        carService.deleteDataByTitle(title);
        logger.info("Delete request made to the car under the title:"+title);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/owner/delete/{id}")
    public void deleteOwner(@PathVariable String id){
        ownerService.deleteDataByID(id);
        logger.info("Delete request made to the owner under the id:"+id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/incident/delete/{id}")
    public void deleteIncident(@PathVariable String id){
        incidentService.deleteByID(id);
        logger.info("Delete request made to the incident under the id:"+id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/carmodify/{title}")
    public Car updateCar(@PathVariable String title) throws NotFound, IOException {
        return carService.getDataByTitle(title);
    }



}
