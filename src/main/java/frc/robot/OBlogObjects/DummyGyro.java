package frc.robot.OBlogObjects;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class DummyGyro extends GyroBase {
    private DoubleSupplier _getAngle;

    public DummyGyro(DoubleSupplier getAngle) {
        this._getAngle = getAngle;
    }

    @Override
    public void close() throws Exception {
        // Nothing
    }

    @Override
    public void calibrate() {
        // Nothing
    }

    @Override
    public void reset() {
        // Nothing
    }

    @Override
    public double getAngle() {
        return this._getAngle.getAsDouble();
    }

    @Override
    public double getRate() {
        return 0;
    }
}