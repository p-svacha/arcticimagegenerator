package view;

import generator.TournamentResultGenerator;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

import model.ApplicationModel;

/**
 * UI class for displaying the toolbar with the options.
 */
public class TournamentResultUI extends StackPane {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/

	private Stage stage;
	private ApplicationModel model;

	private ObservableList<String> gamesList;
	private ComboBox<String> gameChoser;
	private Button addGame;
	private Button generate;
	
	private ArrayList<GameUI> games = new ArrayList<GameUI>();
	TournamentResultGenerator gen;


  /***************************************************************************
   *                                                                         *
   * Constructor                                                            *
   *                                                                         *
   **************************************************************************/

	public TournamentResultUI(Stage stage, ApplicationModel model){
		this.stage = stage;
		this.model = model;
		initializeControls();
		refreshControls();
	}

  /***************************************************************************
   *                                                                         *
   * Private methods                                                         *
   *                                                                         *
   **************************************************************************/

	private void initializeControls() {
		gen = new TournamentResultGenerator();
		gamesList = FXCollections.observableArrayList(model.games);
		gameChoser = new ComboBox<String>(gamesList);
		gameChoser.setPromptText("Game");
		addGame = new Button("Add Game");
		addGame.setOnAction(event -> {
			if(!gameChoser.getSelectionModel().isEmpty()) {
				games.add(new GameUI(model, gameChoser.getSelectionModel().getSelectedItem()));
			}
			refreshControls();
		});
		generate = new Button("Generate");
		generate.setOnAction(event -> {
			
			
			
			FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = 
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);
           
            //Show save file dialog
            File file = fileChooser.showSaveDialog(stage);
             
            if(file != null){
                try {
                    WritableImage writableImage = new WritableImage(gen.width, gen.height);
                    gen.canvas.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException ex) {
                }
            }
		});
	}


	private void refreshControls() {
		getChildren().clear();
		VBox outer = new VBox();
		
		HBox top = new HBox();
		top.getChildren().addAll(gameChoser, addGame);
		
		outer.getChildren().add(top);
		for(GameUI game : games) outer.getChildren().add(game);
		outer.getChildren().add(generate);
		
		getChildren().addAll(outer);
	}

}

