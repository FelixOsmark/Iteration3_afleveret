package sample;

import java.sql.SQLException;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control .*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing .*;


public class Gui extends Application {


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Coronaappen");


//builder scene 1

        Button button11 = new Button("LOGIN");
        VBox vBox = new VBox();
        Label label1 = new Label("Welcome to Coronaappen - Continue by Logging in");
        label1.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 50, 50, 50));

        vBox.getChildren().addAll(
                label1,
                new Label("Your Name"),
                new TextField(),
                new Label("Your CPR-#"),
                new PasswordField(),
                button11);
        vBox.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(vBox, 960, 600);


//builder scene 2

        ToolBar toolBar1 = new ToolBar();
        GridPane gridMain = new GridPane();

        gridMain.add(new ToolBar(), 0, 2);

        Button button21 = new Button("Search");
        toolBar1.getItems().add(button21);
        Button button22 = new Button("Statistics");
        toolBar1.getItems().add(button22);
        Button button23 = new Button("News");
        toolBar1.getItems().add(button23);
        Button button24 = new Button("Help");
        toolBar1.getItems().add(button24);




        Button searchName = new Button("Search with Name");
        Button searchCpr = new Button("Search with CPR");

        VBox vBox21 = new VBox(toolBar1,
                searchName,
                new TextField(),
                searchCpr,
                new TextField());


        Scene scene2 = new Scene(gridMain, 960, 600);



//builder scene 3
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Test", new Label("Show Test"));
        Tab tab2 = new Tab("Geolocation", new Label("Show Geolocation"));
        Tab tab3 = new Tab("Sensor data", new Label("Show Sensor data"));
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        //Table1
        TableView tableView1 = new TableView();
        Button tableReturn1 = new Button("Return");

        TableColumn<String, String> column11 = new TableColumn<>("Test");
        column11.setCellValueFactory(new PropertyValueFactory<>("test"));
        TableColumn<String, String> column12 = new TableColumn<>("Results");
        column12.setCellValueFactory(new PropertyValueFactory<>("results"));
        tableView1.getColumns().add(column11);
        tableView1.getColumns().add(column12);
        tableView1.getItems().add("EKG");
        tableView1.getItems().add("Death");
        VBox vboxtable1 = new VBox(tableView1, tableReturn1);
        tab1.setContent(vboxtable1);

        //Table2
        TableView tableView2 = new TableView();
        Button tableReturn2 = new Button("Return");

        TableColumn<String, String> column21 = new TableColumn<>("Geolocation last 24h");
        column21.setCellValueFactory(new PropertyValueFactory<>("geolocationLast24h"));
        tableView2.getColumns().add(column21);
        tableView2.getItems().add("5465546542");
        VBox vboxtable2 = new VBox(tableView2, tableReturn2);
        tab2.setContent(vboxtable2);

        //Table3
        TableView tableView3 = new TableView();
        Button tableReturn3 = new Button("Return");

        TableColumn<String, String> column31 = new TableColumn<>("Sensor Data");
        column31.setCellValueFactory(new PropertyValueFactory<>("sensorData"));
        tableView3.getColumns().add(column31);
        tableView3.getItems().add("231321321");
        VBox vboxtable3 = new VBox(tableView3, tableReturn3);
        tab3.setContent(vboxtable3);


        VBox vBox312 = new VBox(tabPane);
        Scene scene3 = new Scene(vBox312, 960, 600);


//ButtonAction

        button11.setOnAction(e -> primaryStage.setScene(scene2));
        tableReturn1.setOnAction(e -> primaryStage.setScene(scene2));
        tableReturn2.setOnAction(e -> primaryStage.setScene(scene2));
        tableReturn3.setOnAction(e -> primaryStage.setScene(scene2));
        searchCpr.setOnAction(e -> primaryStage.setScene(scene3));
        searchName.setOnAction(e -> primaryStage.setScene(scene3));

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
