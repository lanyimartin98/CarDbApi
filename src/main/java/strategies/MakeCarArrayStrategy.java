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
