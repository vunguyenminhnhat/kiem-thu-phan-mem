package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    @Test
    public void testCountExcellentStudents_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int result = analyzer.countExcellentStudents(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(2, result);
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_BoundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0, 0.0)));
    }

    @Test
    public void testCalculateValidAverage_NormalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(8.17, avg, 0.01);
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(-2.0, 15.0)));
    }
}