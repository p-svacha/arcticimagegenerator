package view;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import model.ApplicationModel;
import static model.ApplicationModel.*;

/**
 * UI class for displaying the toolbar with the options.
 */
public class ToolbarUI extends StackPane {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/

  private ApplicationModel model;

  private Button tournamentResultButton;


  /***************************************************************************
   *                                                                         *
   * Constructor                                                            *
   *                                                                         *
   **************************************************************************/

	public ToolbarUI(ApplicationModel model){
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
		setId("toolbar");
		tournamentResultButton = new Button("Tournament Result");
		tournamentResultButton.setOnAction(event -> {
			model.setMode(ImageMode.TournamentResult);
		});
	}


	private void layoutControls() {
		getChildren().add(tournamentResultButton);
	}

}

