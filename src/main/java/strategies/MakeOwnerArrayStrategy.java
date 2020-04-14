package strategies;

import model.Owner;

import java.util.ArrayList;

public class MakeOwnerArrayStrategy extends MakeArrayStrategy {
    @Override
    public ArrayList<Object> MakeArray(Object data) {
        Owner owner=(Owner)data;
        ArrayList<Object> arr=new ArrayList<>();
        arr.add(owner.getId());
        arr.add(owner.getName());
        arr.add(owner.getDate_of_birth());
        arr.add(owner.isUnderarrest());
        arr.add(owner.getPicture());
        return arr;
    }

    @Override
    public ArrayList<String> MakeUpdate(Object data) {
        return null;
    }
}
