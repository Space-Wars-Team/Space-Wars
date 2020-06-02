package SpaceWars.controllers;

import SpaceWars.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_menu implements Initializable {
    @FXML
    public Button playbutton;
    @FXML
    private Button profilebutton;

    @FXML
    private Button leaderboardbutton;

    @FXML
    private Button subbutton;

    @FXML
    private Button qbutton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Play");
                try {
                    playbutton.getScene().getWindow().hide();
                    Game obj = new Game();
                    obj.start(Game.passStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        profilebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Profile");
                try {
                    profile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        leaderboardbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Leaderboard");
                try {
                    leaderboard();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        subbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Subscription");
                try {
                    subscription();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        qbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Quit Game");
                quit();
            }

        });
    }
    private void profile() throws IOException {
        profilebutton.getScene().getWindow().hide();
        Stage profile_menu = new Stage();
        Parent profile_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/profile_menu.fxml"));
        Scene profile_scene = new Scene(profile_root);
        profile_menu.setScene(profile_scene);
        profile_menu.show();
    }
    private void subscription() throws IOException {
        subbutton.getScene().getWindow().hide();
        Stage sub_stage = new Stage();
        Parent sub_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/subscription_menu.fxml"));
        Scene sub_scene = new Scene(sub_root);
        sub_stage.setScene(sub_scene);
        sub_stage.show();
    }
    private void quit(){
        qbutton.getScene().getWindow().hide();
    }

    private void leaderboard() throws IOException {
        leaderboardbutton.getScene().getWindow().hide();
        Stage leaderboard_menu = new Stage();
        Parent leaderboard_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/leaderboard.fxml"));
        Scene leaderboard_scene = new Scene(leaderboard_root);
        leaderboard_menu.setScene(leaderboard_scene);
        leaderboard_menu.show();
    }
}

