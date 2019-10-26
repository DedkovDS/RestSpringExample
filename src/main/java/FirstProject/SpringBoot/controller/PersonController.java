package FirstProject.SpringBoot.controller;

import FirstProject.SpringBoot.domain.Person;
import FirstProject.SpringBoot.exeption.exeption;
import FirstProject.SpringBoot.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @PostMapping("/")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personRepo.save(person);
    }

    @GetMapping("/")
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable(value = "id") Long personId) {
        return personRepo.findById(personId)
                .orElseThrow(()->new exeption("person","id",personId));
    }
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable(value = "id") long personId,
                               @Valid @RequestBody Person personDetails) {

        Person person = personRepo.findById(personId)
                .orElseThrow(()->new exeption("person","id",personId));

        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());

        Person updatedPerson = personRepo.save(person);
        return updatedPerson;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personId) {
        Person person = personRepo.findById(personId)
                .orElseThrow(()->new exeption("person","id",personId));

        personRepo.delete(person);

        return ResponseEntity.ok().build();
    }


}
