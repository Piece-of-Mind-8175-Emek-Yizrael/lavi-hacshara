package frc.robot.commandGroup;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystem.ArmSubsystem;
import frc.robot.Subsystem.IntakeSubsystem;
import frc.robot.commands.ArmCommands.ArmCommand;
import frc.robot.commands.IntakeConnads.IntakeCommand;

public class OpenWithIntakeCommandGrpup extends SequentialCommandGroup{
    double armSpeed;
    double intakeSpeed;
    ArmSubsystem arm;
    IntakeSubsystem intake;

    public OpenWithIntakeCommandGrpup(double armSpeed, double intakeSpeed, ArmSubsystem arm, IntakeSubsystem intake){
        this.armSpeed = armSpeed;
        this.intakeSpeed = intakeSpeed;

        this.arm = arm;
        this.intake = intake;

        addRequirements(arm);
        addRequirements(intake);

        addCommands(
            new ArmCommand(armSpeed, arm),
            new IntakeCommand(intakeSpeed, intake)
        );
    }

    



}
