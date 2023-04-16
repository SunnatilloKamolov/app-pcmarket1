package uz.pdp.apppcmarket1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.Laptop;
import uz.pdp.apppcmarket1.entity.Monitor;
import uz.pdp.apppcmarket1.payload.LaptopDto;
import uz.pdp.apppcmarket1.payload.MonitorDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.repository.CategoryRepository;
import uz.pdp.apppcmarket1.repository.LaptopRepository;
import uz.pdp.apppcmarket1.repository.MonitorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {
    @Autowired
    MonitorRepository monitorRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Monitor> getMonitor() {
        List<Monitor> monitors =monitorRepository.findAll();
        return monitors;
    }

    public Monitor getMonitorById(Integer id) {
        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);
        return optionalMonitor.orElse(null);
    }

    public Result addMonitor(MonitorDto monitorDto) {
        boolean existsByName =monitorRepository.existsByName(monitorDto.getName());
        if (existsByName)
            return new Result("Monitor already exist",false);
        Category category = new Category();
        category.setName(monitorDto.getName());
        Category savedCategory = categoryRepository.save(category);
        Monitor monitor=new Monitor();
        monitor.setBrand(monitorDto.getBrand());
        monitor.setScreenResolution(monitorDto.getScreenResolution());
        monitor.setMatrix(monitorDto.getMatrix());
        monitor.setResponseTime(monitorDto.getResponseTime());
        monitor.setCurvedScreen(monitorDto.isCurvedScreen());
        monitor.setDiagonalScreen(monitorDto.getDiagonalScreen());
        monitor.setScreenRefreshRate(monitorDto.getScreenRefreshRate());
        monitor.setVideoConnectors(monitorDto.getVideoConnectors());
        monitor.setCategory(savedCategory);
        monitorRepository.save(monitor);
        return new Result("Monitor added",true);
    }   public Result editMonitor(MonitorDto monitorDto,Integer id){
        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);
        if (!optionalMonitor.isPresent())
            return new Result("Monitor not found",false);
        Monitor monitor=optionalMonitor.get();
        monitor.setBrand(monitorDto.getBrand());
        monitor.setScreenResolution(monitorDto.getScreenResolution());
        monitor.setMatrix(monitorDto.getMatrix());
        monitor.setResponseTime(monitorDto.getResponseTime());
        monitor.setCurvedScreen(monitorDto.isCurvedScreen());
        monitor.setDiagonalScreen(monitorDto.getDiagonalScreen());
        monitor.setScreenRefreshRate(monitorDto.getScreenRefreshRate());
        monitor.setVideoConnectors(monitorDto.getVideoConnectors());
        monitor.setCategory(monitor.getCategory());
        monitorRepository.save(monitor);

        return new Result("Monitor edited",true);
    }   public Result deleteMonitor(Integer id){
       monitorRepository.deleteById(id);
        return new Result("Monitor deleted",true);
    }
}
