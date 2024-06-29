package frc.robot.commandGroup;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystem.ArmSubsystem;
import frc.robot.Subsystem.IntakeSubsystem;
import frc.robot.commands.ArmCommands.ArmCommand;
import frc.robot.commands.IntakeConnads.IntakeCommand;

public class CloseCommandGroup extends ParallelCommandGroup{
    ArmSubsystem arm;
    IntakeSubsystem intake;

    public CloseCommandGroup(ArmSubsystem arm, IntakeSubsystem intake){
        this.arm = arm;
        this.intake = intake;

        addRequirements(arm);
        addRequirements(intake);

        addCommands(
            new IntakeCommand(0, intake),
            new ArmCommand(0, arm)
        );
    }
}
