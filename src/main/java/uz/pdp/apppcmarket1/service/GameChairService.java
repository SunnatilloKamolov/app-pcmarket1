package uz.pdp.apppcmarket1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.Computer;
import uz.pdp.apppcmarket1.entity.GameChair;
import uz.pdp.apppcmarket1.payload.ComputerDto;
import uz.pdp.apppcmarket1.payload.GameChairDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.repository.CategoryRepository;
import uz.pdp.apppcmarket1.repository.ComputerRepository;
import uz.pdp.apppcmarket1.repository.GameChairRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameChairService {
    @Autowired
    GameChairRepository gameChairRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<GameChair> getGameChairs() {
        List<GameChair> gameChairs = gameChairRepository.findAll();
        return gameChairs;
    }

    public GameChair getGameChairById(Integer id) {
        Optional<GameChair> optionalGameChair = gameChairRepository.findById(id);
        return optionalGameChair.orElse(null);
    }

    public Result addGamaChair(GameChairDto gameChairDto) {
        boolean existsByName = gameChairRepository.existsByName(gameChairDto.getName());
        if (existsByName)
            return new Result("GameChair already exist",false);
        Category category = new Category();
        category.setName(gameChairDto.getName());
        Category savedCategory = categoryRepository.save(category);
        GameChair gameChair=new GameChair();
        gameChair.setColor(gameChairDto.getColor());
        gameChair.setLoad(gameChairDto.getLoad());
        gameChair.setWeight(gameChairDto.getWeight());
        gameChair.setSize(gameChairDto.getSize());
        gameChair.setFrameMaterial(gameChairDto.getFrameMaterial());
        gameChair.setForPeopleLength(gameChairDto.getForPeopleLength());
        gameChair.setGasLiftClass(gameChairDto.getGasLiftClass());
        gameChair.setMovementType(gameChairDto.getMovementType());
        gameChair.setCategory(savedCategory);
        gameChairRepository.save(gameChair);
        return new Result("GameChair added",true);
    }   public Result editGameChair(GameChairDto gameChairDto,Integer id){
        Optional<GameChair> optionalGameChair= gameChairRepository.findById(id);
        if (!optionalGameChair.isPresent())
            return new Result("GameChair not found",false);
        GameChair gameChair=optionalGameChair.get();
        gameChair.setColor(gameChairDto.getColor());
        gameChair.setLoad(gameChairDto.getLoad());
        gameChair.setWeight(gameChairDto.getWeight());
        gameChair.setSize(gameChairDto.getSize());
        gameChair.setFrameMaterial(gameChairDto.getFrameMaterial());
        gameChair.setForPeopleLength(gameChairDto.getForPeopleLength());
        gameChair.setGasLiftClass(gameChairDto.getGasLiftClass());
        gameChair.setMovementType(gameChairDto.getMovementType());
        gameChair.setCategory(gameChair.getCategory());
        gameChairRepository.save(gameChair);

        return new Result("GameChair edited",true);
    }   public Result deleteGameChair(Integer id){
        gameChairRepository.deleteById(id);
        return new Result("GameChair deleted",true);
    }
}
