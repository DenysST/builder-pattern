package com.company;

import java.util.Arrays;

public class Human {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;
    private final String[] citizenship;

    private Human(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;
        this.citizenship = builder.citizenship;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private Gender gender;
        private String[] citizenship;

        public Builder firstName(String firstName) {
            this.firstName = firstName.trim();
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName.trim();
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Builder citizenship(String[] citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public Human build() {
            validate(this);
            return new Human(this);
        }

        private static void validate(Builder builder) {
            if (builder.firstName == null || builder.firstName.isBlank()) {
                throw new RuntimeException("First name can not be empty");
            }
            if (builder.age <= 0) {
                throw new RuntimeException("Age can't be less then 0");
            }
        }
    }

    @Override
    public String toString() {
        return "Human{"
                + "firstName: " + firstName
                + ", lastName: " + lastName
                + ", age: " + age
                + ", gender: " + gender
                + ", citizenship: " + Arrays.toString(citizenship)
                + '}';
    }

    public enum Gender {
        MALE, FAMALE, OTHER
    }
}
