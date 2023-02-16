package com.labspring.web.service;

import com.labspring.web.model.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceExampleImpl implements ServiceExample{
    @Override
    public List<Example> getExamples() {
        // Here we should get the objects from a database or a data source
        List<Example> examples = new ArrayList<>();
        examples.add(new Example(1, "name x", "description x"));
        return examples;
    }

    @Override
    public Example getExample(int id){
        // Here we should get the object from a database or a data source
        return new Example(id, "name x", "description x");
    }

    @Override
    public Example createExample(Example example) {
        // Here we should insert the object in a database
        return example;
    }


}
