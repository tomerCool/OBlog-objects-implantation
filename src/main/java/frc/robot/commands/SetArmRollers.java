package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.RollerState;

public class SetArmRollers extends CommandBase {
    private RollerState _state;
 
    public SetArmRollers(RollerState state) {
        this._state = state;
        SendableRegistry.setName(this, "Set " + this._state.toString());
    }

    @Override
    public void initialize() {
        
        // Actual arm code goes here or in execute ...

        System.out.println("ARM ROLLERS STATE SET TO " + this._state.toString());
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}