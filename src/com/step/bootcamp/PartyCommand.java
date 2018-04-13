package com.step.bootcamp;

public class PartyCommand implements Command {
  private final SquareLight squareLight;
  private final CircularLight circularLight;
  private final HomeTheater homeTheater;

  public PartyCommand(SquareLight squareLight, CircularLight circularLight, HomeTheater homeTheater) {
    this.squareLight = squareLight;
    this.circularLight = circularLight;
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    squareLight.turnOff();
    circularLight.switchOff();
    homeTheater.volumeUp(5);
  }

  @Override
  public void undo() {
  }
}
