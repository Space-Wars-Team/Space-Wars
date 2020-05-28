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
    private Label error_label;

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
                        comp();
                    }
                }
        });
    }

    private void comp() {
        while (scanner.hasNextLine()) {
            username = scanner.nextLine();
            if (search_username.getText().equals(username)) {
                error_label.setText("User exists!");
                compare = true;
            } else {
                error_label.setText("User does not exist");
                compare = false;
            }
        }
    }
}



