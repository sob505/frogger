import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

import java.util.Random;

public class Background {
    private final Rectangle[] background;
    private BackgroundPiece[][] backgroundPieces;
    private final Rectangle[] lilypads;
    private final Image lilypad = new Image("/image/lilypad.png");
    private final Random rand = new Random();
    private final int[] pieces = new int[]{5, 4, 4, 3, 3, 5, 0, 2, 3, 3, 3, 3, 0};
    // Set up the background of the game
    public Background(Pane pane) {
        this.background = new Rectangle[13];
        this.backgroundPieces = new BackgroundPiece[this.background.length][5];
        this.lilypads = new Rectangle[5];

        // Create the background stripes
        for(int i = 0; i < this.background.length; i++) {
            this.background[i] = new Rectangle(800,50);
            this.background[i].setX(0);
            this.background[i].setY(i*50 + 25);
            if(i > 0 && i <= 5) { this.background[i].setFill(Paint.valueOf("Blue")); }
            else if(i > 6 && i <= 11) { this.background[i].setFill(Paint.valueOf("Black")); }
            else { this.background[i].setFill(Paint.valueOf("Green")); }

            pane.getChildren().add(this.background[i]);
            setupPieces(i,pane);
        }
    }

    // Create the background pieces and initialize their speed
    private void setupPieces(int index, Pane pane) {
        double rowSpeed = rand.nextInt(4) + 2;
        for(int i = 0; i < this.pieces[index]; i++) {
            if(index == 0) {
                this.backgroundPieces[index][i] = makeLilyPad(index, i);
            } else {
                this.backgroundPieces[index][i] = new BackgroundPieceFactory().createPiece(index, i, rowSpeed);
            }
            // Set the backgroundPiece in the corresponding stripe
            this.backgroundPieces[index][i].setY(this.background[index].getY()+5);
            pane.getChildren().add(this.backgroundPieces[index][i].getShape());
        }
    }
    private BackgroundPiece makeLilyPad(int index, int i) {
        BackgroundPiece lilypad = new BackgroundPiece(index, 0, 50, this.lilypad, "Lilypad") {
            @Override
            public void move() { return; }
        };
        lilypad.setX(i * 185 + 5);
        lilypad.getShape().setRotate(180);
        return lilypad;
    }
    // Move the background pieces
    public void move() {
        for(int i = 0; i < this.backgroundPieces.length; i++) {
            for(int j = 0; j < this.backgroundPieces[i].length; j++) {
                // If no piece exists, skip the index set
                if(this.backgroundPieces[i][j] == null) { break; }
                else {
                    this.backgroundPieces[i][j].move();
                }
            }
        }
    }
    public Rectangle[] getBackground() { return this.background; }
    public BackgroundPiece[][] getBackgroundPieces() { return this.backgroundPieces; }
}
