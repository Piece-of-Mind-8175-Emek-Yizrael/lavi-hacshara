package frc.robot.commands.ArmCommands;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.ArmSubsystem;

public class ArmCommand extends Command{
    ArmSubsystem arm;
    DoubleSupplier speed;

    public ArmCommand(DoubleSupplier speed, ArmSubsystem arm){
        this.arm = arm;
        this.speed = speed;

        addRequirements(arm);
    }

    @Override
    public void initialize(){
        if (speed.getAsDouble() != 0){
            arm.setMotor(speed.getAsDouble());
        }else {
            arm.stopMotor();
        }
    }

    @Override
    public void end(boolean isInterrupted){
        arm.stopMotor();
    }
}
