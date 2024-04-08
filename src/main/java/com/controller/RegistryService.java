package com.controller;

import com.model.InputRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registery")
public class RegistryService {


    @PostMapping(path = "/saveComponent", produces = "application/json",consumes ="application/json" )
    public void saveService(@RequestBody InputRequest inputRequest){

    }

    @GetMapping
    public  InputRequest getAll(){
        InputRequest inputRequest = new InputRequest();
        inputRequest.setService("test");
        return inputRequest;
    }
}
