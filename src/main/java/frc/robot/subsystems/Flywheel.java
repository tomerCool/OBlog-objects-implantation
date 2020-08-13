/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.OBlogObjects.OBlogDigitalInput;
import frc.robot.OBlogObjects.OBlogPIDF;
import frc.robot.OBlogObjects.OBlogSpark;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

public class Flywheel extends SubsystemBase implements Loggable {
  private OBlogSpark _L, _R;
  private OBlogPIDF _controller;
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Flywheel() {
    this._L = new OBlogSpark(0, RobotContainer.updateNT + "Left Spark");
    this._R = new OBlogSpark(1, RobotContainer.updateNT + "Right Spark");

    this._controller = new OBlogPIDF(1.0, 0.0, 0.0, 1.0, RobotContainer.updateNT + "Controller");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
