package persons.composition;

import persons.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class PersonReportGenerator {
    private final PersonReportWriter reportWriter = new PersonReportWriter();
    private final String outputFile;
    private final PersonReader personReader;

    public PersonReportGenerator(PersonReader personReader, String outputFile) {
        this.personReader = personReader;
        this.outputFile = outputFile;
    }

    public void generateReport() throws IOException {
        reportWriter.writeReport(new TreeMap<>(groupPeopleByAgeGroup()), outputFile);
    }

    private Map<String, List<Person>> groupPeopleByAgeGroup() {
        return personReader.readPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getAgeGroup));
    }

    public String getOutputFile() {
        return outputFile;
    }
}
