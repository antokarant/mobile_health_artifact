package src;

import java.util.List;
import java.util.*;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;



public class Controller {

    @FXML
    private Button realButton;
    @FXML
    private Button fakeButton;
    @FXML
    private TextField previousAnswer;
    @FXML
    private ImageView curPicture;
    @FXML
    private TextField wrongGuesses;
    @FXML
    private TextField correctGuesses;

    
    int correctCount = 0;
    int wrongCount = 0;
    int ongoingGame = 0;
    int fakeorreal = -1;
    
    // 0->fake 1->real


    public void handleCloseButtonAction(ActionEvent event) {
        Platform.exit();
    }

    public void fakeGuess(ActionEvent e){
        if(this.ongoingGame == 0 || fakeorreal == -1)
            return;
        if(fakeorreal == 0){
            this.previousAnswer.setText("Your guess was correct");
            this.correctGuesses.setText("" + ++this.correctCount);
        }
        else{
            this.previousAnswer.setText("Your guess was wrong");
            this.wrongGuesses.setText("" + ++this.wrongCount);
        }

        this.setImage();
    }


    public void realGuess(ActionEvent e){

        if(this.ongoingGame == 0 || fakeorreal == -1)
            return;
        if(fakeorreal == 1){
            this.previousAnswer.setText("Your guess was correct");
            this.correctGuesses.setText("" + ++this.correctCount);

        }
        else{
            this.previousAnswer.setText("Your guess was wrong");
            this.wrongGuesses.setText("" + ++this.wrongCount);
        }

        this.setImage();
    }

    public void startGame(ActionEvent e){
        if(this.ongoingGame == 1){
            // game already underway
            return;
        }
        this.correctCount = 0;
        this.wrongCount = 0;
        this.correctGuesses.setText("0");
        this.wrongGuesses.setText("0");
        this.ongoingGame = 1;
        this.setImage();
    }


    private void setImage(){

        Random rand = new Random(); //instance of random class
        int choice = rand.nextInt(2); 
        if(choice == 0){ // fake image
            File directoryPath = new File("../images/fake");
            String contents[] = directoryPath.list();
            int image = rand.nextInt(contents.length);
            // System.out.println("\"../images/fake/" + contents[image] + "\""); // gia na vlepoume to path
            this.curPicture.setImage(new Image("../images/fake/" + contents[image] + ""));
            this.fakeorreal = 0;

        }
        else{ // real image
            File directoryPath = new File("../images/real");
            String contents[] = directoryPath.list();
            int image = rand.nextInt(contents.length);
            //System.out.println("\"../images/real/" + contents[image] + "\""); // gia na vlepoume to path
            this.curPicture.setImage(new Image("../images/real/" + contents[image] + ""));
            this.fakeorreal = 1;
        }
        
    }  

}
