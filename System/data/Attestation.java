package data;

import java.util.ArrayList;

public class Attestation {

  private double firstAtt;
  private double secondAtt;
  private double finalScore;
  private ArrayList<Double> firstAttScores;
  private ArrayList<Double> secondAttScores;
  
  public Attestation() {
    this.firstAtt = 0;
    this.secondAtt = 0;
    this.finalScore = 0;
    firstAttScores = new ArrayList<Double>();
    secondAttScores = new ArrayList<Double>();}
  
  public double getFirstAtt() {return firstAtt;}

  public double getSecondAtt() {return secondAtt;}

  public double getFinalScore() {return finalScore;}
  public void setFinalScore(double finalScore) {this.finalScore = finalScore;}

  public ArrayList<Double> getFirstAttScores() {return firstAttScores;}

  public ArrayList<Double> getSecondAttScores() {return secondAttScores;}

  public void addScoresToFirstAtt(double score) {
    this.firstAtt += score;
    this.firstAttScores.add(score);}
  
  public void addScoresToSecondtAtt(double score) {
    this.secondAtt += score;
    this.secondAttScores.add(score);}

  public double getTotal() {
      return this.firstAtt + this.secondAtt + this.finalScore;}
}