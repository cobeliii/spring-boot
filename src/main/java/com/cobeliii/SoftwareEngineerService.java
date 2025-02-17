package com.cobeliii;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
       return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void deleteSoftwareEngineer(Integer engineerId) {
        softwareEngineerRepository.deleteById(engineerId);
    }

    public void updateSoftwareEngineer(Integer engineerId, @RequestBody SoftwareEngineer engineer) {
        SoftwareEngineer softwareEngineer = getSoftwareEngineerById(engineerId);
        if (softwareEngineer == null) {
            throw new IllegalStateException("SoftwareEngineer not found");
        }

        softwareEngineer.setName(engineer.getName());
        softwareEngineer.setTechStack(engineer.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }
}
