package hu.unideb.inf.fs_backend.controller;

import hu.unideb.inf.fs_backend.model.Person;
import hu.unideb.inf.fs_backend.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPersons(){
        List<Person> all = personRepository.findAll();
        return all;
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable long id){
        personRepository.deleteById(id);
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable long id){
        Optional<Person> person_opt = personRepository.findById(id);
        if (person_opt.isPresent())
            return person_opt.get();
        else return new Person();
    }
}
