import enums.CelestialBodies;
import persons.composition.FilePersonReader;
import persons.composition.InMemoryPersonReader;
import persons.composition.PersonReportGenerator;
import persons.inheritance.FilePersonReportGenerator;
import persons.inheritance.InMemoryPersonReportGenerator;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static final String PEOPLE_TXT = "src/main/resources/people.txt";

    public static void main(String[] args) throws IOException {
        WeightOnPlanetsCalculator calculator = new WeightOnPlanetsCalculator();

        calculator.printWeightOnEveryCelestialBody(75);
        System.out.println();
        calculator.printWeightOnEveryCelestialBody(8);


        FilePersonReader personReader = new FilePersonReader(PEOPLE_TXT);
        new PersonReportGenerator(personReader, "src/main/resources/compositionFileReport.txt")
                .generateReport();

        new PersonReportGenerator(new InMemoryPersonReader(), "src/main/resources/inMemoryCompositionReport.txt")
                .generateReport();

        var generator = new FilePersonReportGenerator(PEOPLE_TXT);
        generator.generateReport("src/main/resources/inheritanceFileReport.txt");

        new InMemoryPersonReportGenerator().generateReport("src/main/resources/inMemoryInheritanceReport.txt");
    }
}

class WeightOnPlanetsCalculator {
    public void printWeightOnEveryCelestialBody(double weight) {
        calculateWeightOnAllCelestialBodies(weight)
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public Map<String, Double> calculateWeightOnAllCelestialBodies(double weight) {
        Map<String, Double> result = new TreeMap<>();
        EnumSet.allOf(CelestialBodies.class)
                .forEach(celestialBody -> result.put(celestialBody.name(), calculateWeight(celestialBody, weight)));
        return result;
    }

    public double calculateWeight(CelestialBodies celestialBody, double weight) {
        return celestialBody.weightEquivalentOnEarth(weight);
    }
}
