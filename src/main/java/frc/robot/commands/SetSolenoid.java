package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetSolenoid extends CommandBase {
    private Value _value = Value.kOff;
    private DoubleSolenoid _solenoid;
 
    public SetSolenoid(DoubleSolenoid solenoid, Value value) {
        this._solenoid = solenoid;
        this._value = value;
        SendableRegistry.setName(this, "Set " + value.toString());
    }

    @Override
    public void initialize() {
        this._solenoid.set(this._value);
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}