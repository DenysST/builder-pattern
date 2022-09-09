package com.company;

public class Main {

    public static void main(String[] args) {
	Human human = new Human.Builder().firstName("   ").gender(Human.Gender.MALE).citizenship(new String[] {"Ukrainian"}).age(20).build();
        System.out.println(human);
    }
}
