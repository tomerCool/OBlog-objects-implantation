/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.OBlogObjects.OBlogDigitalInput;
import frc.robot.OBlogObjects.OBlogEnum;
import frc.robot.OBlogObjects.OBlogSolenoid;
import frc.robot.commands.SetArmRollers;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class Arm extends SubsystemBase implements Loggable {
  private OBlogDigitalInput _hall;

  private OBlogSolenoid _solenoid;
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Arm() {
    this._hall = new OBlogDigitalInput(0, RobotContainer.updateNT + "DIO");

    this._solenoid = new OBlogSolenoid(0, 1, RobotContainer.updateNT + "Solenoid");

    ShuffleboardLayout rollerCommands = OBlogEnum.getLayout(this.getName(), "Roller State", this::getRollerState);

    rollerCommands.add(new SetArmRollers(RollerState.IN));
    rollerCommands.add(new SetArmRollers(RollerState.OUT));
    rollerCommands.add(new SetArmRollers(RollerState.OFF));
  }

  public enum ArmState {
    SC,
    UP,
    DOWN,
    INTERMEDIATE
  }

  public enum RollerState {
    IN,
    OUT,
    OFF
  }

  public String getRollerState() {
    return RollerState.OUT.toString();
  }

  public void setState(Value value) {
      this._solenoid.set(value);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
