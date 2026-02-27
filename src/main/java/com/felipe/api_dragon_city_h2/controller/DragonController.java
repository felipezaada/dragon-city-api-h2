package com.felipe.api_dragon_city_h2.controller;

import com.felipe.api_dragon_city_h2.model.DragonModel;
import com.felipe.api_dragon_city_h2.service.DragonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DragonController {

    private final DragonService dragonService;

    public DragonController(DragonService dragonService) {
        this.dragonService = dragonService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> buscarDragoes(){
        List<DragonModel> dragons = dragonService.list();
        return ResponseEntity.ok(dragons);
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserir(@RequestBody @Valid List<DragonModel> dragonModel) {
        List<DragonModel> dragons = dragonService.insert(dragonModel);
        return ResponseEntity.ok(dragons);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizar(@RequestBody @Valid DragonModel dragonModel) {
        DragonModel dragons = dragonService.update(dragonModel);
        return ResponseEntity.ok(dragons);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<?> excluir(@PathVariable UUID id){
        dragonService.delete(id);
        return ResponseEntity.ok("Dragão removido com sucesso!");
    }
}