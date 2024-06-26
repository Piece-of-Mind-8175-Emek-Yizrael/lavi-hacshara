package frc.robot.Subsystem;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.POM_lib.PomSubsystem;

import static frc.robot.Constants.IntakeConstants.INTAKE_PORT;

public class IntakeSubsystem extends PomSubsystem{
    private CANSparkMax intake = new CANSparkMax(INTAKE_PORT, MotorType.kBrushless);

    private static IntakeSubsystem instance;

    private IntakeSubsystem(){
    }

    public IntakeSubsystem getInstance(){
        if (instance == null)
            instance = new IntakeSubsystem();
        
        return instance;
    }

    @Override
    public void periodic(){

    }

    @Override
    public void stopMotor(){
        intake.set(0);
    }

    @Override
    public void setMotor(double speed){
        intake.set(speed);
    }

    public void setVoltage(double voltage){
        intake.setVoltage(voltage);
    }
    
}
