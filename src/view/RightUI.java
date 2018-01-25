package view;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.ApplicationModel;


public class RightUI extends StackPane {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/
	
	private ApplicationModel model;

  /***************************************************************************
   *                                                                         *
   * Constructor                                                             *
   *                                                                         *
   **************************************************************************/

	public RightUI(ApplicationModel model) {
		this.model = model;
		initializeSelf();
		layoutViews();
	}


  /***************************************************************************
   *                                                                         *
   * Private methods                                                         *
   *                                                                         *
   **************************************************************************/

	private void initializeSelf() {
		setId("right");
	}
	  
	private void layoutViews() {
		VBox vbox = new VBox();
		getChildren().add(vbox);
	}

}
