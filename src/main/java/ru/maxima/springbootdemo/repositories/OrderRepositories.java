package ru.maxima.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.springbootdemo.model.Order;
import ru.maxima.springbootdemo.model.Person;


import java.util.List;

public interface OrderRepositories extends JpaRepository<Order, Long> {
    List<Order> findByName(String itemName);

    List<Order> findByOwner(Person person);

}
