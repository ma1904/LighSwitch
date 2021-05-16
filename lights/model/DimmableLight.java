package lights.model;

import java.util.HashSet;
import java.util.Set;

import org.junit.experimental.max.MaxCore;

public class DimmableLight implements Light{
    private LightRegistration lr;
    private HashSet<LightObserver> observers;
    private int setting;

    public DimmableLight(){
        observers = new HashSet<>();
        setting = 0;
        lr = new LightRegistration(observers);
    }

    public int getLuminosity(){
        return setting;
    }

    public void flipSwitch(){
        if(setting == MIN){
            setting = MAX/2;
        }
        else if(setting == MAX){
            setting = MIN;
        }
        else{
            setting = MAX;
        }

        notifyAllObservers();
    }

    public void register(LightObserver observer){
        lr.register(observer);
    }

    public void deregister(LightObserver observer){
        lr.deregister(observer);
    }

    private void notifyAllObservers(){
        for(LightObserver observer : observers){
            observer.luminosityChanged(setting);
        }
    }
}
