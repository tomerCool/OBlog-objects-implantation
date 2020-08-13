/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.OBlogObjects.DummySpeedController;
import frc.robot.OBlogObjects.OBlogPigeonIMU;
import frc.robot.OBlogObjects.OBlogSpark;
import frc.robot.OBlogObjects.OBlogTalon;
import frc.robot.OBlogObjects.OBlogVictor;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class Drivetrain extends SubsystemBase implements Loggable {
  private OBlogTalon _L, _R;
  private OBlogVictor _LB, _RB, _LF, _RF;

  @Log.DifferentialDrive(name = "Differential Drive")
  DifferentialDrive drive = new DifferentialDrive(new DummySpeedController(this::getLeftOutput), new DummySpeedController(this::getRightOutput));

  // private OBlogPigeonIMU _pigeon;
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Drivetrain() {
    this._L = new OBlogTalon(0, RobotContainer.updateNT + "Left Talon");
    this._R = new OBlogTalon(1, RobotContainer.updateNT + "Right Talon");

    this._LB = new OBlogVictor(2, RobotContainer.updateNT + "LB Victor");
    this._RB = new OBlogVictor(3, RobotContainer.updateNT + "RB Victor");
    this._LF = new OBlogVictor(4, RobotContainer.updateNT + "LF Victor");
    this._RF = new OBlogVictor(5, RobotContainer.updateNT + "RF Victor");

    // this._pigeon = new OBlogPigeonIMU(this._R);
  }

  private double _leftOut, _rightOut;

  public double getLeftOutput() {
    this._leftOut += 0.01;
    return Math.sin(this._leftOut);
  }

  public double getRightOutput() {
    this._rightOut += 0.01;
    return Math.cos(this._rightOut);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
