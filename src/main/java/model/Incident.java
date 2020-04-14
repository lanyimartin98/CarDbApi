package model;

import exceptions.InvalidData;
import model.enums.incidentType;
import org.apache.log4j.Logger;

import java.security.InvalidAlgorithmParameterException;
import java.time.LocalDate;
import java.util.Objects;

public class Incident {
    private int incident_id;
    private LocalDate inc_date;
    private boolean outcome;
    private incidentType inc_type;
    private String title;
    private Logger logger=Logger.getLogger(Incident.class);

    public int getIncident_id() {
        return incident_id;
    }

    public LocalDate getInc_date() {
        return inc_date;
    }

    public void setInc_date(LocalDate inc_date) throws InvalidData {
        if(inc_date.isAfter(LocalDate.now())){
            logger.error("Date can not be after today");
            throw new InvalidData("Date can not be after today");
        }
        this.inc_date = inc_date;
    }

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public incidentType getInc_type() {
        return inc_type;
    }

    public void setInc_type(incidentType inc_type) {
        this.inc_type = inc_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidData {
        if(!title.matches("[A-Z][A-Z][A-Z]-[0-9][0-9][0-9]")){
            logger.error("Title does not match default format");
            throw new InvalidData("The format is not correct!");
        }
        this.title = title;
    }

    public Incident(){};
    public Incident(int incident_id, LocalDate inc_date, boolean outcome, incidentType inc_type, String title) throws InvalidData {
        this.incident_id=incident_id;
        this.setInc_date(inc_date);
        this.setOutcome(outcome);
        this.setInc_type(inc_type);
        this.setTitle(title);
        logger.info("New instance made under the ID of:"+this.incident_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incident incident = (Incident) o;
        return incident_id == incident.incident_id &&
                outcome == incident.outcome &&
                inc_date.equals(incident.inc_date) &&
                inc_type == incident.inc_type &&
                title.equals(incident.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incident_id, inc_date, outcome, inc_type, title);
    }

    @Override
    public String toString() {
        return "{" +
                "\"incident_id\":\"" + incident_id + '\"' +
                ", \"inc_date\":\"" + inc_date + '\"' +
                ", \"outcome\":\"" + outcome + '\"' +
                ", \"inc_type\":\"" + inc_type + '\"' +
                ", \"title\":\"" + title + '\"' +
                '}';
    }
}
