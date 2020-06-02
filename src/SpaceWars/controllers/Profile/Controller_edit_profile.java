package SpaceWars.controllers.Profile;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller_edit_profile implements Initializable {

    String username;

    boolean compare;

    @FXML
    private TextField search_username;

    @FXML
    private Button search_button;

    @FXML
    private Button back_button;

    File file = new File("src/images/File.txt");

    Scanner scanner = new Scanner(file);

    public Controller_edit_profile() throws FileNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        search_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    comp();
                    if (compare == true) {
                        search_button.getScene().getWindow().hide();
                        Stage create_menu = new Stage();
                        Parent create_root = null;
                        try {
                            create_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/create_profile.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene create_scene = new Scene(create_root);
                        create_menu.setScene(create_scene);
                        create_menu.show();
                    }else {
                        try {
                            notFound();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            error_msg();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        });
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
    }

    private void comp() {
        while (scanner.hasNextLine()) {
            username = scanner.nextLine();
            if (search_username.getText().equals(username)) {

                compare = true;
            } else {

                compare = false;
            }
        }
    }
    private void notFound() throws IOException {
        search_button.getScene().getWindow().hide();
        Stage back_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/edit_profile.fxml"));
        Scene main_scene = new Scene(main_root);
        back_menu.setScene(main_scene);
        back_menu.show();
    }
    private void error_msg() throws IOException {
        search_button.getScene().getWindow().hide();
        Stage back_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/error_message.fxml"));
        Scene main_scene = new Scene(main_root);
        back_menu.setScene(main_scene);
        back_menu.show();
    }
    private void back() throws IOException {
        back_button.getScene().getWindow().hide();
        Stage back_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/profile_menu.fxml"));
        Scene main_scene = new Scene(main_root);
        back_menu.setScene(main_scene);
        back_menu.show();
    }
}



