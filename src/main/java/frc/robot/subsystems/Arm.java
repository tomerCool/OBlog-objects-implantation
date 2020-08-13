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
import frc.robot.OBlogObjects.OBlogSolenoid;
import frc.robot.OBlogObjects.OBlogSpark;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

public class Arm extends SubsystemBase implements Loggable {
  private OBlogDigitalInput _hall;

  private OBlogSolenoid _sole;
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Arm() {
    this._hall = new OBlogDigitalInput(0, RobotContainer.updateNT + "DIO");

    _sole = new OBlogSolenoid(0, 1, RobotContainer.updateNT + "Solenoid");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
