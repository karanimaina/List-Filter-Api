package com.example.alex.controller;

import com.example.alex.service.FilterService;
import com.example.alex.wrappers.Total;
import com.example.alex.wrappers.UniversalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/selected")
public class Controller{
    private final FilterService filterService;
    @GetMapping("/get")
     ResponseEntity<UniversalResponse>getAllEntities(){
        return filterService.getAllSelected();
    }
//    @PostMapping("/add")
//    public ResponseEntity<UniversalResponse>  addSelected(@RequestBody Total total){
//       return filterService.filter(total);
//    }
}
