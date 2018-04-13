package com.step.bootcamp;

import java.util.HashMap;

public class HomeAssistant {
  private final HashMap<String, Command> commands;

  public HomeAssistant() {
    this.commands = new HashMap<>();
  }

  public HomeAssistant add(String instruction, Command command){
    commands.put(instruction.toLowerCase().trim(), command);
    return this;
  }

  public void listen(String instruction){
    instruction = instruction.toLowerCase().trim();
    Command command = commands.get(instruction);
    if(command != null) command.execute();
  }
}
