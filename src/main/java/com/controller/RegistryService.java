package com.controller;

import com.model.InputRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/registery")
public class RegistryService {


    @PostMapping(path = "/saveComponent", produces = "application/json",consumes ="application/json" )
    public void saveService(@RequestBody InputRequest inputRequest){

    }
}
