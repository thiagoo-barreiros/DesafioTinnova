package com.estacionamento.estacionamentoapi.repositories;

import com.estacionamento.estacionamentoapi.models.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {

    @Query( value =
            "SELECT * FROM VEICULO_MODEL vec where vec.marca = :parametro"
            , nativeQuery = true)
            List<VeiculoModel> findByparametro(@Param("parametro")
            String parametro);

    VeiculoModel findAllById(long id);

    @Query( value =
            "SELECT COUNT(*) FROM VEICULO_MODEL vec where vec.vendido <> :vendido"
            , nativeQuery = true)
            int findByVendido (@Param("vendido")
                                              String vendido);

    @Query( value =
            "SELECT COUNT(*) FROM VEICULO_MODEL vec where vec.marca = :marca"
            , nativeQuery = true)
            int findByMarca (@Param("marca")
                                    String marca);

    @Query( value =
            "SELECT * FROM VEICULO_MODEL vec where vec.CREATED > DATEADD('DAY',-7, CURRENT_DATE)"
            , nativeQuery = true)
            List<VeiculoModel> findBy7();

    @Query( value =
            "SELECT marca, count(*) FROM VEICULO_MODEL group by marca"
            , nativeQuery = true)
            List <String> findByDecade();
//    @Query( value =
//            "SELECT * FROM VEICULO_MODEL vec where vec.id= :id"
//            , nativeQuery = true)
//        VeiculoModel findById(@Param("id")
//            long id);
}
