package model;

import exceptions.InvalidData;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Owner {

    private String id;
    private String name;
    private LocalDate date_of_birth;
    private boolean underarrest;
    private String picture;
    private Logger logger=Logger.getLogger(Car.class);

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidData {
        if(!id.matches("[0-9][0-9][0-9][0-9][0-9][0-9][A-Z][A-Z]")){
            logger.error("Invalid ID format.");
            throw new InvalidData("Invalid ID format");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) throws InvalidData {
        if(date_of_birth.isAfter(LocalDate.now())){
            logger.error("Date can not be after today.");
            throw new InvalidData("Date can not be after today");
        }
        this.date_of_birth = date_of_birth;
    }

    public boolean isUnderarrest() {
        return underarrest;
    }

    public void setUnderarrest(boolean underarrest) {
        this.underarrest = underarrest;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Owner(){};
    public Owner(String id, String name, LocalDate date_of_birth, boolean underarrest, String picture) throws InvalidData {
        this.setId(id);
        this.setName(name);
        this.setDate_of_birth(date_of_birth);
        this.setUnderarrest(underarrest);
        this.setPicture(picture);
        logger.info("New instance was made on the id of "+id);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", underarrest=" + underarrest +
                ", picture='" + picture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id &&
                underarrest == owner.underarrest &&
                name.equals(owner.name) &&
                date_of_birth.equals(owner.date_of_birth) &&
                Objects.equals(picture, owner.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date_of_birth, underarrest, picture);
    }
}
