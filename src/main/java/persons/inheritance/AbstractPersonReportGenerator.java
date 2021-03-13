package persons.inheritance;

import persons.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

abstract class AbstractPersonReportGenerator {

    public void generateReport(String outputFile) throws IOException {
        Map<String, List<Person>> personsByAgeGroup = new TreeMap<>(groupPeopleByAgeGroup());
        writeReport(personsByAgeGroup, outputFile);
    }

    private void writeReport(Map<String, List<Person>> personsByAgeGroup, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            personsByAgeGroup.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + ": " + getPersonNames(entry.getValue()))
                    .forEach(names -> writeLine(writer, formatNamesList(names)));
        }
    }

    private Map<String, List<Person>> groupPeopleByAgeGroup() {
        return readPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getAgeGroup));
    }

    private String formatNamesList(String names) {
        StringBuilder builder = new StringBuilder(names);
        int indexOfFirstBracket = builder.indexOf("[");
        builder.replace(indexOfFirstBracket, indexOfFirstBracket + 1, "");
        builder.replace(builder.length() - 1, builder.length(), "");
        return builder.toString();
    }

    private List<String> getPersonNames(List<Person> persons) {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(toList());

    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<Person> readPersons();
}
