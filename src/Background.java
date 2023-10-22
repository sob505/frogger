import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Background {
    private final Rectangle[] background;
    private final BackgroundPiece[][] backgroundPieces;
    private final double[] speed;
    public Background(Pane pane) {
        this.background = new Rectangle[13];
        this.backgroundPieces = new BackgroundPiece[this.background.length][4];
        this.speed = new double[this.background.length];

        // Create the background stripes
        for(int i = 0; i < this.background.length; i++) {
            this.background[i] = new Rectangle(700,50);
            this.background[i].setX(50);
            this.background[i].setY(i*50 + 25);
            if(i > 0 && i <= 5) { this.background[i].setFill(Paint.valueOf("Blue")); }
            else if(i > 6 && i <= 11) { this.background[i].setFill(Paint.valueOf("Black")); }
            else { this.background[i].setFill(Paint.valueOf("Green")); }

            Random rand = new Random();
            if(i % 2 == 0) {
                this.speed[i] = rand.nextInt(4) + 2;
            } else {
                this.speed[i] = -1 * (rand.nextInt(4) + 2);
            }

            pane.getChildren().add(this.background[i]);
            setupPieces(i,pane);
        }
    }

    // Create the background pieces and initialize their speed
    private void setupPieces(int index, Pane pane) {
        if(index == 0 || index == 6 || index == this.background.length - 1) { return; }
        for(int i = 0; i < this.backgroundPieces[i].length; i++) {
            this.backgroundPieces[index][i] = new BackgroundPieceFactory().createPiece(index);
            //this.backgroundPieces[index][i] = new Rectangle();
            //this.backgroundPieces[index][i].setFill(Paint.valueOf("White"));

            // Keep a standard height of 40 and standard width depending on which row it is in
            //this.backgroundPieces[index][i].setHeight(40);
//            if(index < 6) {
//               // this.backgroundPieces[index][i] = new Log();
//                //this.backgroundPieces[index][i].setWidth(Math.random() * 100 + 50);
//            } else {
//                this.backgroundPieces[index][i].setWidth(50);
//            }

            // Randomize the x-coordinate of the backgroundPiece
            this.backgroundPieces[index][i].setX(Math.random() * 500 + 50);
//            // If the backgroundPiece is too close to the one before it, move it over
//            if(i > 0 && Math.abs(this.backgroundPieces[index][i-1].getX() + this.backgroundPieces[index][i-1].getWidth() - this.backgroundPieces[index][i].getX()) < 50) {
//                this.backgroundPieces[index][i].setX(this.backgroundPieces[index][i].getX() + 100);
//            }
            // Set the backgroundPiece in the corresponding stripe
            this.backgroundPieces[index][i].setY(this.background[index].getY()+5);
            pane.getChildren().add(this.backgroundPieces[index][i].getShape());
        }
    }
    // Move the background pieces
    public void move() {
        for(int i = 0; i < this.backgroundPieces.length; i++) {
            for(int j = 0; j < this.backgroundPieces[i].length; j++) {
                // If no piece exists, skip the index set
                if(this.backgroundPieces[i][j] == null) { break; }
                // Once the piece has reached the far side of the board, reset it at the opposite end
                if(this.speed[i] < 0 && this.backgroundPieces[i][j].getX() + this.backgroundPieces[i][j].getWidth() < -10) {
                   this.backgroundPieces[i][j].setX(750);
                } else if (this.speed[i] > 0 && this.backgroundPieces[i][j].getX() > 825) {
                    this.backgroundPieces[i][j].setX(0);
                } else { // Otherwise keep moving it at the row's speed
                    this.backgroundPieces[i][j].setX(this.backgroundPieces[i][j].getX() + this.speed[i]);
                }
            }
        }
    }
    public Rectangle[] getBackground() { return this.background; }
}
