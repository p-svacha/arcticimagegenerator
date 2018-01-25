package view;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.ApplicationModel;

/**
 * UI class for displaying the toolbar with the options.
 */
public class TeamUI extends HBox {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/

  private ApplicationModel model;

  private TextField name;
  private TextField players;
  private TextField rank;


  /***************************************************************************
   *                                                                         *
   * Constructor                                                            *
   *                                                                         *
   **************************************************************************/

	public TeamUI(ApplicationModel model){
		this.model = model;
		initializeControls();
		layoutControls();
	}

  /***************************************************************************
   *                                                                         *
   * Private methods                                                         *
   *                                                                         *
   **************************************************************************/

	private void initializeControls() {
		name = new TextField("Name");
		players = new TextField("Players");
		players.setPrefWidth(400);
		rank = new TextField("Rank");
		rank.setPrefWidth(50);
	}


	private void layoutControls() {
		getChildren().addAll(name, players, rank);
	}

}

