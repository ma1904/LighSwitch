package lights.model;

import java.util.HashSet;
import java.util.Set;

public class LightRegistration {
    private HashSet<LightObserver> observers;
    
    public LightRegistration(HashSet<LightObserver> observers){
        this.observers = observers;
    }

    public void register(LightObserver observer){
        observers.add(observer);
    }

    public void deregister(LightObserver observer){
        observers.remove(observer);
    }
}
