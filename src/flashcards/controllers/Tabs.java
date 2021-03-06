package flashcards.controllers;

import flashcards.model.Deck;
import flashcards.model.GameUsers;
import flashcards.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class Tabs {

    BorderPane root;
    @FXML AnchorPane tabs;

    public Tabs(BorderPane root){

        this.root = root;
    }

    /**
     * Réaction au clic sur un bouton permettant d'afficher l'onglet de présentations des paquets
     * @throws Exception
     */
    public void BTN_DECKS_ON_ACTION() throws Exception{
        System.out.println("decks");

        Packets p = new Packets(this.root);
        FXMLLoader paquets_onglet = new FXMLLoader();
        URL paquet_url = getClass().getClassLoader().getResource("Packets.fxml");
        paquets_onglet.setLocation(paquet_url);
        paquets_onglet.setControllerFactory(iC -> p);
        this.root.setCenter(paquets_onglet.load());

    }

    /**
     * Réaction au clic sur un bouton permettant d'afficher l'onglet d'ajout d'une nouvelle cartes
     * @throws Exception
     */
    public void BTN_ADD_ON_ACTION() throws Exception{
        System.out.println("Add card");

        URL path;
        path = getClass().getClassLoader().getResource("AddCard.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(path);
        loader.setControllerFactory(iC -> new AddCard());
        //Parent decks = FXMLLoader.load(path);
        root.setCenter(loader.load());
    }
    /**
     * Réaction au clic sur un bouton permettant d'afficher l'onglet de la recherche de cartes
     * @throws Exception
     */
    public void BTN_BROWSE_ON_ACTION() throws Exception{
        System.out.println("Browse decks");

        URL path = getClass().getClassLoader().getResource("PacketSearch.fxml");
        FXMLLoader deck = new FXMLLoader();
        deck.setLocation(path);
        deck.setControllerFactory(iC -> new PacketSearch(this.root));
        //Parent decks = FXMLLoader.load(path);
        root.setCenter(deck.load());
    }

    /**
     * Réaction au clic sur un bouton permettant d'afficher l'onglet de présentation des statistiques
     */
    public void BTN_STATS_ON_ACTION() throws Exception{
        System.out.println("Stats");

        URL path;
        path = getClass().getClassLoader().getResource("UserStats.fxml");
        Parent decks = FXMLLoader.load(path);
        root.setCenter(decks);
    }
    /**
     * Réaction au clic sur un bouton permettant d'afficher l'onglet de création de pacquets
     * @throws Exception
     */
    public void BTN_CREATE_DECK_ON_ACTION() throws Exception{
        System.out.println("Create deck");

        URL path;
        path = getClass().getClassLoader().getResource("DeckCreate.fxml");
        Parent decks = FXMLLoader.load(path);
        root.setCenter(decks);
    }

    public void mi_close_on_action(){
        Stage stage = (Stage) tabs.getScene().getWindow();
        stage.close();
    }

    public void mi_help_on_action() throws Exception{
        Stage stage = new Stage();

        HelpPopup h = new HelpPopup();
        FXMLLoader loader = new FXMLLoader();
        URL help = getClass().getClassLoader().getResource("HelpPopup.fxml");
        loader.setLocation(help);
        loader.setControllerFactory(iC -> h);

        stage.setTitle("Guide d'utilisation");
        stage.setResizable(false);
        stage.setScene(new Scene(loader.load(), 600, 400));
        stage.show();
    }

}
