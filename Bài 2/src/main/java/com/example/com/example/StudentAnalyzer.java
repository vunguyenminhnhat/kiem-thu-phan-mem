package com.example;
import java.util.List;

public class StudentAnalyzer {

    /**
     * Đếm số học sinh đạt loại Giỏi (>= 8.0)
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (double score : scores) {
            if (score >= 0 && score <= 10) { // validate
                if (score >= 8.0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Tính điểm trung bình các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int validCount = 0;

        for (double score : scores) {
            if (score >= 0 && score <= 10) { // validate
                sum += score;
                validCount++;
            }
        }

        if (validCount == 0) {
            return 0;
        }

        return sum / validCount;
    }
}