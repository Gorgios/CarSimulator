import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class ControllerMain  {
	Car car = new SportCar();
	boolean helpKey = false;
	@FXML
	private Label speedLabel;
	@FXML
	private Label gearLabel;
	@FXML
	private Label rpmLabel;
	@FXML
	private Label powerLabel;
	@FXML
	private Label GearUpLabel;
	@FXML
	private Label HelpLabel;
	private boolean isKey = false;
	public void setHelp() {
		if (helpKey == false) {
			helpKey = true;
			HelpLabel.setText("ENTER=ON/OFF W=ACCLERATION S=BREAK R=GEAR UP E=GEAR DOWN");
		}
		else {
			helpKey = false;
			HelpLabel.setText("");
		}
	}
	public void set_colors() {
		if (car.getRpm() < 2000) {
			rpmLabel.setTextFill(Color.web("#acb3ff"));
			GearUpLabel.setText("");
		}
		else if (car.getRpm() >= 2000 && car.getRpm() < 6000) 
			rpmLabel.setTextFill(Color.web("#acb3ff"));
		else  {
			rpmLabel.setTextFill(Color.web("#b85151"));
			GearUpLabel.setText("GEAR UP");
		}
		if (car.getSpeed() < 50)
			speedLabel.setTextFill(Color.web("#acb3ff"));
		else if (car.getSpeed()  >= 50 && car.getSpeed()  < 180)
			speedLabel.setTextFill(Color.web("#acb3ff"));
		else 
			speedLabel.setTextFill(Color.web("#b85151"));
	}
	public void gear_up() {
		car.gearup();
		rpmLabel.setText(Integer.toString((int)car.getRpm()));	
		gearLabel.setText(Integer.toString(car.getGear()));
		GearUpLabel.setText("");
		}
	public void gear_down() {
		car.geardown();
		rpmLabel.setText(Integer.toString((int)car.getRpm()));	
		gearLabel.setText(Integer.toString(car.getGear()));
		GearUpLabel.setText("");
		}

	public void run () {
		set_colors();
		car.run();
		rpmLabel.setText(Integer.toString((int)car.getRpm()));	
		speedLabel.setText(Integer.toString((int)car.getSpeed()));
	}
	public void breaking () {
		set_colors();
		car.breaking();
		speedLabel.setText(Integer.toString((int)car.getSpeed()));
		rpmLabel.setText(Integer.toString((int)car.getRpm()));	
	}

	Timeline timeline = new Timeline(
			new KeyFrame(
					Duration.millis(80),
					even -> {
					if (isKey ==false) {
					car.engineBreak();
					set_colors();
					speedLabel.setText(Integer.toString((int)car.getSpeed()));
					rpmLabel.setText(Integer.toString((int)car.getRpm()));	
					}
					}
				)
	);
public void power_on() throws InterruptedException   {
		car.power_on();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		rpmLabel.setText(Integer.toString((int)car.getRpm()));
		gearLabel.setText(Integer.toString(car.getGear()));
		speedLabel.setText(Integer.toString((int)car.getSpeed()));
		powerLabel.setText("ON");
		powerLabel.setTextFill(Color.web("#75cc6a"));
	}

public void power_off() throws InterruptedException {
	car.power_off();
	timeline.stop();
	rpmLabel.setText("");
	gearLabel.setText("");
	speedLabel.setText("");
	powerLabel.setText("OFF");
	powerLabel.setTextFill(Color.web("#2655e0"));
	GearUpLabel.setText("");
	}
public void stay() {
}

@FXML
private void keyPressed(KeyEvent keyEvent)  throws InterruptedException{
    if (keyEvent.getCode() == KeyCode.W) {
        run();
        isKey=true;
    }
    else if (keyEvent.getCode() == KeyCode.S) {
        breaking();
    }
    else if (keyEvent.getCode() == KeyCode.R) {
        gear_up();
    }
    else if (keyEvent.getCode() == KeyCode.E) {
        gear_down();

    }
    else if (keyEvent.getCode() == KeyCode.ENTER) {
    	if (car.isPower()==false)
    		power_on();
    	else
    		power_off();
        
    }
    else if (keyEvent.getCode() == KeyCode.J) {
        setHelp();
    }
}
@FXML
private void keyRelased(KeyEvent keyEvent)  throws InterruptedException{
	 if (keyEvent.getCode() == KeyCode.W) 
	    	isKey=false;
}
}
