package com.example.demouserproject.service;

import com.example.demouserproject.model.Ad;
import com.example.demouserproject.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdService {

    AdRepository adRepository;

    @Transactional
    public Ad create(Ad ad){
        return adRepository.save(ad);
    }

    @Transactional
    public Ad findByID(UUID id){
        return adRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Transactional
    public List<Ad> findAll(){
        return adRepository.findAll();
    }

    @Transactional
    public Ad update(Ad ad){
        if (adRepository.existsById(ad.getId())) {
            adRepository.save(ad);
            return adRepository.getById(ad.getId());
        }
        else throw new ResourceNotFoundException(ad.getId().toString());
    }

    @Transactional
    public void delete(UUID id){
        if (adRepository.existsById(id)){
            Ad ad = adRepository.getById(id);
            adRepository.delete(ad);
        }
        else throw new ResourceNotFoundException(id.toString());
    }

}
