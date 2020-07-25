package com.nagp.service.person.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagp.model.Person;
import com.nagp.service.person.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> getAllPersons() {
        return getPersons();
    }

    private List<Person> getPersons() {
        return Arrays.asList(new Person(1, "Adam", 23, false));
    }
}
