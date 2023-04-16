package uz.pdp.apppcmarket1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket1.entity.Monitor;
import uz.pdp.apppcmarket1.entity.Printer;
import uz.pdp.apppcmarket1.payload.MonitorDto;
import uz.pdp.apppcmarket1.payload.PrinterDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.service.MonitorService;
import uz.pdp.apppcmarket1.service.PrinterService;

import java.util.List;

@RestController
@RequestMapping("/api/printer")
public class PrinterController {
    @Autowired
    PrinterService printerService;
    @GetMapping
    List<Printer> getPrinters(){
        List<Printer> printers = printerService.getPrinter();
        return printers;
    }@GetMapping("/{id}")
    public Printer getPrinterById(@PathVariable Integer id){
        return printerService.getPrinterById(id);
    }@PostMapping
    public Result addPrinter(@RequestBody PrinterDto printerDto){
        printerService.addPrinter(printerDto);
        return new Result("Printer added",true);
    }@PutMapping("/{id}")
    public Result editPrinter(@PathVariable Integer id,@RequestBody PrinterDto printerDto){
        printerService.editPrinter(printerDto,id);
        return new Result("Printer edited",true);
    }@DeleteMapping("/{id}")
    public Result deletePrinter(@PathVariable Integer id){
        printerService.deletePrinter(id);
        return new Result("Printer deleted",true);
    }
}
