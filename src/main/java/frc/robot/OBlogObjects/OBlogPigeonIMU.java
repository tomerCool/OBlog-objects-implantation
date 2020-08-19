package frc.robot.OBlogObjects;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import frc.robot.Robot;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogPigeonIMU extends PigeonIMU implements Loggable {
    private String _name = "PigeonIMU";

    @Log.Gyro(name = "Yaw")
    private DummyGyro _gyroWidget;
    
    public OBlogPigeonIMU(int deviceNumber) {
        super(deviceNumber);
        this._gyroWidget = new DummyGyro(this::getYaw);
    }

    public OBlogPigeonIMU(TalonSRX talon) {
        super(talon);
        this._gyroWidget = new DummyGyro(this::getYaw);
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
        return new int[] {3, 4};
    }

    //// Logs ////

    // @Log(name = "Yaw")
    public double getYaw() {
        if (Robot.isSimulation()) return 0.0;
        double[] ypr = new double[3];
        this.getYawPitchRoll(ypr);
        return Math.IEEEremainder(ypr[0], 360);
    }

    @Log(name = "Pitch")
    public double logPitch() {
        if (Robot.isSimulation()) return 0.0;
        double[] ypr = new double[3];
        this.getYawPitchRoll(ypr);
        return Math.IEEEremainder(ypr[1], 360);
    }

    @Log(name = "Roll")
    public double logRoll() {
        if (Robot.isSimulation()) return 0.0;
        double[] ypr = new double[3];
        this.getYawPitchRoll(ypr);
        return Math.IEEEremainder(ypr[2], 360);
    }
}