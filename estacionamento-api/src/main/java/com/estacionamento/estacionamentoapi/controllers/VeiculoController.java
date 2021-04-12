package com.estacionamento.estacionamentoapi.controllers;


import com.estacionamento.estacionamentoapi.models.VeiculoModel;
import com.estacionamento.estacionamentoapi.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("")
    public ResponseEntity<VeiculoModel> save(@RequestBody VeiculoModel veiculoModel){
        VeiculoModel veiculoResponse = veiculoService.saveVeiculo(veiculoModel);
        return ResponseEntity.ok()
                .body(veiculoResponse);
    }

    @GetMapping("")
    public  ResponseEntity<List<VeiculoModel>> getAll(){
        List<VeiculoModel> veiculoResponse = veiculoService.getAllVeiculos();
        return  ResponseEntity.ok()
                .body(veiculoResponse);
    }

    @GetMapping("/estoque")
    public ResponseEntity<String> estoque(){
        String vendido = "false";
        String result = veiculoService.getNaoVendidos(vendido);
        return  ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/findmarca/{marca}")
    public ResponseEntity<String> findByMarca(@PathVariable String marca){
        String result = veiculoService.getTotByMarca(marca);
        return  ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("findlastweek")
    public ResponseEntity<List<VeiculoModel>> findAllLastWeek(){
        List <VeiculoModel> veiculoResponse = veiculoService.findByDate7();
        return  ResponseEntity.ok()
                .body(veiculoResponse);
    }

    @GetMapping("decade")
    public ResponseEntity<List<String>> listDecade(){
        List <String> result = veiculoService.findByDecade();
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/find/{parametro}")
    public ResponseEntity<List<VeiculoModel>> getFind(@PathVariable String parametro){
        List<VeiculoModel> veiculoResponse = veiculoService.getVeiculosFind(parametro);
        return ResponseEntity.ok()
                .body(veiculoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> findById(@PathVariable long id){
        VeiculoModel veiculoResponse = veiculoService.findById(id);
        return ResponseEntity.ok()
                .body(veiculoResponse);
    }

    @PutMapping("")
    public ResponseEntity<VeiculoModel> update(@RequestBody VeiculoModel veiculoModel){
        VeiculoModel veiculoResponse = veiculoService.update(veiculoModel);
        return ResponseEntity.ok()
                .body(veiculoResponse);
    }

    @DeleteMapping("")
    public void delete(@RequestBody VeiculoModel veiculoModel){
        veiculoService.delete(veiculoModel);
    }

}

