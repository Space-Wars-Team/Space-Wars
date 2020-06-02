package SpaceWars.controllers.Profile;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller_delete_profile implements Initializable {

    String username;

    @FXML
    private Button button;

    @FXML
    private Label label_msg;

    @FXML
    private Button main_button;

    @FXML
    private TextField textfield;

    File file = new File("src/images/File.txt");

    Scanner scanner = new Scanner(file);

    public Controller_delete_profile() throws FileNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    comp();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        main_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    main_menu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void main_menu() throws IOException {
        main_button.getScene().getWindow().hide();
        Stage main = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/main_menu.fxml"));
        Scene main_scene = new Scene(main_root);
        main.setScene(main_scene);
        main.show();
    }


    private void delete_file() {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void comp() throws IOException {
        while (scanner.hasNextLine()) {
            username = scanner.nextLine();
        }
        if(textfield.getText().equals(username)){
            delete_file();
            label_msg.setText("Username deleted!");
        }else {
            reload();
            error_msg();
        }
    }
    private void reload() throws IOException {
        button.getScene().getWindow().hide();
        Stage back_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/delete_profile.fxml"));
        Scene main_scene = new Scene(main_root);
        back_menu.setScene(main_scene);
        back_menu.show();
    }
    private void error_msg() throws IOException {
        button.getScene().getWindow().hide();
        Stage back_menu = new Stage();
        Parent main_root = FXMLLoader.load(getClass().getResource("/SpaceWars/GUIs/Profile/error_message.fxml"));
        Scene main_scene = new Scene(main_root);
        back_menu.setScene(main_scene);
        back_menu.show();
    }
}


