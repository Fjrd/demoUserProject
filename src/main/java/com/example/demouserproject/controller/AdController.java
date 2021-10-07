package com.example.demouserproject.controller;

import com.example.demouserproject.model.Ad;
import com.example.demouserproject.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/ads")
public class AdController {

    AdService adService;

    @GetMapping()
    public List<Ad> allAds(){
        return adService.findAll();
    }

    @PostMapping
    public ResponseEntity<Ad> newAd(@RequestBody @Valid Ad ad){
        return ResponseEntity.ok(adService.create(ad));
    }

    @GetMapping("{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable UUID id){
        try{
            Ad ad = adService.findByID(id);
            return ResponseEntity.ok().body(ad);
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Ad> replaceAd(@PathVariable UUID id, @RequestBody Ad adDetails){
        try{
            Ad ad = adService.update(id, adDetails);
            return ResponseEntity.ok().body(ad);
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAdById(@PathVariable UUID id){
        try{
            adService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }
}
