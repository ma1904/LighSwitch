package lights.model;

import java.util.Observer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LightGUI extends Application{
    private Light lightSwitch;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        this.lightSwitch = new DimmableLight();
        VBox box = new VBox();

        Label light = new Label("");
        light.setAlignment(Pos.CENTER);
        light.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        light.setPadding(new Insets(50));
        light.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY)));

        Button button = new Button("Light Switch");
        button.setAlignment(Pos.CENTER);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setPadding(new Insets(10));
        
        lightSwitch.register((o) -> {
            lightSwitch.getLuminosity();
        });

        button.setOnAction((e) -> {
            lightSwitch.flipSwitch();
            lightUpdate(lightSwitch, light);
        });

        box.getChildren().addAll(
            light,
            button
        );

        primaryStage.setTitle("My Light Switch");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
    }

    private void lightUpdate(Light light, Label label){
        switch(light.getLuminosity()){
            case 100:
                label.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
                break;
            case 50:
                label.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(0), Insets.EMPTY)));
                break;
            case 0:
                label.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY)));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
