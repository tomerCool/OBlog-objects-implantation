package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetArmSolenoid extends CommandBase {
    private Value _value = Value.kOff;

    public SetArmSolenoid(Value value) {
        this._value = value;
        SendableRegistry.setName(this, "Set " + value.toString());
    }

    @Override
    public void initialize() {
        RobotContainer.arm.setState(this._value);
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}