package src;

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
    private TextField startGameOver;
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

    List<String> realImages;
    List<String> fakeImages;

    
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


        File directoryPath = new File("../images/real");
        this.realImages = new ArrayList<String>(Arrays.asList(directoryPath.list()));
        directoryPath = new File("../images/fake");
        this.fakeImages = new ArrayList<String>(Arrays.asList(directoryPath.list()));

        this.startGameOver.setText("Game is underway!");
        this.previousAnswer.clear();


        this.setImage();
    }


    private void setImage(){
        Random rand = new Random(); //instance of random class
        int choice = rand.nextInt(2); 
        if(choice == 0){ // fake image
            if(this.fakeImages.size()==0){
                this.ongoingGame = 0;
                this.fakeorreal = -1;
                this.startGameOver.setText("The game is finished!");
                this.curPicture.setImage(null);
                return;
            }
            int image = rand.nextInt(this.fakeImages.size());
            // System.out.println("\"../images/fake/" + contents[image] + "\""); // gia na vlepoume to path
            this.curPicture.setImage(new Image("../images/fake/" + this.fakeImages.get(image) + ""));
            this.fakeorreal = 0;
            this.fakeImages.remove(image);

        }
        else{ // real image
            if(this.realImages.size()==0){
                this.ongoingGame = 0;
                this.fakeorreal = -1;
                this.startGameOver.setText("The game is finished!");
                this.curPicture.setImage(null);;
                return;
            }
            int image = rand.nextInt(this.realImages.size());
            //System.out.println("\"../images/real/" + contents[image] + "\""); // gia na vlepoume to path
            this.curPicture.setImage(new Image("../images/real/" + this.realImages.get(image) + ""));
            this.fakeorreal = 1;
            this.realImages.remove(image);

        }
        
    }  

}
