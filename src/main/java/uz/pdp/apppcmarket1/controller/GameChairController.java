package uz.pdp.apppcmarket1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket1.entity.Computer;
import uz.pdp.apppcmarket1.entity.GameChair;
import uz.pdp.apppcmarket1.payload.ComputerDto;
import uz.pdp.apppcmarket1.payload.GameChairDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.service.GameChairService;

import java.util.List;

@RestController
@RequestMapping("api/gameChair")
public class GameChairController {
    @Autowired
    GameChairService gameChairService;
    @GetMapping
    List<GameChair> getGameChair(){
        List<GameChair> GameChairs = gameChairService.getGameChairs();
        return GameChairs;
    }@GetMapping("/{id}")
    public GameChair getGameChairById(@PathVariable Integer id){
        return gameChairService.getGameChairById(id);
    }@PostMapping
    public Result addGameChair(@RequestBody GameChairDto gameChairDto){
       gameChairService.addGamaChair(gameChairDto);
        return new Result("GameChair added",true);
    }@PutMapping("/{id}")
    public Result editGameChair(@PathVariable Integer id,@RequestBody GameChairDto gameChairDto){
        gameChairService.editGameChair(gameChairDto,id);
        return new Result("GameChair edited",true);
    }@DeleteMapping("/{id}")
    public Result deleteGameChair(@PathVariable Integer id){
       gameChairService.deleteGameChair(id);
        return new Result("GameChair deleted",true);
    }
}
