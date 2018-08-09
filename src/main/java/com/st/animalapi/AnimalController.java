package com.st.animalapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private List<Animal> animalList = new ArrayList<>();
 
    AnimalController() {
    	Animal entity = new Animal();
    	entity.setId("1");
    	entity.setName("Fish");
    	animalList.add(entity);
    }
    @RequestMapping("/")
    public List<Animal> findAll() {
        return animalList;
    }
 
    @PostMapping(value = "/")
    public Animal addEntity(@RequestBody Animal entity) {
        animalList.add(entity);
        return entity;
    }
 
    @RequestMapping("/{id}")
    public Animal findById(@PathVariable String id) {
        return animalList.stream().
                 filter(entity -> entity.getId().equals(id)).
                   findFirst().get();
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        Animal animal = animalList.stream().
                 filter(entity -> entity.getId().equals(id)).
                   findFirst()
                   .get();
        animalList.remove(animal);
    }
    
    
}