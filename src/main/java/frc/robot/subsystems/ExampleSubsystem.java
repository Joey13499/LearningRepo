// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

public class ExampleSubsystem extends SubsystemBase {
  private final TalonFX coolMotor;
  private VoltageOut spinHowMuch;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    coolMotor = new TalonFX(0);
    spinHowMuch = new VoltageOut(0);
    var coolConfigs = new TalonFXConfiguration();
    coolConfigs.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    coolMotor.getConfigurator().apply(coolConfigs);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void spinIt(double byHowMuch){
    coolMotor.setControl(spinHowMuch.withOutput(byHowMuch));
  }

}
