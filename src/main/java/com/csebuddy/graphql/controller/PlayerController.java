package com.csebuddy.graphql.controller;

import com.csebuddy.graphql.model.Player;
import com.csebuddy.graphql.model.Team;
import com.csebuddy.graphql.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public List<Player> findAll() {
        log.info("findAll was hit");
        return playerService.findAll();
    }

    @QueryMapping
    public Optional<Player> findOne(@Argument Integer id) {
        log.info("fine one was hit");
        return playerService.findById(id);
    }

    @MutationMapping
    public Player create(@Argument String name, @Argument Team team) {
        return playerService.create(name,team);
    }

    @MutationMapping
    public Player update(@Argument Integer id, @Argument String name, @Argument Team team) {
        return playerService.update(id,name,team);
    }

    @MutationMapping
    public Player delete(@Argument Integer id) {
        return playerService.delete(id);
    }
}
