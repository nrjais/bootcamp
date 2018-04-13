package com.step.bootcamp;

public class HomeTheaterTurnOff implements Command {
  private final HomeTheater homeTheater;

  public HomeTheaterTurnOff(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.off();
  }

  @Override
  public void undo() {
    new HomeTheaterTurnOn(homeTheater).execute();
  }
}
