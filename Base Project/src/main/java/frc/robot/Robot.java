// RobotBuilder Version: 6.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Robot.

package frc.robot;


// import com.ctre.phoenix.sensors.WPI_PigeonIMU;




import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    private Command m_autonomousCommand;

    private RobotContainer m_robotContainer;

    // boolean open = false;
    // boolean fold = false;


    // double counter = 0.1;


    // enum IntakeState{
    //     toIntake,
    //     toOuttake,
    //     toHold
    // }

    // IntakeState intakeState = IntakeState.toHold;
    // IntakeState lastIntakeState = IntakeState.toHold;

    // private Timer timer = new Timer();
    // enum Phase{
    //     start,
    //     open,
    //     take,
    //     fold,
    //     back,
    //     done
    // }
    // Phase autonomousPhase;

    // int turns = 0;
    // private Timer driveTimer = new Timer();
    // WPI_PigeonIMU gyro = new WPI_PigeonIMU(7);
    // double lastAngle;

    // SendableChooser<Integer> m_chooser = new SendableChooser<>();

    // boolean moveUp = false;
    // boolean moveDown = false;

    // enum annoyingPhaseEnum{
    //     start,
    //     shot,
    //     turn,
    //     drive,
    //     end,
    //     done
    // }

    // annoyingPhaseEnum annoyingPhase;
    // double topAngle = 1.892765879631042;
    // double downAngle = 2.430774688720703;
    // boolean turnedOnce = false;
    // boolean done = false;
    // boolean turned = false;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        m_robotContainer = RobotContainer.getInstance();
        HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_RobotBuilder);
        enableLiveWindowInTest(true);
        

        // m_chooser.addOption("square", 0);
        // m_chooser.addOption("sequance", 1);
        // m_chooser.addOption("annoyingAuto", 2);
        // SmartDashboard.putData("auto chooser", m_chooser);
    }

    /**
    * This function is called every robot packet, no matter the mode. Use this for items like
    * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
    *
    * <p>This runs after the mode specific periodic functions, but before
    * LiveWindow and SmartDashboard integrated updating.
    */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();

        // SmartDashboard.putNumber("gyro", gyro.getYaw());
        // SmartDashboard.putNumber("last Angle", lastAngle);
        // SmartDashboard.putNumber("arm angle", arm_motor.getEncoder().getPosition());
    }


    /**
    * This function is called once each time the robot enters Disabled mode.
    */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
    * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
    */
    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }

        // timer.restart();
        // autonomousPhase = Phase.start;
        // annoyingPhase = annoyingPhaseEnum.start;

        // driveTimer.restart();
        // lastAngle = gyro.getYaw();

        // counter = 0;
    }


    // private boolean turn(double angle){
    //     if (gyro.getYaw() <= lastAngle + angle){
    //         drive.arcadeDrive(0, 0.14, false);
    //         return false;
    //     }
    //     lastAngle = gyro.getYaw();
    //     return true;
    // }

    // private void square(){
    //     if (counter < 4){
    //         if (driveTimer.get() < 2){
    //             drive.arcadeDrive(0.18, 0, false);
    //             return;
    //         }
                        
    //         if (turn(88)){
    //             driveTimer.restart();
    //             counter++;
    //         }
    //     }
    // }

    // private void seq(){
    //     switch (autonomousPhase){
    //         case start:
    //             if (timer.get() >= 2){
    //                 autonomousPhase = Phase.open;
    //                 break;
    //             }

    //             drive.arcadeDrive(0.2 , 0, false);
    //             break;

    //         case open:
    //             if (!openLimitSwitch.get()){
    //                 autonomousPhase = Phase.take;
    //                 intake.set(INTAKE_SPEED);
    //                 arm_motor.set(0);
    //                 timer.restart();
    //                 break;
    //             }

    //             arm_motor.set(resistGravity() + OPEN_SPEED);
    //             break;

    //         case take:
    //             if (timer.get() >= 2){
    //                 autonomousPhase = Phase.fold;
    //                 intake.set(0);
    //                 break;
    //             }
    //             break;
            
    //         case fold:
    //             if (!foldLimitSwitch.get()){
    //                 autonomousPhase = Phase.back;
    //                 arm_motor.set(0);
    //                 timer.restart();
    //                 break;
    //             }

    //             arm_motor.set(resistGravity() + FOLD_SPEED);
    //             break;

    //         case back:
    //             if (timer.get() >=2){
    //                 autonomousPhase = Phase.done;
    //                 break;
    //             }

    //             drive.arcadeDrive(-0.2 , 0, false);
    //             break;
    //     }
    // }

    // private void annoyingAuto(){
    //     switch (annoyingPhase) {
    //         case start:
    //             if (arm_motor.getEncoder().getPosition() < topAngle){
    //                 arm_motor.set(resistGravity() + OPEN_SPEED);
    //             }else{
    //                 intake.set(OUTAKE_SPEED);
    //                 timer.restart();
    //                 annoyingPhase = annoyingPhaseEnum.shot;
    //             }
    //             break;
    //         case shot:
    //             if (timer.get() >= 0.5){
    //                 intake.set(0);
    //                 if (done){
    //                     annoyingPhase = annoyingPhaseEnum.done;
    //                     break;
    //                 }
    //                 annoyingPhase = annoyingPhaseEnum.turn;
    //             }
    //             break;
    //         case turn:
    //             if (turn(180) || turned){
    //                 turned = true;
    //                 if (!turnedOnce && openLimitSwitch.get()){
    //                     turnedOnce = true;
    //                     annoyingPhase = annoyingPhaseEnum.drive;
    //                     drive.arcadeDrive(-0.2, 0);
    //                     intake.set(INTAKE_SPEED);
    //                     timer.restart();
    //                     turned = false;
    //                 }else if (turnedOnce){
    //                     turnedOnce = false;
    //                     annoyingPhase = annoyingPhaseEnum.drive;
    //                     drive.arcadeDrive(-0.2, 0);
    //                     timer.restart();
    //                 }
    //             }
    //             if (!turnedOnce){
    //                 if (openLimitSwitch.get()){
    //                     arm_motor.set(OPEN_SPEED + resistGravity());
    //                 }else{
    //                     arm_motor.set(0);
    //                 }
    //             }
    //             break;
    //         case drive:
    //             if (timer.get() >= 2){
    //                 if (turnedOnce){
    //                     annoyingPhase = annoyingPhaseEnum.turn;
    //                 }else if (arm_motor.getEncoder().getPosition() <= downAngle){
    //                     annoyingPhase = annoyingPhaseEnum.end;
    //                 }
    //                 drive.arcadeDrive(0, 0);
    //                 intake.set(0);
    //             }

    //             if (!turnedOnce){
    //                 if (arm_motor.getEncoder().getPosition() > downAngle){
    //                     arm_motor.set(resistGravity() + FOLD_SPEED);
    //                 }
    //             }
    //             break;
    //         case end:
    //             intake.set(OUTAKE_SPEED);
    //             done = true;
    //             annoyingPhase = annoyingPhaseEnum.shot;
    //             timer.restart();
    //             break;

    //         case done:
    //             break;
    //     }
    // }

    /**
    * This function is called periodically during autonomous.
    */
    @Override
    public void autonomousPeriodic() {
        

        // switch (m_chooser.getSelected()){
        //     case 0:
        //         square();
        //         break;
        //     case 1:
        //         seq();
        //         break;
        //     case 2:
        //         annoyingAuto();
        //         break;
        // }
        
        

    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
        
        
    }



    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
    * This function is called periodically during test mode.
    */
    @Override
    public void testPeriodic() {
    }

  

}