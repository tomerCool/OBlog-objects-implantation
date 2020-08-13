package frc.robot.OBlogObjects;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.SpeedController;

public class DummySpeedController implements SpeedController {
    private DoubleSupplier _getOutput;

    public DummySpeedController(DoubleSupplier getOutput) {
        this._getOutput = getOutput;
    }

    @Override
    public void pidWrite(double output) {
        // Nothing
    }

    @Override
    public void set(double speed) {
        // Nothing
    }

    @Override
    public double get() {
        return this._getOutput.getAsDouble();
    }

    @Override
    public void setInverted(boolean isInverted) {
        // Nothing
    }

    @Override
    public boolean getInverted() {
        return false;
    }

    @Override
    public void disable() {
        // Nothing
    }

    @Override
    public void stopMotor() {
        // Nothing
    }

}