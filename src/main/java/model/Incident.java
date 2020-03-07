package model;

import model.enums.incidentType;

import java.time.LocalDate;
import java.util.Objects;

public class Incident {
    private int incident_id;
    private LocalDate inc_date;
    private boolean outcome;
    private incidentType inc_type;
    private String title;

    public int getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(int incident_id) {
        this.incident_id = incident_id;
    }

    public LocalDate getInc_date() {
        return inc_date;
    }

    public void setInc_date(LocalDate inc_date) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public Incident(int incident_id, LocalDate inc_date, boolean outcome, incidentType inc_type, String title) {
        this.incident_id = incident_id;
        this.inc_date = inc_date;
        this.outcome = outcome;
        this.inc_type = inc_type;
        this.title = title;
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
        return "Incident{" +
                "incident_id=" + incident_id +
                ", inc_date=" + inc_date +
                ", outcome=" + outcome +
                ", inc_type=" + inc_type +
                ", title='" + title + '\'' +
                '}';
    }
}
