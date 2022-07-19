package com.example.temperature;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    private MenuBar createMenu() {
        //File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem quitMenuItem = new MenuItem("Quit");
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        newMenuItem.setOnAction(actionEvent -> System.out.println("new is click"));

        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(actionEvent -> {
            aboutApp();
        });
        helpMenu.getItems().addAll(aboutMenuItem);
        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("This is my First Java App");
        alertDialog.setHeaderText("This is my First Java App");
        alertDialog.setContentText("This is my First Java App I am  Bhanu Gawshinde .This is java game app . it is it's running condition. it is launch soon");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes Button is Clicked");
        }else {
            System.out.println("No Button is Clicked !");

        }
    }

    public static void main(String[] args) {
        launch();
    }
}