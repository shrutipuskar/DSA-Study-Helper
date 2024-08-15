package dsahelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Topic> topics = initializeTopics();
        List<Topic> selectedTopics = getUserSelectedTopics(topics);

        int totalAvailableDays = getTotalAvailableDays();

        StudyPlan studyPlan = new StudyPlan();
        List<String> plan = studyPlan.generatePlan(totalAvailableDays, selectedTopics);

        System.out.println("\nYour Study Plan:");
        for (String planItem : plan) {
            System.out.println(planItem);
        }

        displayLearningTips();
    }

    private static List<Topic> initializeTopics() {
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Learn at least one Programming Language"));
        topics.add(new Topic("Learn about Complexities"));
        topics.add(new Topic("Array"));
        topics.add(new Topic("String"));
        topics.add(new Topic("Linked List"));
        topics.add(new Topic("Searching Algorithm"));
        topics.add(new Topic("Sorting Algorithm"));
        topics.add(new Topic("Divide and Conquer Algorithm"));
        topics.add(new Topic("Stack"));
        topics.add(new Topic("Queue"));
        topics.add(new Topic("Tree Data Structure"));
        topics.add(new Topic("Graph Data Structure"));
        topics.add(new Topic("Greedy Methodology"));
        topics.add(new Topic("Recursion"));
        topics.add(new Topic("Backtracking Algorithm"));
        topics.add(new Topic("Dynamic Programming"));
        return topics;
    }

    private static List<Topic> getUserSelectedTopics(List<Topic> allTopics) {
        List<Topic> selectedTopics = new ArrayList<>();

        System.out.println("Available Topics:");
        for (int i = 0; i < allTopics.size(); i++) {
            System.out.println(i + ". " + allTopics.get(i).name);
        }

        int numOfTopics = getValidIntInput("How many topics do you want to study? ");

        for (int i = 0; i < numOfTopics; i++) {
            int index = getValidIntInput("Enter index of topic " + (i + 1) + ": ");
            
            if (index >= 0 && index < allTopics.size()) {
                Topic topic = allTopics.get(index);
                System.out.println("For the topic '" + topic.name + "', enter your confidence level:");
                displayConfidenceLevels();
                int confidence = getValidIntInput();
                topic.confidenceLevel = confidence;
                selectedTopics.add(topic);
            } else {
                System.out.println("Invalid index. Please try again.");
                i--; // Decrement to repeat this iteration
            }
        }

        return selectedTopics;
    }

    private static void displayConfidenceLevels() {
        System.out.println("1 - Very Low Confidence");
        System.out.println("2 - Low Confidence");
        System.out.println("3 - Neutral Confidence");
        System.out.println("4 - High Confidence");
        System.out.println("5 - Very High Confidence");
    }

    private static int getTotalAvailableDays() {
        return getValidIntInput("Enter the total number of days you have for preparation: ");
    }

    private static int getValidIntInput(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    private static int getValidIntInput() {
        return getValidIntInput("");
    }

    private static void displayLearningTips() {
        System.out.println("\nTips to boost your learning:");
        System.out.println("1. Learn the Fundamentals of chosen Language properly");
        System.out.println("2. Get a good grasp of the Complexity Analysis");
        System.out.println("3. Focus on Logic Building");
        System.out.println("4. Don’t worry if stuck on a problem");
        System.out.println("5. Be consistent");
    }
}
