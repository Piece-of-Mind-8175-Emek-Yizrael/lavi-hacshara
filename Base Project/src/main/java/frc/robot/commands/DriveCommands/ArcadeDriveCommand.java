package frc.robot.commands.DriveCommands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.DriveSubsystem;


public class ArcadeDriveCommand extends Command {
    DoubleSupplier speed;
    DoubleSupplier rotation;
    DriveSubsystem driveSubsystem;

    public ArcadeDriveCommand(DoubleSupplier speed, DoubleSupplier rotation, DriveSubsystem driveSubsystem){
        this.speed = speed;
        this.rotation = rotation;
        this.driveSubsystem = driveSubsystem;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute(){
        driveSubsystem.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    }

    @Override
    public void end(boolean isInterrupted){
        driveSubsystem.stopMotor();
    }


}
