/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OBlogObjects.OBlogSpark;
import io.github.oblarg.oblog.Loggable;

public class Flywheel extends SubsystemBase implements Loggable {
  private OBlogSpark _L, _R;
  
  private String a = "";
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Flywheel() {
    this._L = new OBlogSpark(0, a + "Left Master");
    this._R = new OBlogSpark(1, a + "Right Master");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
