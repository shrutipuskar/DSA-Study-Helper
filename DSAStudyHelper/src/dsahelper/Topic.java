package dsahelper;

public class Topic {
    String name;
    int difficultyLevel; // 1: easy, 2: neutral, 3: hard
    int confidenceLevel; // Confidence level (1 to 5)

    public Topic(String name) {
        this.name = name;
        this.confidenceLevel = 0; // Default confidence
        this.difficultyLevel = 2; // Default difficulty (neutral)
    }

    public void setDifficulty() {
        if (confidenceLevel >= 4) {
            difficultyLevel = 1; // easy
        } else if (confidenceLevel == 3) {
            difficultyLevel = 2; // neutral
        } else {
            difficultyLevel = 3; // hard
        }
    }
}
