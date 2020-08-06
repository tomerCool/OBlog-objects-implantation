package frc.robot.OBlogObjects;

import com.revrobotics.CANSparkMax;

import frc.robot.Robot;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogSpark extends CANSparkMax implements Loggable {
    private int _deviceNumber = 0;
    private String _name = "Spark";
    
    public OBlogSpark(int deviceNumber) {
        super(deviceNumber, MotorType.kBrushless);
        this._deviceNumber = deviceNumber;
    }

    public OBlogSpark(int deviceNumber, String name) {
        super(deviceNumber, MotorType.kBrushless);
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
        return new int[] {3, 5};
    }

    //// Logs ////

    @Log.Graph(name = "Position")
    double logPosition() {
        if (Robot.isSimulation()) return 0.0;
        return this.getEncoder().getPosition();
    }

    @Log.Dial(name = "Velocity")
    double logVelocity() {
        if (Robot.isSimulation()) return 0.0;
        return this.getEncoder().getVelocity();
    }

    @Log.NumberBar(name = "Motor Output")
    double logMotorOutput() {
        if (Robot.isSimulation()) return 0.0;
        return this.getAppliedOutput();
    }
}