package com.test.Text;

public class Text {
  private String text;

  public Text(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "text = " + getText();
  }  

  public void countWord() {
    System.out.printf("This text has %d word(s)", this.text.split("\\W+").length);
  }

  public void countLetter(String letter) {
    int count = 0;
    for(int i = 0; i < this.text.length(); i++) {
      if(letter.equalsIgnoreCase("" + this.text.charAt(i))) count++;
    }
    System.out.printf("The letter '%s' has existed %d time(s) in the text", 
      letter, count);
  }
}
