package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class EnableCompressor extends CommandBase {

    @Override
    public void initialize() {
        RobotContainer.compressor.start();
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}