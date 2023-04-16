package uz.pdp.apppcmarket1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket1.entity.Laptop;
import uz.pdp.apppcmarket1.entity.Monitor;
import uz.pdp.apppcmarket1.payload.LaptopDto;
import uz.pdp.apppcmarket1.payload.MonitorDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.service.LaptopService;
import uz.pdp.apppcmarket1.service.MonitorService;

import java.util.List;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController {
    @Autowired
    MonitorService monitorService;
    @GetMapping
    List<Monitor> getMonitors(){
        List<Monitor> monitors = monitorService.getMonitor();
        return monitors;
    }@GetMapping("/{id}")
    public Monitor getMonitorById(@PathVariable Integer id){
        return monitorService.getMonitorById(id);
    }@PostMapping
    public Result addMonitor(@RequestBody MonitorDto monitorDto){
        monitorService.addMonitor(monitorDto);
        return new Result("Monitor added",true);
    }@PutMapping("/{id}")
    public Result editMonitor(@PathVariable Integer id,@RequestBody MonitorDto monitorDto){
        monitorService.editMonitor(monitorDto,id);
        return new Result("Monitor edited",true);
    }@DeleteMapping("/{id}")
    public Result deleteMonitor(@PathVariable Integer id){
        monitorService.deleteMonitor(id);
        return new Result("Monitor deleted",true);
    }
}
