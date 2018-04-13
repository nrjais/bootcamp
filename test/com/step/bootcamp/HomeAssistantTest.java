package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeAssistantTest {

  private HomeAssistant homeAssistant;

  @Before
  public void setUp() {
    homeAssistant = new HomeAssistant();
  }

  @Test
  public void shouldTurnOnLight() {
    SquareLight mockSquareLight = mock(SquareLight.class);
    homeAssistant.add("turn on", () -> mockSquareLight.turnOn());
    homeAssistant.listen("turn on");
    verify(mockSquareLight).turnOn();
  }

  @Test
  public void shouldTurnOnHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    homeAssistant.add("music on", () -> mockTheater.on());
    homeAssistant.listen("music on");
    verify(mockTheater).on();
  }

  @Test
  public void shouldBeAbleToAddMultipleInstructionsInHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    homeAssistant.add("music off", () -> mockTheater.off())
        .add("Play Music", () -> mockTheater.play());
    homeAssistant.listen("music off");
    homeAssistant.listen("Play Music");
    verify(mockTheater).play();
    verify(mockTheater).off();
  }
}