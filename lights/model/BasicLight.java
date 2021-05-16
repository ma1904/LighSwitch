package lights.model;

import java.util.HashSet;
import java.util.Set;

public class BasicLight implements Light{
    private LightRegistration lr;
    private HashSet<LightObserver> observers;
    private int setting;

    public BasicLight(){
        this.observers = new HashSet<>();
        this.setting = 0;
        this.lr = new LightRegistration(observers);
    }

    public int getLuminosity(){
        return setting;
    }

    public void flipSwitch(){
        if(setting == MAX){
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
