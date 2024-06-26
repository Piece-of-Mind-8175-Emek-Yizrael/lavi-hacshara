package frc.robot.commands.IntakeConnads;

import java.util.function.DoubleSupplier;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.IntakeSubsystem;

public class IntakeCommand extends Command {
    IntakeSubsystem intake;
    DoubleSupplier speed;

    public IntakeCommand(DoubleSupplier speed, IntakeSubsystem intake){
        this.intake = intake;
        this.speed = speed;

        addRequirements(intake);
    }

    @Override
    public void initialize(){
        intake.setMotor(speed.getAsDouble());
    }

    @Override
    public void end(boolean isInterrupted){
        intake.stopMotor();
    }
}
