package frc.robot.commands.DriveCommands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

public class ArcadeDriveCommand extends Command {
    DoubleSupplier speed;
    DoubleSupplier rotation;

    public ArcadeDriveCommand(DoubleSupplier speed, DoubleSupplier rotation){
        this.speed = speed;
        this.rotation = rotation;
    }
}
