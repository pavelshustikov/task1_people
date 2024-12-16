package ru.netology;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    PersonBuilder(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    PersonBuilder() {
    }

    PersonBuilder(String surname, int age, String city) {
        this.name = null;
        this.surname = surname;
        this.age = age;
        this.address = city;
    }

    String getName() {
        return name;
    }


    String getSurname() {
        return surname;
    }

    String getAddress() {
        return address;
    }
    PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    int getAge() {
        return age;
    }

    PersonBuilder setName(String name) { //если мы билдеру не указали достаточное количество данных
        // (например, не указали фамилию),
        // то метод build() должен выкинуть IllegalStateException с осмысленным сообщением.
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Заполните корректно поле 'Имя'");
        } else {
            this.name = name;
        }
        return this;
    }

    PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Заполните корректно поле 'Фамилия'");
        } else {
            this.surname = surname;
        }
        return this;
    }

    PersonBuilder setAge(int age) { //Если же мы передали неподходящие данные билдеру
        // (например, некорректный возраст builder.setAge(-100)),
        // то именно этот метод должен выкинуть IllegalArgumentException с осмысленным сообщением
        if (age <= 14 || age >= 99) {
            throw new IllegalArgumentException("Заполните корректно поле 'Возраст'");
        } else {
            this.age = age;
        }
        return this;
    }



    public Person build() {
        Person person = null;
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Поле 'Имя' обязательно для заполнения");
        } else if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Поле 'Фамилия' обязательно для заполнения");
        } else
            return new Person(name, surname, age, address);
    }
}
