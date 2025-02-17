package com.cobeliii;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getSoftwareEngineers();
    }


    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable("id") Integer engineerId) {
        return softwareEngineerService.getSoftwareEngineerById(engineerId);
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer(@PathVariable("id") Integer engineerId) {
        softwareEngineerService.deleteSoftwareEngineer(engineerId);
    }

    @PutMapping({"{id}"})
    public void updateSoftwareEngineer(@PathVariable("id") Integer engineerId, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineer(engineerId, softwareEngineer);
    }


}
