package frc.robot.OBlogObjects;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Robot;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogTalon extends TalonSRX implements Loggable {
    private int _deviceNumber = 0;
    private String _name = "Talon";
    
    public OBlogTalon(int deviceNumber) {
        super(deviceNumber);
        this._deviceNumber = deviceNumber;
    }

    public OBlogTalon(int deviceNumber, String name) {
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
        return new int[] {3, 7};
    }

    //// Logs ////

    @Log.Graph(name = "Position")
    double logPosition() {
        if (Robot.isSimulation()) return 0.0;
        return this.getSelectedSensorPosition();
    }

    @Log.Dial(name = "Velocity")
    double logVelocity() {
        if (Robot.isSimulation()) return 0.0;
        return this.getSelectedSensorPosition();
    }

    @Log.NumberBar(name = "Motor Output")
    double logMotorOutput() {
        if (Robot.isSimulation()) return 0.0;
        return this.getMotorOutputPercent();
    }

    //// Configs ////

    @Config(name = "kP")
    void configP(double p) {
        if (Robot.isSimulation()) return;
        this.config_kP(0, p);
    }

    @Config(name = "kI")
    void configI(double i) {
        if (Robot.isSimulation()) return;
        this.config_kI(0, i);
    }

    @Config(name = "kD")
    void configD(double d) {
        if (Robot.isSimulation()) return;
        this.config_kD(0, d);
    }

    @Config(name = "kF")
    void configF(double f) {
        if (Robot.isSimulation()) return;
        this.config_kF(0, f);
    }

    @Config(name = "Tolerance")
    void configTolerance(int tolerance) {
        if (Robot.isSimulation()) return;
        this.configAllowableClosedloopError(0, tolerance, 0);
    }
}