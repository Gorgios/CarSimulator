
public interface Car {
	public void gearup();
	public void geardown();
	public void run ();
	public void breaking () ;
	public void power_on() throws InterruptedException;
	public void power_off() throws InterruptedException;
	public float getRpm();
	public float getSpeed();
	public boolean isPower();
	public int getGear();
	public void setGear(int gear);
	public void setPower(boolean power);
	public void setRpm(float rpm);
	public void setSpeed(float speed);
	public boolean isBreak();
	public void setBreak(boolean isBreak);
	public void engineBreak();
	public void check();
}
