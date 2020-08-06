/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OBlogObjects.OBlogSpark;
import frc.robot.OBlogObjects.OBlogVictor;
import io.github.oblarg.oblog.Loggable;

public class Drivetrain extends SubsystemBase implements Loggable {
  private OBlogSpark _L, _R;
  private OBlogVictor _LB, _RB, _LF, _RF;
  
  private String a = "";
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public Drivetrain() {
    this._L = new OBlogSpark(0, a + "Left Master");
    this._R = new OBlogSpark(1, a + "Right Master");

    this._LB = new OBlogVictor(2, a + "LB Slave");
    this._RB = new OBlogVictor(3, a + "RB Slave");
    this._LF = new OBlogVictor(4, a + "LF Slave");
    this._RF = new OBlogVictor(5, a + "RF Slave");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
