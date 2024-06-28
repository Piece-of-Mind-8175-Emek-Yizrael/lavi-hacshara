package frc.robot.Subsystem;

import static frc.robot.Constants.IntakeConstants.ARM_PORT;
import static frc.robot.Constants.IntakeConstants.GROUND_SWITCH;
import static frc.robot.Constants.IntakeConstants.LIMIT_SWITCH;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.POM_lib.PomSubsystem;

public class ArmSubsystem extends PomSubsystem{
    private CANSparkMax arm_motor = new CANSparkMax(ARM_PORT, MotorType.kBrushless);
    private RelativeEncoder arm_Encoder = arm_motor.getEncoder();
    private DigitalInput foldLimitSwitch = new DigitalInput(LIMIT_SWITCH);
    private DigitalInput openLimitSwitch = new DigitalInput(GROUND_SWITCH);
    private ArmFeedforward armFeedforward = new ArmFeedforward(0, 0.048, 0);

    private static ArmSubsystem instance;

    ArmSubsystem(){
        arm_Encoder.setPositionConversionFactor(1/50.0 * 16/42.0 * 2 * Math.PI);
    }

    public ArmSubsystem getInstance(){
        if (instance == null)
            instance = new ArmSubsystem();
        
        return instance;
    }

    @Override
    public void periodic(){
        // if ((!openLimitSwitch.get() && arm_motor.get() > 0) || !foldLimitSwitch.get() && arm_motor.get() < 0){
        //     arm_motor.set(0);
        // }
        if(!foldLimitSwitch.get()){
            arm_Encoder.setPosition(-0.323);
        }
    }

    @Override
    public void stopMotor(){
        //might be wrong in a robot that can stop in between but since this robot dosen't need to
        if (!openLimitSwitch.get() || !foldLimitSwitch.get()){
            arm_motor.set(0);
        }else {
            arm_motor.set(resistGravity());
        }
    }

    public boolean getOpenSw(){
        return !openLimitSwitch.get();
    }

    public boolean getFoldSw(){
        return !foldLimitSwitch.get();
    }
    
    @Override
    public void setMotor(double speed){
        if ((speed + resistGravity() > 0 && openLimitSwitch.get()) || (speed + resistGravity() < 0 && foldLimitSwitch.get())){
            arm_motor.set(speed + resistGravity());
        }
    }

    public void setVoltage(double voltage){
        arm_motor.setVoltage(voltage);
    }
    
    public double resistGravity(){
        return armFeedforward.calculate(arm_Encoder.getPosition(), 0);
    }
}
