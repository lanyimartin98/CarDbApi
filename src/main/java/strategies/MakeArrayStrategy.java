package strategies;

import java.util.ArrayList;


//These strategy is used for making arrays from the objects parameters. The statement builder builds the statement
//by taking the parameters from these arrays, two strategies where used, one for adding elements to the database
//and one for modifying the existing instances
public abstract class MakeArrayStrategy {

    public abstract ArrayList<Object> MakeAdd(Object data);

    public abstract ArrayList<String> MakeUpdate(Object data);
}

