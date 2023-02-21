package com.labspring.web.controller;

import com.labspring.web.model.Example;
import com.labspring.web.service.ServiceExample;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    //    Another option to inject the ServiceExample Service Bean is with Autowired annotation:
//    @Autowired
    ServiceExample serviceExample;

    //    Use the MainController constructor to inject the ServiceExample Service Bean:
    public MainController(ServiceExample serviceExample) {
        this.serviceExample = serviceExample;
    }


    @GetMapping("examples")
    public List<Example> getExamples() {
        return serviceExample.getExamples();
    }

    // To get the id from url: example?id=33
    @GetMapping("example")
    public Example getExampleRequestParam(@RequestParam("id") int id){
        return serviceExample.getExample(id);
    }

    // To get the id from path: example/33
    @GetMapping("example/{id}")
    public Example getExamplePathVariable(@PathVariable("id") int id){
        return serviceExample.getExample(id);
    }


    @PostMapping("example")
    public Example createExample(@RequestBody Example example) {
        return serviceExample.createExample(example);
    }

}
