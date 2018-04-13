package com.step.bootcamp;

public class LightTurnOn implements Command {
  private final SquareLight light;

  public LightTurnOn(SquareLight light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOn();
  }

  @Override
  public void undo() {
    new LightTurnOff(light).execute();
  }
}
