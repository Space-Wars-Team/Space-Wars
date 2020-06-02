package SpaceWars.controllers;

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

public class Controller_profile_menu implements Initializable {
    @FXML
    private Button create_button;

    @FXML
    private Button edit_button;

    @FXML
    private Button delete_button;

    @FXML
    private Button back_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    create();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("going back");
                try {
                    back();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        edit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    edit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        delete_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    delete_profile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void create() throws IOException {
        create_button.getScene().getWindow().hide();
        Stage create_name = new Stage();
        Parent create_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/create_profile.fxml"));
        Scene create_scene = new Scene(create_root);
        create_name.setScene(create_scene);
        create_name.show();
    }
    private void back() throws IOException {
        back_button.getScene().getWindow().hide();
        Stage main_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/main_menu.fxml"));
        Scene main_scene = new Scene(main_root);
        main_menu.setScene(main_scene);
        main_menu.show();
    }
    private void edit () throws IOException {
        edit_button.getScene().getWindow().hide();
        Stage edit_menu = new Stage();
        Parent edit_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/edit_profile.fxml"));
        Scene edit_scene = new Scene(edit_root);
        edit_menu.setScene(edit_scene);
        edit_menu.show();

    }
    private void delete_profile() throws IOException {
        delete_button.getScene().getWindow().hide();
        Stage delete_menu = new Stage();
        Parent delete_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/delete_profile.fxml"));
        Scene delete_scene = new Scene(delete_root);
        delete_menu.setScene(delete_scene);
        delete_menu.show();
    }
}
