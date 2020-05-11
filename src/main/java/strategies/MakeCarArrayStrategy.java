package strategies;

import model.Car;

import java.util.ArrayList;

public class MakeCarArrayStrategy extends MakeArrayStrategy {
    @Override
    public ArrayList<Object> MakeArray(Object data) {
        Car addCar=(Car)data;
        ArrayList<Object> car=new ArrayList<>();
        car.add(addCar.getTitle());
        car.add(addCar.getMake());
        car.add(addCar.getModel());
        car.add(addCar.getOwner_id());
        car.add(addCar.getStart_of_use());
        car.add(addCar.getHorsepower());
        car.add(addCar.getUsage_type().ordinal());
        car.add(addCar.getIn_use().ordinal());
        car.add(addCar.isUnder_custody());
        car.add(addCar.getMileage());
        car.add(addCar.getPicture());
        return car;
    }

    @Override
    public ArrayList<String> MakeUpdate(Object data) {
        Car updateCar=(Car)data;
        ArrayList<String> car=new ArrayList<>();
        car.add("\"horsepower\"=\'"+updateCar.getHorsepower()+"\'");
        car.add("\"usage_type\"=\'"+updateCar.getUsage_type().ordinal()+"\'");
        car.add("\"in_use\"=\'"+updateCar.getIn_use().ordinal()+"\'");
        car.add("\"under_custody\"=\'"+updateCar.isUnder_custody()+"\'");
        car.add("\"picture\"=\'"+updateCar.getPicture()+"\'");
        return car;
    }
}
