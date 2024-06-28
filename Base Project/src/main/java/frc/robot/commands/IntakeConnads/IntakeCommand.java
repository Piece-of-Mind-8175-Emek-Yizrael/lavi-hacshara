package frc.robot.commands.IntakeConnads;

import java.util.function.DoubleSupplier;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.IntakeSubsystem;

public class IntakeCommand extends Command {
    IntakeSubsystem intake;
    double speed;

    public IntakeCommand(double speed, IntakeSubsystem intake){
        this.intake = intake;
        this.speed = speed;

        addRequirements(intake);
    }

    @Override
    public void execute(){
        intake.setMotor(speed);
    }

    @Override
    public void end(boolean isInterrupted){
        intake.stopMotor();
    }
}
