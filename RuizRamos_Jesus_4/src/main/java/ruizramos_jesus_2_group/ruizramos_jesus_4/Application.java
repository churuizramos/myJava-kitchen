package ruizramos_jesus_2_group.ruizramos_jesus_4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogEvent;
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

import java.io.IOException;
import java.text.DecimalFormat;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        //windows
        Polygon frontWindow = new Polygon();
        frontWindow.setFill(Color.LIGHTBLUE);
        frontWindow.setStroke(Color.BLACK);
        frontWindow.getPoints().addAll(new Double[]{
                270.0,90.0,
                320.0,140.0,
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
                270.0,80.0, //p5

                //front
                330.0,140.0, //p6
                390.0,150.0, //p7
                400.0,200.0, //p8

                //wheel well 1
                360.0,200.0,
                360.0,180.0,
                340.0,160.0,
                310.0,160.0,
                290.0,180.0,
                290.0,200.0,

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

        //slider to change the length of the car
        Label lengthSliderLabel = new Label("Car Length: ");
        Text lengthValueText = new Text("0.0");
        Slider lengthSlider = new Slider(0.0,100.0,0.0);
        lengthSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                        lengthValueText.setText("" + new DecimalFormat("#.#").format(t1));
                        updateCarLength(chassis, frontWindow, rim1, tire1, internals, t1.doubleValue());
                    }
                }
        );
        HBox lengthSliderBox = new HBox(lengthSliderLabel,lengthSlider,lengthValueText);

        //slider to change the wheel size of the car
        Label tireWidthLabel = new Label("Tire Width: ");
        Text tireWidthValue = new Text("30.0");
        Slider tireWidthSlider = new Slider(10.0,100.0,30.0);
        tireWidthSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                tireWidthValue.setText("" + new DecimalFormat("#.#").format(t1));
                updateTireWidth(tire1,tire2,t1.doubleValue());
            }
        });
        HBox tireWidthSliderBox = new HBox(tireWidthLabel,tireWidthSlider,tireWidthValue);

        //dropdown box to change the color of the car
        Label colorSelectLabel = new Label("Car Color: ");
        ChoiceBox colorSelect = new ChoiceBox();
        colorSelect.getItems().addAll("Red","Blue","Orange","Purple","Black","White","Yellow","Green");
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
                case "Black":
                    selectedFillColor = Color.BLACK;
                    break;
                case "White":
                    selectedFillColor = Color.WHITE;
                    break;
                case "Yellow":
                    selectedFillColor = Color.YELLOW;
                    break;
                case "Green":
                    selectedFillColor = Color.GREEN;
                    break;
            }
            chassis.setFill(selectedFillColor);
        });
        HBox colorSelectBox = new HBox(colorSelectLabel,colorSelect);

        HBox controlsBox = new HBox(lengthSliderBox,tireWidthSliderBox,colorSelectBox);
        controlsBox.setSpacing(30);
        controlsBox.setAlignment(Pos.CENTER);

        /**
         * generic rendering classes
         */
        VBox root = new VBox(display, controlsBox);
        root.setSpacing(30);
        Scene scene = new Scene(root, 900, 400);
        stage.setTitle("Car Designer");
        stage.setScene(scene);
        stage.show();
    }

    private void updateTireWidth(Circle wheel1, Circle wheel2, double radius){
        wheel1.setRadius(radius);
        wheel2.setRadius(radius);
    }

    private void updateCarLength(Polygon car, Polygon window, Circle rim, Circle tire, Rectangle internal, double carExtension){
        car.getPoints().setAll(new Double[]{
                //back
                50.0,200.0, //p1
                40.0,120.0, //p2
                70.0,90.0, //p3

                //roofline
                100.0,80.0, //p4
                270.0 + carExtension,80.0, //p5

                //front
                330.0 + carExtension,140.0, //p6
                390.0 + carExtension,150.0, //p7
                400.0 + carExtension,200.0, //p8

                //wheel well 1
                360.0 + carExtension,200.0,
                360.0 + carExtension,180.0,
                340.0 + carExtension,160.0,
                310.0 + carExtension,160.0,
                290.0 + carExtension,180.0,
                290.0 + carExtension,200.0,

                //wheel well 2
                150.0,200.0,
                150.0,180.0,
                130.0,160.0,
                100.0,160.0,
                80.0,180.0,
                80.0,200.0
        });

        window.getPoints().setAll(new Double[]{
                270.0 + carExtension,90.0,
                320.0 + carExtension,140.0,
                205.0,140.0,
                185.0,90.0,
        });

        rim.setCenterX(325.0 + carExtension);
        tire.setCenterX(325.0 + carExtension);

        internal.setWidth(300.0 + carExtension);
    }

    public static void main(String[] args) {
        launch();
    }
}