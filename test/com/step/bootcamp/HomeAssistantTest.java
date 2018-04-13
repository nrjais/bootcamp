package com.step.bootcamp;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeAssistantTest {
  @Test
  public void shouldTurnOnLight() {
    Light mockLight = mock(Light.class);
    HomeAssistant homeAssistant = new HomeAssistant();
    homeAssistant.add("turn on", ()->mockLight.turnOn());
    homeAssistant.listen("turn on");
    verify(mockLight).turnOn();
  }

  @Test
  public void shouldTurnOnHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    HomeAssistant homeAssistant = new HomeAssistant();
    homeAssistant.add("music on", ()->mockTheater.on());
    homeAssistant.listen("music on");
    verify(mockTheater).on();
  }

  @Test
  public void shouldBeAbleToAddMultipleInstructionsInHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    HomeAssistant homeAssistant = new HomeAssistant()
        .add("music off", () -> mockTheater.off())
        .add("Play Music", ()->mockTheater.play());

    homeAssistant.listen("music off");
    homeAssistant.listen("Play Music");
    verify(mockTheater).play();
    verify(mockTheater).off();
  }
}