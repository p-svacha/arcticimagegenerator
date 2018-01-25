package model;

import javafx.scene.canvas.Canvas;
import view.ApplicationUI;

public class ApplicationModel {
	
	private Canvas canvas;
	
	public String[] games = {
			"CS:GO"
	};
	public enum ImageMode {
		None,
		TournamentResult,
		GameResult,
		TeamPresentation
	}
	
	private ApplicationUI ui;
	private ImageMode mode = ImageMode.None;
	
	public ApplicationModel(ApplicationUI ui) {
		this.ui = ui;
	}
	
	public void refresh() {
		ui.refreshViews(canvas);
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	public ImageMode getMode() {
		return mode;
	}
	public void setMode(ImageMode mode) {
		this.mode = mode;
		refresh();
	}

}
