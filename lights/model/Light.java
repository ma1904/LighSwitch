package lights.model;

public interface Light {
    public static final int MIN = 0;
    public static final int MAX = 100;

    public int getLuminosity();
    public void flipSwitch();
    public void register(LightObserver observer);
    public void deregister(LightObserver observer);
}
