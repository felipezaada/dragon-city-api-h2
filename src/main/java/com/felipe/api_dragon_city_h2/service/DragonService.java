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

    public List<DragonModel> insert(DragonModel dragonModel) {
        dragonRepository.save(dragonModel);
        return list();
    }

    public List<DragonModel> list() {
        List<DragonModel> dragons = dragonRepository.findAll(Sort.by("id").ascending());
        if(dragons.isEmpty()) throw new EmptyRepositoryException();
        return dragons;
    }

    public List<DragonModel> update(DragonModel dragonModel) {
        if(dragonRepository.findById(dragonModel.getId()).isEmpty()) throw new NotFoundIdException();
        dragonRepository.save(dragonModel);
        return list();
    }

    public void delete(UUID id) {
        if(dragonRepository.findById(id).isEmpty()) throw new NotFoundIdException();
        dragonRepository.deleteById(id);
    }
}
