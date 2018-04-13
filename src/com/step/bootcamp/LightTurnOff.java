package com.step.bootcamp;

public class LightTurnOff implements Command {
  private final SquareLight light;

  public LightTurnOff(SquareLight light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOff();
  }

  @Override
  public void undo() {
    new LightTurnOn(light).execute();
  }
}
