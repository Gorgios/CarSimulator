

public class SportCar implements Car {
	private float speed = 0;
	private float rpm = 0;
	private int gear = 0;
	private boolean power = false;
	private boolean isBreak = false;
	
	public void check() {
		if (rpm <635)
			rpm = 635;
		if (speed <0)
			speed = 0;
	}
	public void engineBreak() {
		check();
		if (rpm > 3000) {
			rpm-=20;
			speed-=0.25; }
		else {
			rpm-=10;
			speed-=0.15;}
	}
	public boolean isBreak() {
		return isBreak;
	}

	public void setBreak(boolean isBreak) {
		this.isBreak = isBreak;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getRpm() {
		return rpm;
	}

	public void setRpm(float rpm) {
		this.rpm = rpm;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public boolean isPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}
	@Override
	public void gearup() {
		if (power == true) {
			if (gear < 6) {
				if (gear != 0 && rpm > 646 )
					rpm*=0.6;
				gear++;
			}
		}
	}
	@Override
	public void geardown() {
		if (power == true) {
			if (gear > 0) {
				gear--;
				if (speed > 10)
					rpm*=1.4;
				if (rpm > 8111)
					rpm = 8111;
			}
			}
		}

		

	@Override
	public void run() {
		if (gear > 0) {
		if (rpm < 2000) {
			rpm+=45;
			speed+=0.6;
		}
		if (rpm >= 2000 && rpm < 4000){
			rpm+=35;
			speed+=0.4;
		}
		if (rpm >= 4000 && rpm < 6000) {
			rpm+=20;
			speed+=0.3;
		}
	    if (rpm >= 6000  && rpm < 8111) {
			rpm+=10;
			speed+=0.2;
		}
	    if (rpm >= 8111)
	    	rpm=8111;
		}
	}

	@Override
	public void breaking() {
		if (isPower() == true) 
			speed-=1;
			rpm*=0.98;
		check();
	}


	@Override
	public void power_on() throws InterruptedException {
		power = true;
	}

	@Override
	public void power_off() throws InterruptedException {
		power = false;
		rpm = 0;
		speed=0;
		gear = 0;

	}


}
