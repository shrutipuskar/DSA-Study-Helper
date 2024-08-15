# DSA Study Helper

## Overview

DSA Study Helper is a Java-based application designed to assist students in creating a study plan for Data Structures and Algorithms (DSA) based on their confidence levels in various topics. The application allows users to allocate study days to different topics based on their confidence and provides useful learning tips.

## Features

- **Interactive Topic Selection:** Choose topics from a predefined list and rate your confidence in each.
- **Dynamic Study Plan Generation:** Allocate study days to topics based on confidence levels and available days.
- **Learning Tips:** Provides practical tips to boost your learning efficiency and overcome challenges.

## Classes

### `Topic`

The `Topic` class represents a study topic with the following attributes:
- `name`: The name of the topic.
- `difficultyLevel`: Difficulty level of the topic (1: easy, 2: neutral, 3: hard).
- `confidenceLevel`: User's confidence level in the topic (1 to 5).

Methods:
- `setDifficulty()`: Sets the difficulty level based on the confidence level.

### `StudyPlan`

The `StudyPlan` class is responsible for generating a study plan based on the user's available days and selected topics.

Methods:
- `generatePlan(int totalAvailableDays, List<Topic> topics)`: Generates a study plan by allocating days to topics based on their confidence levels.

### `Main`

The `Main` class is the entry point of the application, providing a command-line interface for user interaction.

## Installation

To set up and run the DSA Study Helper, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/shrutipuskar/DSA-Study-Helper.git
