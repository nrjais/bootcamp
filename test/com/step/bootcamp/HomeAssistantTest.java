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
    homeAssistant.add("turn on", new LightTurnOn(mockSquareLight));
    homeAssistant.listen("turn on");
    verify(mockSquareLight).turnOn();
  }

  @Test
  public void shouldTurnOnHomeTheater() {
    HomeTheater mockTheater = mock(HomeTheater.class);
    homeAssistant.add("music on", new HomeTheaterTurnOn(mockTheater));
    homeAssistant.listen("music on");
    verify(mockTheater).on();
  }

  @Test
  public void shouldBeAbleToEnterPartyMode() {
    SquareLight mockSquareLight = mock(SquareLight.class);
    CircularLight mockCircularLight = mock(CircularLight.class);
    HomeTheater mockTheater = mock(HomeTheater.class);
    homeAssistant.add("party",new PartyCommand(mockSquareLight,mockCircularLight ,mockTheater ));
    homeAssistant.listen("party");
    verify(mockSquareLight).turnOff();
    verify(mockCircularLight).switchOff();
    verify(mockTheater).volumeUp(5);
  }

  @Test
  public void shouldNotDoAnythingWhenCommandIsNotFound() {
    homeAssistant.listen("hello");
  }

  @Test
  public void shouldBeAbleToUndoPreviousCommand() {
    SquareLight mockSquareLight = mock(SquareLight.class);
    homeAssistant.add("turn on", new LightTurnOn(mockSquareLight));
    homeAssistant.listen("turn on");
    homeAssistant.listen("undo");
    verify(mockSquareLight).turnOn();
    verify(mockSquareLight).turnOff();
  }

  @Test
  public void shouldNotUndoWhenItIsFirstCommand() {
    homeAssistant.listen("undo");
  }

  @Test
  public void shouldBeAbleToUndoAllPreviousCommands() {
    SquareLight mockSquareLight = mock(SquareLight.class);
    HomeTheater homeTheater = mock(HomeTheater.class);
    homeAssistant.add("turn on", new LightTurnOn(mockSquareLight));
    homeAssistant.add("music on", new HomeTheaterTurnOn(homeTheater));
    homeAssistant.listen("turn on");
    homeAssistant.listen("music on");
    homeAssistant.listen("undo");
    homeAssistant.listen("undo");
    verify(mockSquareLight).turnOn();
    verify(homeTheater).on();
    verify(homeTheater).off();
    verify(mockSquareLight).turnOff();
  }
}
