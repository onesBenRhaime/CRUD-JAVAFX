/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.PersonneService;

/**
 * FXML Controller class
 *
 * @author Skand
 */
public class AjouterPersonneController implements Initializable {

    @FXML
    private TextField nomTf;
    @FXML
    private TextField prenomTf;
    @FXML
    private TextField ageTf;
    @FXML
    private Label welcomeLb;

    PersonneService ps = new PersonneService();
    @FXML
    private DatePicker datepicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AfficherPersonnes(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherPersonnes.fxml"));
            Parent root = loader.load();
            welcomeLb.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    public void setUsername(String username) {
        welcomeLb.setText("Welcome " + username);
    }

    @FXML
    private void AjouterPersonne(ActionEvent event) {
         try {
            String nom = nomTf.getText();
            String prenom = prenomTf.getText();
            int age = Integer.parseInt(ageTf.getText());
            Personne p = new Personne(age, nom, prenom);
            ps.ajouter(p);
            
            
             //Date d = Date.valueOf(datepicker.getValue());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
