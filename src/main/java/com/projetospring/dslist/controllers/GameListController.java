package com.projetospring.dslist.controllers;

import com.projetospring.dslist.DTO.GameDTO;
import com.projetospring.dslist.DTO.GameListDTO;
import com.projetospring.dslist.DTO.GameMinDTO;
import com.projetospring.dslist.DTO.ReplacementDTO;
import com.projetospring.dslist.entities.GameList;
import com.projetospring.dslist.service.GameListService;
import com.projetospring.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
