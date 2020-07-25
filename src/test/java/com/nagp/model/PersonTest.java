package com.nagp.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void testPerson() {
        Person person = new Person();
        person.setAge(1);
        person.setIsCitizen(false);
        assertFalse(person.getIsCitizen());
        assertSame(1, person.getAge());
    }

}
