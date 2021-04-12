package com.estacionamento.estacionamentoapi.services;

import com.estacionamento.estacionamentoapi.models.VeiculoModel;
import com.estacionamento.estacionamentoapi.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoService(){
    }

    public VeiculoModel saveVeiculo(VeiculoModel veiculoModel) {
        veiculoModel.setCreated(LocalDateTime.now());
        return veiculoRepository.save(veiculoModel);
    }


    public List<VeiculoModel> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public List<VeiculoModel> getVeiculosFind(String parametro) {
        return veiculoRepository.findByparametro(parametro);
    }

    public VeiculoModel findById(long id) {
        return veiculoRepository.findAllById(id);

    }

    public VeiculoModel update(VeiculoModel veiculoModel) {
        Optional<VeiculoModel> veiculoModelAntigo = veiculoRepository.findById(veiculoModel.getId());
        veiculoModelAntigo.get().setVeiculo(veiculoModel.getVeiculo());
        veiculoModelAntigo.get().setAno(veiculoModel.getAno());
        veiculoModelAntigo.get().setDescricao(veiculoModel.getDescricao());
        veiculoModelAntigo.get().setMarca(veiculoModel.getMarca());
        veiculoModelAntigo.get().setVendido(veiculoModel.isVendido());
        veiculoModelAntigo.get().setUpdated(LocalDateTime.now());
        return veiculoRepository.save(veiculoModelAntigo.get());
    }

    public void delete(VeiculoModel veiculoModel) {
        veiculoRepository.deleteById(veiculoModel.getId());
    }

    public String getNaoVendidos(String vendido) {
        vendido = "false";
        int count =  veiculoRepository.findByVendido(vendido);
        return "O valor de Veículos não vendido é: " + count;


    }

    public String getTotByMarca(String marca) {
        int count = veiculoRepository.findByMarca(marca);
        return marca + " -> " + count;
    }

    public List<VeiculoModel> findByDate7() {
        return veiculoRepository.findBy7();



    }

    public List<String> findByDecade() {
        return  veiculoRepository.findByDecade();
    }
}
