package uz.pdp.apppcmarket1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.Monitor;
import uz.pdp.apppcmarket1.entity.Printer;
import uz.pdp.apppcmarket1.payload.MonitorDto;
import uz.pdp.apppcmarket1.payload.PrinterDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.repository.CategoryRepository;
import uz.pdp.apppcmarket1.repository.PrinterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrinterService {
    @Autowired
    PrinterRepository printerRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Printer> getPrinter() {
        List<Printer> printers =printerRepository.findAll();
        return printers;
    }

    public Printer getPrinterById(Integer id) {
        Optional<Printer> optionalPrinter =printerRepository.findById(id);
        return optionalPrinter.orElse(null);
    }

    public Result addPrinter(PrinterDto printerDto) {
        boolean existsByName =printerRepository.existsByName(printerDto.getName());
        if (existsByName)
            return new Result("Printer already exist",false);
        Category category = new Category();
        category.setName(printerDto.getName());
        Category savedCategory = categoryRepository.save(category);
        Printer printer=new Printer();
        printer.setTechnology(printerDto.getTechnology());
        printer.setDeviceFeatures(printerDto.getDeviceFeatures());
        printer.setBrand(printerDto.getBrand());
        printer.setMaxFormat(printerDto.getMaxFormat());
        printer.setPrintColor(printerDto.getPrintColor());
        printer.setTwoSpeedPrinting(printerDto.getTwoSpeedPrinting());
        printer.setCategory(savedCategory);
        printerRepository.save(printer);
        return new Result("Printer added",true);
    }   public Result editPrinter(PrinterDto printerDto,Integer id){
        Optional<Printer> optionalPrinter = printerRepository.findById(id);
        if (!optionalPrinter.isPresent())
            return new Result("Printer not found",false);
            Printer printer=optionalPrinter.get();
        printer.setTechnology(printerDto.getTechnology());
        printer.setDeviceFeatures(printerDto.getDeviceFeatures());
        printer.setBrand(printerDto.getBrand());
        printer.setMaxFormat(printerDto.getMaxFormat());
        printer.setPrintColor(printerDto.getPrintColor());
        printer.setTwoSpeedPrinting(printerDto.getTwoSpeedPrinting());
        printer.setCategory(printer.getCategory());
        printerRepository.save(printer);

        return new Result("Printer edited",true);
    }   public Result deletePrinter(Integer id){
        printerRepository.deleteById(id);
        return new Result("Printer deleted",true);
    }
}
