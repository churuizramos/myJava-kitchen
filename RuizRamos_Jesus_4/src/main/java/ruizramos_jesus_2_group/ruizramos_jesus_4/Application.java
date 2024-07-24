package ruizramos_jesus_2_group.ruizramos_jesus_4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * default variables
         */
        double carXExtension = 0;
        /**
         * car render
         */

        //windows
        Polygon frontWindow = new Polygon();
        frontWindow.setFill(Color.LIGHTBLUE);
        frontWindow.setStroke(Color.BLACK);
        frontWindow.getPoints().addAll(new Double[]{
                270.0 + carXExtension,90.0,
                320.0 + carXExtension,140.0,
                205.0,140.0,
                185.0,90.0,
        });
        Polygon backWindow = new Polygon();
        backWindow.setFill(Color.LIGHTBLUE);
        backWindow.setStroke(Color.BLACK);
        backWindow.getPoints().addAll(new Double[]{
                175.0,90.0,
                195.0,140.0,
                60.0,120.0,
                100.0,90.0

        });
        Group windows = new Group(frontWindow,backWindow);

        //body backdrop for the underneath of the car
        Rectangle internals = new Rectangle(80.0,160.0,300.0,30.0);
        internals.setFill(Color.GRAY);

        //main chassis and shape of the car
        Polygon chassis = new Polygon();
        chassis.setStroke(Color.BLACK);
        chassis.setFill(Color.WHITE);
        chassis.getPoints().addAll(new Double[]{
                //back
                50.0,200.0, //p1
                40.0,120.0, //p2
                70.0,90.0, //p3

                //roofline
                100.0,80.0, //p4
                270.0 + carXExtension,80.0, //p5

                //front
                330.0 + carXExtension,140.0, //p6
                390.0 + carXExtension,150.0, //p7
                400.0 + carXExtension,200.0, //p8

                //wheel well 1
                360.0 + carXExtension,200.0,
                360.0 + carXExtension,180.0,
                340.0 + carXExtension,160.0,
                310.0 + carXExtension,160.0,
                290.0 + carXExtension,180.0,
                290.0 + carXExtension,200.0,

                //wheel well 2
                150.0,200.0,
                150.0,180.0,
                130.0,160.0,
                100.0,160.0,
                80.0,180.0,
                80.0,200.0
        });
        Group body = new Group(internals, chassis);

        //wheels
        Circle tire1 = new Circle(325.0,190.0,30.0);
        Circle rim1 = new Circle(325.0,190.0, 20.0, Color.GRAY);
        Group wheel1 = new Group(tire1, rim1);
        Circle tire2 = new Circle(115.0,190.0,30.0);
        Circle rim2 = new Circle(115.0,190.0, 20.0, Color.GRAY);
        Group wheel2 = new Group(tire2, rim2);

        //pane to separate the render from the controls
        Group car = new Group(body,windows,wheel1,wheel2);
        Pane display = new Pane(car);

        /**
         * controls
         */
        //slider to change the length of the car
        Label lengthSliderLabel = new Label("Length: ");
        Text lengthValueText = new Text("" + carXExtension);
        Slider lengthSlider = new Slider(0.0,50.0,0.0);
        lengthSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                        lengthValueText.setText("" + new DecimalFormat("#.#").format(t1));
                    }
                }
        );
        HBox lengthSliderBox = new HBox(lengthSliderLabel,lengthSlider,lengthValueText);

        //dropdown box to change the color of the car
        Label colorSelectLabel = new Label("Color: ");
        ChoiceBox colorSelect = new ChoiceBox();
        colorSelect.getItems().addAll("Red","Blue","Orange","Purple");
        colorSelect.setOnAction(e->{
            String selectedColor = (String) colorSelect.getValue();
            Color selectedFillColor = Color.WHITE;
            switch (selectedColor) {
                case "Red":
                    selectedFillColor = Color.RED;
                    break;
                case "Blue":
                    selectedFillColor = Color.BLUE;
                    break;
                case "Orange":
                    selectedFillColor = Color.ORANGE;
                    break;
                case "Purple":
                    selectedFillColor = Color.PURPLE;
                    break;
            }
            chassis.setFill(selectedFillColor);
        });
        HBox colorSelectBox = new HBox(colorSelectLabel,colorSelect);

        HBox controlsBox = new HBox(lengthSliderBox,colorSelectBox);
        controlsBox.setSpacing(30);
        controlsBox.setAlignment(Pos.CENTER);

        /**
         * generic rendering classes
         */
        VBox root = new VBox(display, controlsBox);
        root.setSpacing(30);
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Car Designer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}