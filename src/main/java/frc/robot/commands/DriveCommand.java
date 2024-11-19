package frc.robot.commands;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;


public class DriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final frc.robot.subsystems.Drive drive;
  private double rotate;
  private double power;

  public DriveCommand(Drive drive, double rotate, double power) {
    this.drive = drive;
    this.rotate = rotate;
    this.power = power;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println("HELLO");
    
    // Shuffleboard.getTab("Power")
    //   .add("Power", power);
    // Shuffleboard.getTab("Rotation")
    //   .add("Rotation", rotate);

    System.out.println(power);
    System.out.println(rotate);

    // if(Math.abs(rotate) < 0.1){
    //   rotate = 0;
    // }
    // rotate*=0.8;
    // double leftSpeed = power + rotate;
    // double rightSpeed = power - rotate;
    // drive.setPower(leftSpeed, rightSpeed);
    drive.setPower(rotate, power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
