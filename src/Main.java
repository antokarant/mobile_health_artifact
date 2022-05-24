package src;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.application.Platform;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)throws Exception{

       Parent root = FXMLLoader.load(getClass().getResource("../../src/application.fxml"));
       Scene scene = new Scene(root);
       primaryStage.setScene(scene);
       primaryStage.setResizable(false);
       primaryStage.setOnCloseRequest(e -> {Platform.exit();});
       primaryStage.show();
    }
}
