package view;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.ApplicationModel;

/**
 * UI class for displaying the toolbar with the options.
 */
public class GameUI extends StackPane {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/

  private ApplicationModel model;
  private String game;

  public ArrayList<TeamUI> teams = new ArrayList<TeamUI>();
  
  private Label gameName;
  private Button addTeam;


  /***************************************************************************
   *                                                                         *
   * Constructor                                                            *
   *                                                                         *
   **************************************************************************/

	public GameUI(ApplicationModel model, String game){
		this.model = model;
		this.game = game;
		initializeControls();
		refreshControls();
	}

  /***************************************************************************
   *                                                                         *
   * Private methods                                                         *
   *                                                                         *
   **************************************************************************/

	private void initializeControls() {
		gameName = new Label(game);
		setId("game");
		addTeam = new Button("Add Team");
		addTeam.setOnAction(event -> {
			teams.add(new TeamUI(model));
			refreshControls();
		});
	}


	private void refreshControls() {
		getChildren().clear();
		VBox outer = new VBox();
		HBox top = new HBox();
		
		top.getChildren().addAll(gameName, addTeam);
		outer.getChildren().addAll(top);
		for(TeamUI team : teams) outer.getChildren().add(team);
		
		getChildren().addAll(outer);
	}

}

