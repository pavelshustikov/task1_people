package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;//имя, причём с момента создания объекта изменить его нельзя.
    protected final String surname;//фамилия, причём с момента создания объекта изменить её нельзя.
    private int age;
    private String address;

    Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = city;
    }

    Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
    }
    boolean hasAge() {// Возраст человека может быть неизвестен,
        // в этом случае метод boolean hasAge() должен вернуть false, иначе - true
        return age > 14 || age < 99;
    }
    boolean hasAddress() {
        return address != null;

    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    OptionalInt getAge() {
        return OptionalInt.of(age);

    }

    String getAddress() {
        return address;
    }

    String setAddress(String address) {
        return this.address = address;
    }

    public void happyBirthday() {//увеличение возраста на 1
        age += 1;
    }

    @Override
    public String toString() {
        return "\nPerson: " +
                "имя = '" + name + '\'' +
                ", фамилия = '" + surname + '\'' +
                ", возраст = " + age +
                ", адрес = '" + address + '\'';
    }

    PersonBuilder newChildBuilder() { //будет возвращать полузаполненный билдер для ребёнка,
        // а именно: с уже заполненными фамилией (родительской),
        // возрастом и текущим городом жительства (родительским).
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(age)
                .setAddress(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && name.equals(person.name)
                && surname.equals(person.surname)
                && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}