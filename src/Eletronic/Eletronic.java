package Eletronic;

public class Eletronic {
  private Boolean on = false;
  private String brand;
  private String model;
  private Integer volume = 0;
  private Integer[] volumeLimit = { 0, 100 };

  public String turnOn() {
    String result = "Turned On.";
    if (this.on == true)
      result = "Already turned on.";
    else
      this.on = true;
    return result;
  }

  public String turnOff() {
    String result = "Turned Off.";
    if (this.on == false)
      result = "Already turned off.";
    else
      this.on = false;
    return result;
  }

  public boolean isOn() {
    return this.on;
  }

  public void setBrand(String value) {
    this.brand = value;
  }

  public String brand() {
    return this.brand;
  }

  public void setModel(String value) {
    this.model = value;
  }

  public String model() {
    return this.model;
  }

  public String volumeUp(Integer value) {
    if (!isOn())
      throw new Error("Turn it on before.");
    else {
      Integer prevVolume = this.volume;
      if (value == null)
        this.volume++;
      else if (volumeLimit[0] <= this.volume && this.volume <= volumeLimit[1] && value > this.volume)
        this.volume = value;
      else
        return String.format(
            "The minimal value is set at %d , the maximum value is set at %d , the actual value is %d, you've tried to set %d as value.",
            this.volumeLimit[0], this.volumeLimit[1], this.volume, value);
      return String.format("Raised the volume from %d to %d", prevVolume, this.volume);
    }
  }

  public String volumeDown(Integer value) {
    if (!isOn())
      throw new Error("Turn it on before.");
    else {
      Integer prevVolume = this.volume;
      if (value == null)
        this.volume--;
      else if (volumeLimit[0] <= this.volume && this.volume <= volumeLimit[1] && value < this.volume)
        this.volume = value;
      else
        return String.format(
            "The minimal value is set at %d , the maximum value is set at %d , the actual value is %d, you've tried to set %d as value.",
            this.volumeLimit[0], this.volumeLimit[1], this.volume, value);
      return String.format("Lowered the volume from %d to %d", prevVolume, this.volume);
    }
  }

  public String volume() {
    if (!isOn())
      throw new Error("Turn it on before.");
    else
      return String.format("Volume at %d", this.volume);
  }
}