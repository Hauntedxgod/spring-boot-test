package ru.maxima.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.springbootdemo.model.Person;
import ru.maxima.springbootdemo.repositories.OrderRepositories;
import ru.maxima.springbootdemo.repositories.PeopleRepository;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository repository;
    private final OrderRepositories orderRepositories;

    @Autowired
    public PeopleService(PeopleRepository repository, OrderRepositories orderRepositories) {
        this.repository = repository;
        this.orderRepositories = orderRepositories;
    }


    public List<Person> getAllPeople() {

        orderRepositories.findAll();



        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id).orElse(null);
    }


    @Transactional
    public void save(Person person) {
        repository.save(person);
    }

    @Transactional
    public void update(Long id, Person editedPerson) {
        editedPerson.setId(id);
        repository.save(editedPerson);
    }


    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void upgradeToAdmin(Person person) {
        person.setAdmin(true);
        repository.save(person);
    }
}
