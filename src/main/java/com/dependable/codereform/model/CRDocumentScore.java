package com.dependable.codereform.model;

public class CRDocumentScore {
    private double halsteadComplexity;
    private double cyclomaticComplexity;
    private int numberLines;
    private int totalNumberOperators;
    private int totalNumberOperands;
    private int numberDistinctOperators;
    private int numberDistinctOperands;

    private double volume;
    private double difficulty;
    private double effort;

    public CRDocumentScore() {
        //
    }

    public CRDocumentScore(double halsteadComplexity, double cyclomaticComplexity, int numberLines, int totalNumberOperators, int totalNumberOperands, int numberDistinctOperators, int numberDistinctOperands, double volume, double difficulty, double effort) {
        this.halsteadComplexity = halsteadComplexity;
        this.cyclomaticComplexity = cyclomaticComplexity;
        this.numberLines = numberLines;
        this.totalNumberOperators = totalNumberOperators;
        this.totalNumberOperands = totalNumberOperands;
        this.numberDistinctOperators = numberDistinctOperators;
        this.numberDistinctOperands = numberDistinctOperands;
        this.volume = volume;
        this.difficulty = difficulty;
        this.effort = effort;
    }

    public double getHalsteadComplexity() {
        return halsteadComplexity;
    }

    public void setHalsteadComplexity(double halsteadComplexity) {
        this.halsteadComplexity = halsteadComplexity;
    }

    public double getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }

    public void setCyclomaticComplexity(double cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
    }

    public int getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(int numberLines) {
        this.numberLines = numberLines;
    }

    public int getTotalNumberOperators() {
        return totalNumberOperators;
    }

    public void setTotalNumberOperators(int totalNumberOperators) {
        this.totalNumberOperators = totalNumberOperators;
    }

    public int getTotalNumberOperands() {
        return totalNumberOperands;
    }

    public void setTotalNumberOperands(int totalNumberOperands) {
        this.totalNumberOperands = totalNumberOperands;
    }

    public int getNumberDistinctOperators() {
        return numberDistinctOperators;
    }

    public void setNumberDistinctOperators(int numberDistinctOperators) {
        this.numberDistinctOperators = numberDistinctOperators;
    }

    public int getNumberDistinctOperands() {
        return numberDistinctOperands;
    }

    public void setNumberDistinctOperands(int numberDistinctOperands) {
        this.numberDistinctOperands = numberDistinctOperands;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }
}
