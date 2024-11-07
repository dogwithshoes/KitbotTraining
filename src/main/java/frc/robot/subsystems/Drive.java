package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.StrictFollower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.Power;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
    private TalonFX motorFR;
    private TalonFX motorFL;
    private TalonFX motorBR;
    private TalonFX motorBL;

    private DutyCycleOut powerRequest = new DutyCycleOut(0);
  
  public Drive() {
    motorFR = new TalonFX(Constants.DriveConstants.frontRightID);
    motorFL = new TalonFX(Constants.DriveConstants.frontLeftID);
    motorBR = new TalonFX(Constants.DriveConstants.backRightID);
    motorBL = new TalonFX(Constants.DriveConstants.backLeftID);

    motorBR.setControl(new Follower(motorFR.getDeviceID(), false));
    motorBL.setControl(new Follower(motorFL.getDeviceID(), false));
    
    motorBR.setControl(new StrictFollower(motorFR.getDeviceID()));
    motorBL.setControl(new StrictFollower(motorFL.getDeviceID()));
  }

  public void setPower(double powerLeft, double powerRight){
    motorFR.setControl(powerRequest.withOutput(powerRight));
    motorFL.setControl(powerRequest.withOutput(powerLeft));
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
