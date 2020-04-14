package model;

import exceptions.InvalidData;
import exceptions.MilageCanNotBeLowered;
import model.enums.inUse;
import model.enums.usageType;
import org.apache.log4j.Logger;

import java.security.InvalidAlgorithmParameterException;
import java.time.LocalDate;
import java.util.Objects;

public class Car {

    private String make;
    private String model;
    private String title;
    private String owner_id;
    private LocalDate start_of_use;
    private double horsepower;
    private inUse in_use;
    private boolean under_custody;
    private usageType usage_type;
    private int mileage;
    private String picture;
    private Logger logger=Logger.getLogger(Car.class);

    public String getMake() {
        return make;
    }

    public void setMake(String make) {

        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidData {
        if(!title.matches("[A-Z][A-Z][A-Z]-[0-9][0-9][0-9]")) {
            logger.error("Invalid title format was used");
            throw new InvalidData(title);
        }

        this.title=title;
    }

    public LocalDate getStart_of_use() {
        return start_of_use;
    }

    public void setStart_of_use(LocalDate start_of_use) throws InvalidData {

        if(start_of_use.isAfter(LocalDate.now())){
            logger.error("Invalid date tried to be set");
            throw new InvalidData(start_of_use.toString());
        }
        this.start_of_use = start_of_use;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) throws InvalidAlgorithmParameterException {

        if(horsepower<1){
            throw new InvalidAlgorithmParameterException();
        }

        if(horsepower >1000){
            this.usage_type = usage_type.racecar;
            logger.info(this.title+" was specified as racecar");
            this.horsepower = horsepower;
        }
        else {

            this.horsepower = horsepower;
        }

    }

    public inUse getIn_use() {
        return in_use;
    }

    public void setIn_use(inUse in_use) {
        this.in_use = in_use;
    }

    public boolean isUnder_custody() {
        return under_custody;
    }

    public void setUnder_custody(boolean underCastody) {
        this.under_custody = underCastody;
    }

    public usageType getUsage_type() {
        return usage_type;
    }

    public void setUsage_type(usageType usage_type) {

        this.usage_type = usage_type;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) throws MilageCanNotBeLowered {
        if(mileage <this.mileage){
            logger.error("Milage was tried to be lowered on "+this.title);
            throw new MilageCanNotBeLowered();

        }
        this.mileage = mileage;
    }
    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) throws InvalidData {
        if(!owner_id.matches("[0-9][0-9][0-9][0-9][0-9][0-9][A-Z][A-Z]")) {
            logger.error("ID did not match the patern");
            throw new InvalidData("Invalid data");
        }
        this.owner_id = owner_id;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Car(){

    }
    public Car(String make, String model, String owner_id, String title, LocalDate startOfUse, double horsePower, inUse inUse, boolean underCustody, usageType usageType, int milage, String picture) throws InvalidData, MilageCanNotBeLowered {
        this.setTitle(title);
        this.setMake(make);
        this.setModel(model);
        this.setOwner_id(owner_id);
        this.setStart_of_use(startOfUse);
        this.horsepower = horsePower;
        this.usage_type = usageType.racecar;
        this.in_use = inUse;
        this.under_custody = underCustody;
        this.setMileage(milage);
        this.setPicture(picture);
        logger.info("Instance of car made with the title:"+title);
    }

    @Override
    public String toString() {
        return "{" +
                "\"make\":\"" + make + '\"' +
                ", \"model\":\"" + model + '\"' +
                ", \"title\":\"" + title + '\"' +
                ", \"start_of_use\":\"" + start_of_use + '\"' +
                ", \"horsepower\":\"" + horsepower + '\"' +
                ", \"in_use\":\"" + in_use + '\"' +
                ", \"under_custody\":\"" + under_custody + '\"' +
                ", \"usage_type\":\"" + usage_type + '\"' +
                ", \"mileage\":\"" + mileage + '\"' +
                ", \"picture\":\"" + picture + '\"' +
                ", \"owner_id\":\""+ owner_id+ '\"' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.horsepower, horsepower) == 0 &&
                under_custody == car.under_custody &&
                mileage == car.mileage &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                title.equals(car.title) &&
                start_of_use.equals(car.start_of_use) &&
                in_use == car.in_use &&
                usage_type == car.usage_type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, title, start_of_use, horsepower, in_use, under_custody, usage_type, mileage);
    }


}
