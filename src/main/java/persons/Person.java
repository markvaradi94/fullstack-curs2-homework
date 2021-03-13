package persons;

import java.util.Objects;

import static persons.PersonAgeGroup.*;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final PersonAgeGroup ageGroup;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ageGroup = determineAgeGroup(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAgeGroup() {
        return ageGroup.getAgeGroup();
    }

    private PersonAgeGroup determineAgeGroup(int age) {
        if (age <= 30) {
            return YOUNG;
        } else if (age <= 50) {
            return ADULT;
        } else {
            return ELDER;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && ageGroup == person.ageGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, ageGroup);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", ageGroup=" + ageGroup +
                '}';
    }
}
