package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DisableCompressor extends CommandBase {

    @Override
    public void initialize() {
        RobotContainer.compressor.stop();
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}