package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ApplicationModel;

/**
 * The application UI is the base for all UI components, it structures them.
 */
public class ApplicationUI extends StackPane {

  /***************************************************************************
   *                                                                         *
   * Fields                                                                  *
   *                                                                         *
   **************************************************************************/
	
	private ToolbarUI toolbar;
	private StackPane leftUI;
	private RightUI rightUI;
	
	private ApplicationModel model;
	private Stage stage;

  /***************************************************************************
   *                                                                         *
   * Constructor                                                             *
   *                                                                         *
   **************************************************************************/

	public ApplicationUI(Stage stage) {
		this.stage = stage;
		initializeSelf();
		refreshViews(null);
	}

  /***************************************************************************
   *                                                                         *
   * Private methods                                                         *
   *                                                                         *
   **************************************************************************/

	private void initializeSelf() {
		String stylesheet = getClass().getResource("style.css").toExternalForm();
		getStylesheets().add(stylesheet);
		
		model = new ApplicationModel(this);
		
		toolbar = new ToolbarUI(model);
		rightUI = new RightUI(model);
	}
	
	public void refreshViews(Canvas canvas) {
		getChildren().clear();
		
		if(canvas != null) {
			rightUI.getChildren().clear();
			rightUI.getChildren().add(canvas);
		}
		
		switch(model.getMode()) {
		case None:
			leftUI = new NoneUI(model);
			break;
			
		case TournamentResult:
			leftUI = new TournamentResultUI(stage, model);
			break;
			
		case GameResult:
			break;
			
		case TeamPresentation:
			break;
		}
		
		VBox outer = new VBox();
		outer.getChildren().add(toolbar);
		
		HBox inner = new HBox();
		inner.getChildren().addAll(leftUI, rightUI);
		outer.getChildren().add(inner);
		getChildren().add(outer);
	}


}
