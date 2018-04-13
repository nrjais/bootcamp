package com.step.bootcamp;

public class HomeTheaterTurnOn implements Command {
  private final HomeTheater homeTheater;

  public HomeTheaterTurnOn(HomeTheater homeTheater) {
    this.homeTheater = homeTheater;
  }

  @Override
  public void execute() {
    homeTheater.on();
  }

  @Override
  public void undo() {
    new HomeTheaterTurnOff(homeTheater).execute();
  }
}
