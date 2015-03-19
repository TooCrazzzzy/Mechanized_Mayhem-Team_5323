
package org.usfirst.frc.team5323.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Joystick leftJoy;
	Joystick rightJoy;
	DriverStation dStation;
	Victor pulley;
	Talon leftTalon;
	Talon rightTalon;
	RobotDrive rDrive;
	Timer clock;
	Timer atonClockTimer;
	Timer atonClockTimerSecond;
	Talon wormTalon;
	Counter count;
	DigitalInput ultrasonicDIO;
	double ultrasonic;
	public void robotInit() {
    	leftJoy = new Joystick(0);
    	pulley = new Victor(3);
    	leftTalon = new Talon(2);
    	rightTalon = new Talon(0);
    	rDrive = new RobotDrive(leftTalon, rightTalon);
    	ultrasonicDIO = new DigitalInput(1);
    	clock = new Timer();
    	atonClockTimer = new Timer();
    	atonClockTimerSecond = new Timer();
    	wormTalon = new Talon(4);
    	count = new Counter();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
 /*if(Ultrasonic.Inches>=4){
	atonClockTimer.start();
	while(atonClockTimer.get()<=2)
	wormTalon.set(0.75);
	//while(atonClockTimer.hasPeriodPassed(2))
	//pulley.set(.05);
	while(atonClockTimer.get()>=5&&atonClockTimer.get()<=8){
	wormTalon.set(0);
		leftTalon.set(.25);
		rightTalon.set(-.25);
		}
	atonClockTimer.stop();
	}
	if(Ultrasonic.Inches<4){
		atonClockTimerSecond.start();
		while(atonClockTimer.get()<=1)
			pulley.set(0.25);
		while(atonClockTimer.get()>=1&&atonClockTimer.get()<=5)
			pulley.set(-0.35);
		atonClockTimerSecond.stop();
			}
	*/
		}
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	rDrive.tankDrive(leftJoy,rightJoy, true);
    	
    	if(leftJoy.getRawButton(5) && leftJoy.getRawButton(1)){
    		pulley.set(0.75);
    	}
    	else{
    		pulley.set(0);
    	}
        if(leftJoy.getRawButton(1)){
        	pulley.set(1);
        }
        else if(leftJoy.getRawButton(2)){
        	pulley.set(-0.75);
        }
        else{
        	pulley.set(0.0);
        }
        if(leftJoy.getRawButton(3)){
        	wormTalon.set(0.25);
        }
        else if(leftJoy.getRawButton(4)){
        	wormTalon.set(-0.25);
        }
        else{
        	wormTalon.set(0.0);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
