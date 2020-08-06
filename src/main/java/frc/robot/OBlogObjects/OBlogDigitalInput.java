package frc.robot.OBlogObjects;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Robot;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogDigitalInput extends DigitalInput implements Loggable {
    private int _channel = 0;
    private String _name = "DigitalInput";
    
    public OBlogDigitalInput(int channel) {
        super(channel);
        this._channel = channel;
    }

    public OBlogDigitalInput(int channel, String name) {
        super(channel);
        this._channel = channel;
        this._name = name;
    }

    //// Setup ////

    @Override
    public String configureLogName() {
        return this._name + " (" + Integer.toString(this._channel) + ")";
    }

    @Override
    public int[] configureLayoutPosition() {
        return new int[] {1 * this._channel, 0};
    }

    @Override
    public int[] configureLayoutSize() {
        return new int[] {1, 1};
    }

    //// Logs ////

    @Log.BooleanBox(name = "Status")
    boolean logMotorOutput() {
        return this.get();
    }
}