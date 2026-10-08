// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.XRPDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class driveForward extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final XRPDrivetrain m_subsystem;


    private final double m_distance = 61;
    private final double m_speed = 0.5;



  /**
   * Creates a new driveForward
   *.
   *
   * @param subsystem The subsystem used by this command.
   */
  public driveForward (XRPDrivetrain subsystem, double distance) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
  public double getAverageDistanceInch(){
    return (m_subsystem.getLeftDistanceInch() + m_subsystem.getRightDistanceInch())/2.0;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.arcadeDrive(0,0);
    m_subsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.arcadeDrive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(getAverageDistanceInch())>= m_distance;
  }
}
