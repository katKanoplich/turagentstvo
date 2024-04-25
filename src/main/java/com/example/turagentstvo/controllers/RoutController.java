package com.example.turagentstvo.controllers;
import com.example.turagentstvo.entities.Rout;
import com.example.turagentstvo.services.RoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rout")
@RequiredArgsConstructor
public class RoutController {

    private final RoutService routService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Rout> getRouts() {
        return routService.getAllRouts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rout getRoutById(@PathVariable long id) {
        return routService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rout addRout(@RequestBody Rout rout) {
        return routService.addRout(rout);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delRout(@PathVariable long id) {
        routService.deleteRout(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rout updateRout(@PathVariable long id,@RequestBody Rout rout) {
        return routService.updateRout(id, rout);
    }
}
