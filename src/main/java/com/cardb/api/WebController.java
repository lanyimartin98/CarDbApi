package com.cardb.api;

import dao.IDAO;
import exceptions.AnotherFound;
import exceptions.NotFound;
import model.Car;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WebController {
    CarService carService=new CarService();

    @GetMapping("/cars")
    public Collection<Car> getAllData() throws AnotherFound, IOException, NotFound {
        return carService.getAllData();
    }
    @GetMapping("/car/{title}")
    public Car getCarByTitle(@PathVariable String title) throws NotFound, IOException {
        return carService.getDataByTitle(title);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/car/add")
    public void addCar(@RequestBody String json) throws NotFound, AnotherFound, IOException {
        carService.addData(json);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/car/delete/{id}")
    public void deleteCar(@PathVariable String id){
        carService.deleteDataByTitle(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/carmodify/{title}")
    public Car updateCar(@PathVariable String title) throws NotFound, IOException {
        return carService.getDataByTitle(title);
    }



}
