package Controller;

/*-
 * #%L
 * Malom
 * %%
 * Copyright (C) 2018 GNU GENERAL PUBLIC LICENSE
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controls main window.
 */
public class MainController implements Initializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class.getName());

    @FXML
    private AnchorPane szar;
    @FXML
    private Button newGameButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * If new game Button pressed it switches to Game window.
     * @param e
     */
    @FXML
    private void toGameAction(ActionEvent e)
    {
        Stage stage=(Stage) ((Node)(e.getSource())).getScene().getWindow();
        try{
            FXMLLoader fxmlLoader= new  FXMLLoader(getClass().getResource("/fxml/Game.fxml"));
            Parent root=(Parent)fxmlLoader.load();


            Scene sc=new Scene(root);
            GameController controller = fxmlLoader.<GameController>getController();
            controller.createInitialGame();
            stage.setScene(sc);
            stage.show();
        }catch (IOException err)
        {
            LOGGER.error(err.toString());
        }
    }
    @FXML
    private void quitAction(ActionEvent e)
    {
        System.exit(0);
    }
}
