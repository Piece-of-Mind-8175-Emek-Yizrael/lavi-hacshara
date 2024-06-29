// RobotBuilder Version: 6.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.
 
package frc.robot;

import static frc.robot.Constants.ControllerConstants.OPERATOR_PORT;
import static frc.robot.Constants.IntakeConstants.INTAKE_SPEED;
import static frc.robot.Constants.IntakeConstants.OUTAKE_SPEED;
import static frc.robot.Constants.IntakeConstants.FOLD_SPEED;
import static frc.robot.Constants.IntakeConstants.OPEN_SPEED;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.POM_lib.Joysticks.PomXboxController;
import frc.robot.Subsystem.DriveSubsystem;
import frc.robot.Subsystem.IntakeSubsystem;
import frc.robot.commandGroup.CloseCommandGroup;
import frc.robot.commandGroup.OpenWithIntakeCommandGrpup;
import frc.robot.commands.ArmCommands.ArmCommand;
import frc.robot.commands.DriveCommands.ArcadeDriveCommand;
import frc.robot.commands.IntakeConnads.IntakeCommand;
import frc.robot.Subsystem.ArmSubsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();
  
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems

// Joysticks

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  DriveSubsystem drive;

  IntakeSubsystem intake;

  ArmSubsystem arm;

  public PomXboxController controller;
   
  
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    
    controller = new PomXboxController(OPERATOR_PORT);
    drive = drive.getInstance();
    intake = intake.getInstance();
    arm = arm.getInstance();

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems

    // SmartDashboard Buttons

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
        // Create some buttons
        drive.setDefaultCommand(new ArcadeDriveCommand(() -> controller.getLeftY(), () -> controller.getRightX(), drive));


        controller.a().onTrue(new IntakeCommand(INTAKE_SPEED, intake));
        controller.b().onTrue(new IntakeCommand(OUTAKE_SPEED, intake));
        controller.a().or(controller.b()).onFalse(new IntakeCommand(0, intake));

        controller.x().onTrue(new ArmCommand(FOLD_SPEED, arm));
        controller.y().onTrue(new ArmCommand(OPEN_SPEED, arm));
        controller.x().or(controller.y()).onFalse(new ArmCommand(OPEN_SPEED, arm));

        controller.LB().onTrue(new OpenWithIntakeCommandGrpup(OPEN_SPEED, INTAKE_SPEED, arm, intake));
        controller.LB().onFalse(new CloseCommandGroup(arm, intake));
        
        controller.RB().onTrue(new CloseCommandGroup(arm, intake));


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

