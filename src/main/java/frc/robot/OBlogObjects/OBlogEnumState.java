package frc.robot.OBlogObjects;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogEnumState implements Loggable {
    private String _name = "Enum";
    private Command _setterCommand = null;

    public OBlogEnumState(String name, Command setterCommand) {
        this._name = name;
        this._setterCommand = setterCommand;
    }

    //// Setup ////
    
    @Override
    public String configureLogName() {
        return this._name;
    }

    @Override
    public int[] configureLayoutPosition() {
        return new int[] {0, 0};
    }

    @Override
    public int[] configureLayoutSize() {
        return new int[] {2, 4};
    }

    //// Logs ////
}