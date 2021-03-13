package persons.inheritance;

import persons.Person;

import java.util.List;

public class InMemoryPersonReportGenerator extends AbstractPersonReportGenerator {
    @Override
    protected List<Person> readPersons() {
        return List.of(
                new Person("Gyuszi", "Matyas", 38),
                new Person("Laci", "Hegedus", 44),
                new Person("Pista", "Zold", 29),
                new Person("Zoli", "Piros", 17),
                new Person("Ferenc", "Orban", 80)
        );
    }
}
