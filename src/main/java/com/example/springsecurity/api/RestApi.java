package com.example.springsecurity.api;

import com.example.springsecurity.models.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApi {
    private List<Car> carList;

    public RestApi() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1, "Audi A4", 2003, "black"));
        carList.add(new Car(2, "BMW 3", 2007, "brown"));
        carList.add(new Car(3, "Mazda CX-5", 2016, "yellow"));
        carList.add(new Car(4, "Seat", 2000, "purple"));
    }

    @GetMapping("/car/{id}")
    public Optional<Car> getCarById(@PathVariable("id") int id){
            return carList.stream()
                    .filter(car -> car.getId() == id)
                    .findFirst();

    }

    @GetMapping("/car")
    public List<Car> getCars(){
        return carList;
    }

    @PostMapping("/car")
    public boolean addCar(@RequestBody Car c){
        return carList.add(c);
    }

    @DeleteMapping("/car/{id}")
    public boolean deleteCar(@PathVariable("id") int id){
        return carList.removeIf(car -> car.getId() == id);
    }
}
