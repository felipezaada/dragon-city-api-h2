package com.felipe.api_dragon_city_h2.service;

import com.felipe.api_dragon_city_h2.exceptions.EmptyRepositoryException;
import com.felipe.api_dragon_city_h2.exceptions.NotFoundIdException;
import com.felipe.api_dragon_city_h2.model.DragonModel;
import com.felipe.api_dragon_city_h2.repository.DragonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DragonService {

    private final DragonRepository dragonRepository;

    public DragonService(DragonRepository dragonRepository) {
        this.dragonRepository = dragonRepository;
    }

    public List<DragonModel> insert(List<DragonModel> dragonModel) {
        return dragonRepository.saveAll(dragonModel);
    }

    public List<DragonModel> list() {
        List<DragonModel> dragons = dragonRepository.findAll(Sort.by("id").ascending());
        if(dragons.isEmpty()) throw new EmptyRepositoryException();
        return dragons;
    }

    public DragonModel update(DragonModel dragonModel) {
        if (!dragonRepository.existsById(dragonModel.getId())) throw new NotFoundIdException();
        return dragonRepository.save(dragonModel);
    }

    public void delete(UUID id) {
        if (!dragonRepository.existsById(id)) throw new NotFoundIdException();
        dragonRepository.deleteById(id);
    }
}