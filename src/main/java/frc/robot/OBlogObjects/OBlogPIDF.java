package frc.robot.OBlogObjects;

import edu.wpi.first.wpilibj.controller.PIDController;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogPIDF extends PIDController implements Loggable {
    private static int _id = 0;
    private String _name = "PIDF";
    private double _Kf = 0.0,
                   _positionTolerance = 0.05; 
    
    public OBlogPIDF(double Kp, double Ki, double Kd, double Kf) {
        super(Kp, Ki, Kd);
        this._Kf = Kf;
        this._id++;
    }

    public OBlogPIDF(double Kp, double Ki, double Kd, double Kf, String name) {
        super(Kp, Ki, Kd);
        this._name = name;
        this._Kf = Kf;
        this._id++;
    }

    //// Adding Kf ////

    public double getF() {
        return this._Kf;
    }

    public void setF(double Kf) {
        this._Kf = Kf;
    }

    @Override
    public double calculate(double measurement) {
        return super.calculate(measurement) + this._Kf * (this.getContinuousError(this.getSetpoint() - measurement));
    }

    @Override
    public double calculate(double measurement, double setpoint) {
        return super.calculate(measurement, setpoint) + this._Kf * (this.getContinuousError(setpoint - measurement));
    }

    //// Setup ////

    @Override
    public String configureLogName() {
        return this._name + " (" + Integer.toString(this._id) + ")";
    }

    @Override
    public int[] configureLayoutPosition() {
        return new int[] {0, 0};
    }

    @Override
    public int[] configureLayoutSize() {
        return new int[] {3, 6};
    }

    //// Logs ////

    @Log.Graph(name = "Position Error")
    double logPosition() {
        return this.getPositionError();
    }

    @Log(name = "Velocity Error")
    double logVelocity() {
        return this.getVelocityError();
    }

    //// Configs ////

    @Config(name = "kP")
    void configP(double p) {
        this.setP(p);
    }

    @Config(name = "kI")
    void configI(double i) {
        this.setI(i);
    }

    @Config(name = "kD")
    void configD(double d) {
        this.setD(d);
    }

    @Config(name = "kF")
    void configF(double f) {
        this.setF(f);
    }

    @Config(name = "Pos Tol")
    void setPositionTolerance(double positionTolerance) {
        this._positionTolerance = positionTolerance;
        this.setTolerance(positionTolerance);
    }

    @Config(name = "Vel Tol")
    void setVelocityTolerance(double velocityTolerance) {
        this.setTolerance(this._positionTolerance, velocityTolerance);
    }
}