package frc.robot.commands.ArmCommands;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.ArmSubsystem;

public class ArmCommand extends Command{
    ArmSubsystem arm;
    double speed;
    

    public ArmCommand(double speed, ArmSubsystem arm){
        this.arm = arm;
        this.speed = speed;

        addRequirements(arm);
    }

    @Override
    public void initialize(){
        if (speed != 0){
            if ((speed > 0 && !arm.getOpenSw()) || (speed < 0 || arm.getFoldSw()))
            arm.setMotor(speed);
        }else {
            arm.stopMotor();
        }
    }

    @Override
    public void end(boolean isInterrupted){
        arm.stopMotor();
    }

    @Override
    public boolean isFinished(){
        if ((speed > 0 && arm.getOpenSw()) || (speed < 0 && arm.getFoldSw()) || speed == 0)
            return true;
        
        return false;
    }
}
