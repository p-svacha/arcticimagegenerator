package view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import model.ApplicationModel;

/**
 * UI class for displaying the toolbar with the options.
 */
public class NoneUI extends StackPane {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/

  private ApplicationModel model;

  private Label choseLabel;


  /***************************************************************************
   *                                                                         *
   * Constructor                                                            *
   *                                                                         *
   **************************************************************************/

	public NoneUI(ApplicationModel model){
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
		choseLabel = new Label("Please chose the type of image you want to generate");
	}


	private void layoutControls() {
		getChildren().add(choseLabel);
	}

}

