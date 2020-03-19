package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Owner {

    private String id;
    private String name;



    private LocalDate date_of_birth;
    private boolean underarrest;
    private String picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setDate_of_birth(LocalDate date_of_birth) {
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
    public Owner(String id, String name, LocalDate date_of_birth, boolean underarrest, String picture) {
        this.setId(id);
        this.setName(name);
        this.setDate_of_birth(date_of_birth);
        this.setUnderarrest(underarrest);
        this.setPicture(picture);
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
