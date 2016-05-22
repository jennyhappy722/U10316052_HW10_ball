import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.control.*;

public class BallPane extends Pane {
  public  double radius = 20;
  public double x = 20, y = 20;
  public double dx = 1, dy = 1;

  public  Circle circle;
  Timeline animation;


  public BallPane() {
	Button button=new Button("Follow  Ball  Locus");
			button.setOnAction(e ->{ 
			addcircle();
			//animatee();				
	});
	
	circle = new Circle(x, y, radius);
	button.relocate(50,0);
    circle.setFill(Color.GREEN);	// Set ball color	
    getChildren().addAll(button,circle); // Place a ball into this pane


    // Create an animation for moving the ball
    animation = new Timeline(
      new KeyFrame(Duration.millis(50), e ->{
	   moveBall();
	   }));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }
  public void play() {
    animation.play();
  }
  public void animatee(){
	
	animation = new Timeline(
    new KeyFrame(Duration.millis(50), e ->{
	moveBall();
	}));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation	    
  } 
  public Circle addcircle() {
	  circle = new Circle(x, y, radius);
	  getChildren().add(circle);
		return circle;
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  public void moveBall() {
	// Check boundaries
	
    if (x < 20 || x > getWidth() - 20) {
      dx *= -1; // Change ball move direction
    }
    if (y < 20 || y > getHeight() - 20) {
      dy *= -1; // Change ball move direction
    }
    // Adjust ball position
    x += dx;
    y += dy;
	
    circle.setCenterX(x);
    circle.setCenterY(y);
  }
}
