package uz.pdp.apppcmarket1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket1.entity.Computer;
import uz.pdp.apppcmarket1.payload.ComputerDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/api/computer")
public class ComputerController {
    @Autowired
    ComputerService computerService;
    @GetMapping
    List<Computer>getComputers(){
        List<Computer> computers = computerService.getComputers();
        return computers;
    }@GetMapping("/{id}")
    public Computer getComputerById(@PathVariable Integer id){
         return computerService.getComputerById(id);
    }@PostMapping
    public Result addComputer(@RequestBody ComputerDto computerDto){
        computerService.addComputer(computerDto);
        return new Result("Computer added",true);
    }@PutMapping("/{id}")
    public Result editComputer(@PathVariable Integer id,@RequestBody ComputerDto computerDto){
        computerService.editComputer(computerDto,id);
        return new Result("computer edited",true);
    }@DeleteMapping("/{id}")
    public Result deleteComputer(@PathVariable Integer id){
        computerService.deleteComputer(id);
        return new Result("computer deleted",true);
    }
}
