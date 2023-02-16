package com.labspring.web.service;

import com.labspring.web.model.Example;

import java.util.List;

public interface ServiceExample {

    List<Example> getExamples();

    Example getExample(int id);
    Example createExample(Example example);

}
