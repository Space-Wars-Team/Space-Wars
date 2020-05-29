package SpaceWars.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller_leaderboard implements Initializable {

    @FXML
    private Button back_button;

    @FXML
    private Label user_id;
    @FXML
    private Label empty1;

    @FXML
    private Label empty2;

    @FXML
    private Label empty3;

    @FXML
    private Button load_button;


    File n_file = new File("src/images/File.txt");
    File w_file = new File("src/images/wins.txt");
    Scanner name_sc = new Scanner(n_file);
    Scanner win_sc = new Scanner(w_file);
    String username;
    int wins;

    public Controller_leaderboard() throws FileNotFoundException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    back();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        load_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                leaderboard();

            }
        });
    }
    private void back() throws IOException {
        back_button.getScene().getWindow().hide();
        Stage back_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/main_menu.fxml"));
        Scene main_scene = new Scene(main_root);
        back_menu.setScene(main_scene);
        back_menu.show();
    }
    private void leaderboard(){
        while (name_sc.hasNextLine()) {
            username = name_sc.nextLine();
        }
        while (win_sc.hasNextLine()){
            wins= Integer.valueOf(win_sc.nextLine());
        }
        user_id.setText(username+ " with " +wins +" wins!");
        empty1.setText("Empty");
        empty2.setText("Empty");
        empty3.setText("Empty");
    }
}
