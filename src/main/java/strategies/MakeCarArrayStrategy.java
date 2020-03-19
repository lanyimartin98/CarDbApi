package strategies;

import model.Car;

import java.util.ArrayList;

public class MakeCarArrayStrategy extends MakeArrayStrategy {
    @Override
    public ArrayList<Object> MakeArray(Object data) {
        Car addingCar=(Car)data;
        ArrayList<Object> car=new ArrayList<>();
        car.add(addingCar.getTitle());
        car.add(addingCar.getMake());
        car.add(addingCar.getModel());
        car.add(addingCar.getOwner_id());
        car.add(addingCar.getStart_of_use());
        car.add(addingCar.getHorsepower());
        car.add(addingCar.getUsage_type().ordinal());
        car.add(addingCar.getIn_use().ordinal());
        car.add(addingCar.isUnder_custody());
        car.add(addingCar.getMileage());
        car.add(addingCar.getPicture());
        return car;
    }
}
