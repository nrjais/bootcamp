package com.step.bootcamp;

import java.util.HashMap;
import java.util.Stack;

public class HomeAssistant {
  private final HashMap<String, Command> commands;
  private final Stack<Command> undoHistory;

  public HomeAssistant() {
    commands = new HashMap<>();
    undoHistory = new Stack<>();
  }

  public HomeAssistant add(String instruction, Command command){
    commands.put(instruction.toLowerCase().trim(), command);
    return this;
  }

  public void listen(String instruction){
    instruction = instruction.toLowerCase().trim();
    Command command = commands.get(instruction);

    if(instruction.equals("undo")){
      undo();
      return;
    }

    if(command != null){
      command.execute();
      undoHistory.push(command);
    }
  }

  private void undo(){
    if(undoHistory.empty()) return;
    undoHistory.pop().undo();
  }
}
