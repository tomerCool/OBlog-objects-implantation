package frc.robot.OBlogObjects;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.commands.SetArmSolenoid;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class OBlogSolenoid extends DoubleSolenoid implements Loggable {
    private int _forwardChannel = 0,
                _reverseChannel = 0;
    private String _name = "DoubleSolenoid";
    
    public OBlogSolenoid(int forwardChannel, int reverseChannel) {
        super(forwardChannel, reverseChannel);
        this._forwardChannel = forwardChannel;
        this._reverseChannel = reverseChannel;
    }

    public OBlogSolenoid(int forwardChannel, int reverseChannel, String name) {
        super(forwardChannel, reverseChannel);
        this._forwardChannel = forwardChannel;
        this._reverseChannel = reverseChannel;
        this._name = name;
    }

    //// Setup ////

    @Override
    public String configureLogName() {
        return this._name + " (" + Integer.toString(this._forwardChannel) + ", " + Integer.toString(this._reverseChannel) + ")";
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

    @Log(name = "Status")
    public String logMotorOutput() {
        return this.get().toString();
    }

    @Log
    SetArmSolenoid setForward = new SetArmSolenoid(Value.kForward);
    @Log
    SetArmSolenoid setReverse = new SetArmSolenoid(Value.kReverse);
    @Log
    SetArmSolenoid setOff = new SetArmSolenoid(Value.kOff);

    //// Configs ////

    // @Config(name = "kP")
    // void configP(double p) {
    //     if (Robot.isSimulation()) return;
    //     this.config_kP(0, p);
    // }
}