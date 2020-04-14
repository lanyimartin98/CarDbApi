package strategies;

import model.Incident;

import java.util.ArrayList;

public class MakeIncidentArrayStrategy extends MakeArrayStrategy {
    @Override
    public ArrayList<Object> MakeArray(Object data) {
        Incident incident=(Incident) data;
        ArrayList<Object> incidentArr=new ArrayList<>();
        incidentArr.add(incident.getIncident_id());
        incidentArr.add(incident.getInc_date());
        incidentArr.add(incident.isOutcome());
        incidentArr.add(incident.getInc_type().ordinal());
        incidentArr.add(incident.getTitle());


        return incidentArr;
    }

    @Override
    public ArrayList<String> MakeUpdate(Object data) {
        return null;
    }
}
