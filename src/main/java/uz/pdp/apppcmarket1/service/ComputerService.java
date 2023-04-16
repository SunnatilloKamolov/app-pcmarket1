package uz.pdp.apppcmarket1.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.Computer;
import uz.pdp.apppcmarket1.payload.ComputerDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.repository.CategoryRepository;
import uz.pdp.apppcmarket1.repository.ComputerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Computer> getComputers() {
        List<Computer> computers = computerRepository.findAll();
        return computers;
    }

    public Computer getComputerById(Integer id) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        return optionalComputer.orElse(null);
    }

    public Result addComputer(ComputerDto computerDto) {
        boolean existsByName = computerRepository.existsByName(computerDto.getName());
        if (existsByName)
            return new Result("Computer already exist",false);
        Category category = new Category();
        category.setName(computerDto.getName());
        Category savedCategory = categoryRepository.save(category);
        Computer computer = new Computer();
        computer.setCpu(computer.getCpu());
        computer.setFrame(computer.getFrame());
        computer.setRam(computer.getRam());
        computer.setSsd(computer.getSsd());
        computer.setMotherBoard(computerDto.getMotherBoard());
        computer.setPowerSupply(computerDto.getPowerSupply());
        computer.setOperationSystem(computer.getOperationSystem());
        computer.setCollingSystem(computerDto.isCollingSystem());
        computer.setCategory(savedCategory);
        computerRepository.save(computer);
        return new Result("Computer added",true);
    }   public Result editComputer(ComputerDto computerDto,Integer id){
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        if (!optionalComputer.isPresent())
            return new Result("Computer not found",false);
        Computer computer=optionalComputer.get();
        computer.setCpu(computerDto.getCpu());
        computer.setFrame(computerDto.getFrame());
        computer.setRam(computerDto.getRam());
        computer.setSsd(computerDto.getSsd());
        computer.setMotherBoard(computerDto.getMotherBoard());
        computer.setPowerSupply(computerDto.getPowerSupply());
        computer.setOperationSystem(computerDto.getOperationSystem());
        computer.setCollingSystem(computerDto.isCollingSystem());
        computer.setCategory(computer.getCategory());
        computerRepository.save(computer);
        return new Result("Computer edited",true);
    }   public Result deleteComputer(Integer id){
        computerRepository.deleteById(id);
        return new Result("Computer deleted",true);
    }

}
