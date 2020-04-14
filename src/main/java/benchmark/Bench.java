package benchmark;

import org.apache.log4j.Logger;

public class Bench {

    private double start;
    private String usedIn;
    private Logger logger=Logger.getLogger(Bench.class);

    public void start(String usedIn){
        this.start=System.nanoTime();
        this.usedIn=usedIn;
    }
    public void stop(){
        logger.info(((System.nanoTime()-this.start)/1000));
    }
    public Bench(){

    }
}
