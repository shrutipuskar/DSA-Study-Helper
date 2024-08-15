package dsahelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudyPlan {

    public List<String> generatePlan(int totalAvailableDays, List<Topic> topics) {
        List<String> plan = new ArrayList<>();
        int totalDaysAllocated = 0;

        // Set difficulty for each topic based on confidence level
        for (Topic topic : topics) {
            topic.setDifficulty();
        }

        // Calculate total weight (inverse of confidence levels)
        int totalWeight = topics.stream().mapToInt(topic -> 6 - topic.confidenceLevel).sum();

        for (Topic topic : topics) {
            int weight = 6 - topic.confidenceLevel;
            int daysForTopic = (int) Math.round((double) weight / totalWeight * totalAvailableDays);

            // Ensure we don't allocate more days than available
            if (totalDaysAllocated + daysForTopic > totalAvailableDays) {
                daysForTopic = totalAvailableDays - totalDaysAllocated;
            }

            plan.add(topic.name + ": " + daysForTopic + " days");
            totalDaysAllocated += daysForTopic;

            if (totalDaysAllocated >= totalAvailableDays) {
                break;
            }
        }

        // Adjust if totalDaysAllocated is less than totalAvailableDays due to rounding
        if (totalDaysAllocated < totalAvailableDays) {
            int remainingDays = totalAvailableDays - totalDaysAllocated;
            plan.set(plan.size() - 1, plan.get(plan.size() - 1).replace(" days", " + " + remainingDays + " days"));
        }

        return plan;
    }
}
