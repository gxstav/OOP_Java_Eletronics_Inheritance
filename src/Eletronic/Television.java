package Eletronic;

import java.util.ArrayList;
import java.util.List;

public class Television extends Eletronic {

  private Integer channel = 0;
  private Integer[] channelLimits = { 1, 100 };
  private List<Integer> favoriteChannels = new ArrayList<Integer>();

  public String channelUp() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else {
      String result;
      Integer prevChannel = this.channel;
      if (channelLimits[0] <= channel && channel < channelLimits[1]) {
        this.channel++;
        result = String.format("Channel switched from %d to %d", prevChannel, this.channel);
      } else {
        result = String.format("You have reached the last channel available (%d)", channelLimits[1]);
      }
      return result;
    }
  }

  public String channelDown() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else {
      String result;
      Integer prevChannel = this.channel;
      if (channelLimits[0] < channel && channel <= channelLimits[1]) {
        this.channel--;
        result = String.format("Channel switched from %d to %d", prevChannel, this.channel);
      } else {
        result = String.format("You have reached the first channel available (%d)", channelLimits[0]);
      }
      return result;
    }
  }

  public String gotoChannel(Integer value) {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else {
      Integer prevChannel = this.channel;
      String result;
      if (channelLimits[0] <= value && value <= channelLimits[1]) {
        this.channel = value;
        result = String.format("Channel switched from %d to %d", prevChannel, this.channel);
      } else {
        result = String.format(
            "The first channel is set at %d , the last channel is set at %d , you've tried to set %d as value.",
            this.channelLimits[0], this.channelLimits[1], value);
      }
      return result;
    }
  }

  public String favoriteIt() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else {
      this.favoriteChannels.add(this.channel);
      return String.format("Channel %d has been saved into your favorites.", this.channel);
    }
  }

  public List<Integer> favorites() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else
      return this.favoriteChannels;
  }
}