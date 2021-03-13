package persons.composition;

import persons.Person;

import java.util.List;

public class InMemoryPersonReader implements PersonReader {
    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Gicu", "Pop", 34),
                new Person("Ana", "Popa", 14),
                new Person("Mircea", "Popescu", 25),
                new Person("Mihai", "Popovici", 67),
                new Person("Gogu", "Patapievici", 8)
        );
    }
}
