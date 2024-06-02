package frc.robot.Subsystem;

import static frc.robot.Constants.IntakeConstants.LeftTalonSRX;
import static frc.robot.Constants.IntakeConstants.LeftVictorSPX;
import static frc.robot.Constants.IntakeConstants.RightTalonSRX;
import static frc.robot.Constants.IntakeConstants.RightVictorSPX;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.POM_lib.PomSubsystem;

public class DriveSubsystem extends PomSubsystem{
    private WPI_TalonSRX leftTalon = new WPI_TalonSRX(LeftTalonSRX);
    private WPI_TalonSRX rightTalon = new WPI_TalonSRX(RightTalonSRX);
    private WPI_VictorSPX leftVictor = new WPI_VictorSPX(LeftVictorSPX);
    private WPI_VictorSPX rightVictor = new WPI_VictorSPX(RightVictorSPX);
    private DifferentialDrive drive = new DifferentialDrive(leftVictor::set, rightVictor::set);

    private static DriveSubsystem instance;
    private DriveSubsystem(){
        leftVictor.setInverted(false);
        leftTalon.setInverted(false);
        rightTalon.setInverted(true);
        rightVictor.setInverted(true);

        leftTalon.follow(leftVictor);
        rightTalon.follow(rightVictor);
    }

    public DriveSubsystem getInstance(){
        if (instance == null)
            instance = new DriveSubsystem();
        
        return instance;
    }

    @Override
    public void periodic(){

    }

    public void arcadeDrive(double speed, double rotation){
        drive.arcadeDrive(speed , rotation);
    }

    @Override
    public void stopMotor(){
        leftVictor.set(0);
        rightVictor.set(0);
        drive.feed();
    }

    @Override
    public void setMotor(double speed){
        leftVictor.set(speed);
        rightVictor.set(speed);
        drive.feed();
    }

    public void setVoltage(double voltage){
        leftVictor.setVoltage(voltage);
        rightVictor.setVoltage(voltage);
        drive.feed();
    }
    
}