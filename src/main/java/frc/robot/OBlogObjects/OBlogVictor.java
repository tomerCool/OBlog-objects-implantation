package frc.robot.OBlogObjects;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Robot;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogVictor extends VictorSPX implements Loggable {
    private int _deviceNumber = 0;
    private String _name = "Victor";
    
    public OBlogVictor(int deviceNumber) {
        super(deviceNumber);
        this._deviceNumber = deviceNumber;
    }

    public OBlogVictor(int deviceNumber, String name) {
        super(deviceNumber);
        this._deviceNumber = deviceNumber;
        this._name = name;
    }

    //// Setup ////

    @Override
    public String configureLogName() {
        return this._name + " (" + Integer.toString(this._deviceNumber) + ")";
    }

    @Override
    public int[] configureLayoutPosition() {
        return new int[] {3 * this._deviceNumber, 0};
    }

    @Override
    public int[] configureLayoutSize() {
        return new int[] {3, 2};
    }

    //// Logs ////

    @Log.NumberBar(name = "Motor Output")
    double logMotorOutput() {
        if (Robot.isSimulation()) return 0.0;
        return this.getMotorOutputPercent();
    }
}