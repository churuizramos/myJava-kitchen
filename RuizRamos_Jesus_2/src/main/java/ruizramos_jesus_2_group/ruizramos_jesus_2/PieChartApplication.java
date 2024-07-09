/**
 * RuizRamos_Jesus_2
 * Created by Jesus Ruiz Ramos
 *
 * An application that generates a pie chart from inputs. The Generate from file button is still a WIP. It will only open a window and filter for txt files.
 * When a valid file is selected this will just print "Works" in the command line.
 *
 * This project is written using IntelliJ Idea.
 * Written using OpenJDK 22.0.1
 * JavaFX provided automatically by IntelliJ, so I could not find which version of JavaFX this uses.
 *
 * Original code at https://github.com/churuizramos/my-java-kitchen
 *
 * Notes:
 *      Could not get the file reading to work. For now the File button just opens a dialog, but it doesn't do anything.
 */

package ruizramos_jesus_2_group.ruizramos_jesus_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
//import java.util.Scanner;

public class PieChartApplication extends Application {
    // Declare all value and label fields
    private TextField valueField1, valueField2, valueField3, valueField4;
    private TextField labelField1, labelField2, labelField3, labelField4;
    private Pane pieChartPane;

    @Override
    public void start(Stage stage) {
        // Create text fields
        valueField1 = new TextField();
        valueField2 = new TextField();
        valueField3 = new TextField();
        valueField4 = new TextField();

        // Create text fields for the labels
        labelField1 = new TextField();
        labelField2 = new TextField();
        labelField3 = new TextField();
        labelField4 = new TextField();

        // Initialize a button to generate the pie chart
        Button generatePieChartButton = new Button("Generate with Values");
        Button generatePieChartFromFile = new Button("Generate with File");

        // Layout for value and label input fields
        HBox inputBox1 = new HBox(10, new Label("Value 1:"), valueField1, new Label("Label 1:"), labelField1);
        inputBox1.setAlignment(Pos.CENTER);
        HBox inputBox2 = new HBox(10, new Label("Value 2:"), valueField2, new Label("Label 2:"), labelField2);
        inputBox2.setAlignment(Pos.CENTER);
        HBox inputBox3 = new HBox(10, new Label("Value 3:"), valueField3, new Label("Label 3:"), labelField3);
        inputBox3.setAlignment(Pos.CENTER);
        HBox inputBox4 = new HBox(10, new Label("Value 4:"), valueField4, new Label("Label 4:"), labelField4);
        inputBox4.setAlignment(Pos.CENTER);

        // Organize buttons
        HBox buttons = new HBox(10, generatePieChartButton, generatePieChartFromFile);
        buttons.setAlignment(Pos.CENTER);

        // Organize all HBox objects together
        VBox inputLayout = new VBox(10, inputBox1, inputBox2, inputBox3, inputBox4, buttons);

        // Pane to display pie chart
        pieChartPane = new Pane();
        pieChartPane.setPrefSize(400,400);

        // Main layout
        VBox mainLayout = new VBox(20, inputLayout, pieChartPane);

        // Assign values button action
        generatePieChartButton.setOnAction(e -> {
            generatePieChart(valueField1.getText(), valueField2.getText(), valueField3.getText(), valueField4.getText(), labelField1.getText(), labelField2.getText(), labelField3.getText(), labelField4.getText());
        });

        // Assign file button action
        generatePieChartFromFile.setOnAction(e -> openFile());

        // Render the scene
        Scene scene = new Scene(mainLayout, 600, 600);
        stage.setTitle("Pie Chart Generator");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Opens a file chooser (Testing purposes only)
     */
    private void openFile() {
        String[] fileValues = new String[4];
        String[] fileLabels = new String[4];

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            System.out.println("Works");
        }

    }

//    private void readFile(File file) {
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//
//        }
//    }

    /**
     * Generates a pie chart from inputted String objects
     * @param value1 First value
     * @param value2 Second value
     * @param value3 Third value
     * @param value4 Fourth value
     *
     * @param label1 First label
     * @param label2 Second label
     * @param label3 Third label
     * @param label4 Fourth label
     */
    private void generatePieChart(String value1, String value2, String value3, String value4, String label1, String label2, String label3, String label4) {
        // Convert values to double
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);
        double doubleValue3 = Double.parseDouble(value3);
        double doubleValue4 = Double.parseDouble(value4);

        // Calculate the total
        double total = (doubleValue1 + doubleValue2 + doubleValue3 + doubleValue4);

        // Calculate the percentages
        double[] percentages = {doubleValue1/total, doubleValue2/total, doubleValue3/total, doubleValue4/total};

        String[] labels = {label1, label2, label3, label4};
        // Colors for segments
        Color[] colors = {Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN};

        // Draws the arcs
        double angle = 0;
        for (int i = 0; i < percentages.length; i++) {
            double arcExtent = percentages[i] * 360;

            // Create an arc
            Arc arc = new Arc(200,200,150,150, angle, arcExtent);
            arc.setFill(colors[i]);
            arc.setType(ArcType.ROUND);

            // Add arc to the pane
            pieChartPane.getChildren().add(arc);

            // Update start angle for the next segment
            angle += arcExtent;

            // Add labels and percentages
            Label percentageLabel = new Label(String.format("%s: %.2f%%", labels[i], percentages[i]*100));
            percentageLabel.setTextFill(colors[i]);
            percentageLabel.setLayoutX(20);
            percentageLabel.setLayoutY(20 + i * 20);
            pieChartPane.getChildren().add(percentageLabel);
        }
    }

    /**
     * Initiates the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}