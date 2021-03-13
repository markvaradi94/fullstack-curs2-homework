package persons.composition;

import persons.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersonReader implements PersonReader {
    private final String sourceFile;

    public FilePersonReader(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public List<Person> readPersons() {
        try {
            return readPersonsFromFile();
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    private List<Person> readPersonsFromFile() throws IOException {
        return Files.lines(Path.of(sourceFile))
                .map(this::readPerson)
                .collect(Collectors.toList());
    }

    private Person readPerson(String line) {
        String[] personInfo = line.split(",");
        return new Person(
                personInfo[0],
                personInfo[1],
                Integer.parseInt(personInfo[2])
        );
    }
}
