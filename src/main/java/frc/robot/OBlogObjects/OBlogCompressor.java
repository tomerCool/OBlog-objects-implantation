package frc.robot.OBlogObjects;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.Robot;
import frc.robot.commands.DisableCompressor;
import frc.robot.commands.EnableCompressor;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogCompressor extends Compressor implements Loggable {
    private String _name = "Compressor";

    public OBlogCompressor() {
        super();
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

    @Log(name = "Is Enabled")
    public boolean enabled() {
        if (Robot.isSimulation()) return false;
        return this.enabled();
    }

    @Log
    EnableCompressor enableCompressor = new EnableCompressor();
    @Log
    DisableCompressor disableCompressor = new DisableCompressor();
}