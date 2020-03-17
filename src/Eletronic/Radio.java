package Eletronic;

import java.util.ArrayList;
import java.util.List;

public class Radio extends Eletronic {

  private Double frequency = 88.00;
  private String selectedType = "FM";
  private String[] frequencyType = { "AM", "FM" };
  // LIMITES DO ESPECTRO DE FREQUÊNCIAS AM E FM
  // http://willians.pro.br/frequencia/cap3_radio_am.htm
  private Double[][][] frequencyLimits = { { { 530.00 }, { 1600.00 } }, { { 88.00 }, { 108.00 } } };
  private List<String> favoriteFrequencies = new ArrayList<String>();

  public String switchType() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else {
      String prevType = this.selectedType;
      if (prevType == frequencyType[0]) {
        this.selectedType = frequencyType[1];
        this.frequency = frequencyLimits[1][0][0];
      } else {
        this.selectedType = frequencyType[0];
        this.frequency = frequencyLimits[0][1][0];
      }
      return String.format("Switched from %s to %s", prevType, this.selectedType);
    }
  }

  public String freqUp(Double value) {
    if (!this.isOn()) {
      throw new Error("Turn it on before.");
    } else {
      String result, prevType = this.selectedType;
      Double factor = 10.00, prevFrequency = this.frequency;
      if (value > 0)
        factor = value;
      if (this.selectedType == frequencyType[0]) {
        if (frequencyLimits[0][0][0] <= this.frequency && this.frequency < frequencyLimits[0][1][0] && factor > 0) {
          this.frequency += factor;
          if (this.frequency > frequencyLimits[0][1][0])
            this.frequency = frequencyLimits[0][1][0];
          result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, this.frequency,
              prevType);
        } else {
          result = String.format(
              "Minimal frequency for %s is %g, maximum frequency for %s is %g, you've tried to set %g",
              this.selectedType, frequencyLimits[0][0][0], this.selectedType, frequencyLimits[0][1][0]);
        }
      } else if (frequencyLimits[1][0][0] <= this.frequency && this.frequency < frequencyLimits[1][1][0]
          && factor > 0) {
        this.frequency += factor;
        if (this.frequency > frequencyLimits[1][1][0])
          this.frequency = frequencyLimits[1][1][0];
        result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, this.frequency,
            prevType);
      } else {
        result = String.format("Minimal frequency for %s is %g, maximum frequency for %s is %g, you've tried to set %g",
            this.selectedType, frequencyLimits[1][0][0], this.selectedType, frequencyLimits[1][1][0], value);
      }
      return result;
    }
  }

  public String freqDown(Double value) {
    if (!this.isOn()) {
      throw new Error("Turn it on before.");
    } else {
      String result, prevType = this.selectedType;
      Double factor = 10.00, prevFrequency = this.frequency;
      if (value != null)
        factor = value;
      if (this.selectedType == frequencyType[0]) {
        if (frequencyLimits[0][0][0] < this.frequency && this.frequency <= frequencyLimits[0][1][0] && factor > 0) {
          this.frequency -= factor;
          result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, this.frequency,
              prevType);
        } else {
          result = String.format(
              "Minimal frequency for %s is %g, maximum frequency for %s is %g, you've tried to set %g",
              this.selectedType, frequencyLimits[0][0][0], this.selectedType, frequencyLimits[0][1][0]);
        }
      } else if (frequencyLimits[1][0][0] < this.frequency && this.frequency <= frequencyLimits[1][1][0]
          && factor > 0) {
        this.frequency -= factor;
        result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, this.frequency,
            prevType);
      } else {
        result = String.format("Minimal frequency for %s is %g, maximum frequency for %s is %g, you've tried to set %g",
            this.selectedType, frequencyLimits[1][0][0], this.selectedType, frequencyLimits[1][1][0], value);
      }
      return result;
    }
  }

  public String gotoFrequency(Double value, String type) {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else {
      String result;
      Double prevFrequency = this.frequency;
      String prevType = this.selectedType;
      if (type == frequencyType[0]) {
        if (frequencyLimits[0][0][0] <= value && value <= frequencyLimits[0][1][0]) {
          this.frequency = value;
          this.selectedType = frequencyType[0];
          result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, this.frequency,
              this.selectedType);
        } else {
          result = String.format(
              "Minimal frequency for %s is %g, maximum frequency for %s is %g, you've tried to set %g", type,
              frequencyLimits[0][0][0], type, frequencyLimits[0][1][0]);
        }
      } else if (type == frequencyType[1]) {
        if (frequencyLimits[1][0][0] <= value && value <= frequencyLimits[1][1][0]) {
          this.frequency = value;
          this.selectedType = frequencyType[1];
          result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, this.frequency,
              this.selectedType);
        } else {
          result = String.format(
              "Minimal frequency for %s is %g, maximum frequency for %s is %g, you've tried to set %g", type,
              frequencyLimits[1][0][0], type, frequencyLimits[1][1][0]);
        }
      } else if (type == null) {
        this.frequency = value;
        result = String.format("Changed frequency from %g %s to %g %s", prevFrequency, prevType, value, prevType);
      } else {
        throw new Error("Wrong frequency type.");
      }
      return result;
    }
  }

  public String favoriteIt() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else
      this.favoriteFrequencies.add(this.frequency.toString() + " " + this.selectedType);
    return String.format("Frequency %g %s has been saved into your favorites.", this.frequency, this.selectedType);
  }

  public List<String> favorites() {
    if (!this.isOn())
      throw new Error("Turn it on before.");
    else
      return this.favoriteFrequencies;
  }
}