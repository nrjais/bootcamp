package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareLightTest {

  @Test
  public void shouldTurnTheLightOff() {
    SquareLight squareLight = new SquareLight();
    assertTrue(squareLight.turnOff());
  }

  @Test
  public void shouldTurnTheLightOn() {
    SquareLight squareLight = new SquareLight();
    assertTrue(squareLight.turnOn());
  }
}
