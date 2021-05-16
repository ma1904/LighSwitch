package lights.model;

public class LightTimer extends Thread{
    private Light light;

    public LightTimer(Light light){
        this.light = light;
    }

    @Override
    public void run(){
        while(true){

            if(light.getLuminosity() == 100){
                try{Thread.sleep(5000);}
                catch(Exception ex){}
                light.flipSwitch();

                if(light.getLuminosity() != 0){
                    light.flipSwitch();
                }
            }
            else{
                try{Thread.sleep(5000);}
                catch(Exception ex){}
            }
        }  
    }
}
