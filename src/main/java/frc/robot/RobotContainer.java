package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final CommandXboxController driver = new CommandXboxController(0);
  

  private final Drive m_drive = new Drive();
  private int rotationAxis = XboxController.Axis.kLeftX.value;
  private int forwardAxis = XboxController.Axis.kRightY.value;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  

    m_drive.setDefaultCommand(
      new DriveCommand(
        m_drive, 
        (int) -driver.getRawAxis(rotationAxis),
        (double) -driver.getRawAxis(forwardAxis)
        ));
   }

   
 
  private void configureBindings() {
    
  }

}
