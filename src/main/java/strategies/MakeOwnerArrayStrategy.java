package strategies;

import model.Car;
import model.Owner;

import java.util.ArrayList;

public class MakeOwnerArrayStrategy extends MakeArrayStrategy {
    @Override
    public ArrayList<Object> MakeArray(Object data) {
        Owner addOwner=(Owner)data;
        ArrayList<Object> owner=new ArrayList<>();
        owner.add(addOwner.getId());
        owner.add(addOwner.getName());
        owner.add(addOwner.getDate_of_birth());
        owner.add(addOwner.isUnderarrest());
        owner.add(addOwner.getPicture());
        return owner;
    }

    @Override
    public ArrayList<String> MakeUpdate(Object data) {
        Owner updateOwner=(Owner) data;
        ArrayList<String> owner=new ArrayList<>();
        owner.add("\"name\"=\'"+updateOwner.getName()+"\'");
        owner.add("\"usage_type\"=\'"+updateOwner.getPicture()+"\'");
        owner.add("\"in_use\"=\'"+updateOwner.isUnderarrest()+"\'");
        return owner;
    }
}
