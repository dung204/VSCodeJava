package com.test.SchoolManager;

import java.util.ArrayList;
import java.util.List;

public class Score {
  private final Subject subject;
  private final List<Double> levelOneScores;
  private final List<Double> levelTwoScores;
  private Double levelThreeScore;

  public Score(Subject subject) {
    this.subject = subject;
    this.levelOneScores = new ArrayList<>();
    this.levelTwoScores = new ArrayList<>(); 
    this.levelThreeScore = null;
  }


  public Subject getSubject() {
    return this.subject;
  }


  public List<Double> getLevelOneScores() {
    return this.levelOneScores;
  }


  public List<Double> getLevelTwoScores() {
    return this.levelTwoScores;
  }


  public double getLevelThreeScore() {
    return this.levelThreeScore;
  }

  public static List<Score> generateScores() {
    List<Score> scores = new ArrayList<>();
    for(Subject subject : Subject.values()) {
      scores.add(new Score(subject));
    }
    return scores;
  }


  @Override
  public String toString() {
    return "Subject: " + subject + "\n" +
           "Level one scores: " + levelOneScores + "\n" +
           "Level two scores: " + levelTwoScores + "\n" +
           "Level three score: " + levelThreeScore + "\n";
  }

}
