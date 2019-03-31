package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Override
    <S extends Person> S save(S s);

    @Override
    <S extends Person> Iterable<S> save(Iterable<S> iterable);

    @Override
    Person findOne(Integer s);

    @Override
    boolean exists(Integer s);

    @Override
    Iterable<Person> findAll();

    @Override
    Iterable<Person> findAll(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void delete(Integer s);

    @Override
    void delete(Person person);


    @Override
    void delete(Iterable<? extends Person> iterable);

    @Override
    void deleteAll();

}
