package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController  {
  //@Controller
  private PersonRepository personRepository;
/**
 * @Autowired
 *     public BakerController(BakerService service) {
 *         this.service = service;
 *     }
 *
 *     public ResponseEntity<Iterable<Baker>> index() {
 *         return new ResponseEntity<>(service.index(), HttpStatus.OK);
 *     }
 * @GetMapping("/bakers/{id}")
 *     public ResponseEntity<Baker> show(@PathVariable Long id) {
 *         return new ResponseEntity<>(service.show(id), HttpStatus.OK);
 *     }
 * @PostMapping("/bakers/")
 *     public ResponseEntity<Baker> create(@RequestBody Baker baker) {
 *         return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
 *     }
 * @PutMapping("/bakers/{id}")
 *     public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
 *         return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
 *     }
 * @DeleteMapping("/bakers/{id}")
 *     public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
 *         return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
 *     }
 */
    @Autowired

    public PersonController(PersonRepository personRepository) {
    this.personRepository =personRepository;
    }

//    @PostMapping {"/people/"}
//    public ResponseEntity<Person> createPerson(@RequestBody Person p){
//        return new ResponseEntity<>(PersonRepository.) {
//
//    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personRepository.save(p),HttpStatus.CREATED);

    }
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(personRepository.findOne(id) , HttpStatus.OK);
    }
    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<>((List<Person>)personRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id ,@RequestBody Person p){
       if(personRepository.findOne(id) != null) {
            return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
        } else
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);

    }
    @DeleteMapping("/people/{id}")

    public void DeletePerson(@PathVariable int id){
       // @ResponseStatus(HttpStatus.NO_CONTENT);
        personRepository.delete(id);


    }
}
