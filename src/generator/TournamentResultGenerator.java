package generator;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import view.GameUI;

public class TournamentResultGenerator {
	
	public int width = 1920;
	public int height = 1080; 
	
	private String title;
	private String location;
	private String date;
	private ArrayList<GameUI> games = new ArrayList<GameUI>();
	public Canvas pictureCanvas;
	public Canvas previewCanvas;
	
	public TournamentResultGenerator() {
	}
	
	public void generate(double scale) {
		pictureCanvas = new Canvas(width, height);
		GraphicsContext context = pictureCanvas.getGraphicsContext2D();
		Image bg = new Image("bg.png");
		context.drawImage(bg, 0, 0);
		context.setFill(Color.RED);
		context.fillRect(0, 0, width, height);
	}
	
	public Canvas getPictureCanvas() {
		generate(1);
		return pictureCanvas;
	}
	
	public Canvas getPreviewCanvas() {
		generate(0.25);
		return previewCanvas;
	}
	
	public void update(String title, String location, String date, ArrayList<GameUI> games) {
		this.title = title;
		this.location = location;
		this.date = date;
		this.games = games;
	}
	
}
