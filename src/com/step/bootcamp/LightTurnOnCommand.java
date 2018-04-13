package com.step.bootcamp;

public class LightTurnOnCommand implements Command {
  private Light light = new Light();
  @Override
  public void execute() {
    light.turnOn();
  }
}
