package com.example.Sprint4.services;

import com.example.Sprint4.DTO.InsumoDTO;
import com.example.Sprint4.entities.ArticuloInsumo;
import com.example.Sprint4.repositories.ArticuloInsumoRepository;
import com.example.Sprint4.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo,Long>  implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }

    public List<ArticuloInsumo> busquedaPorDenominacionIns(String filtro) throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = this.articuloInsumoRepository.busquedaPorDenominacionIns(filtro);
            return articuloInsumos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloInsumo> nuevoInsumo(ArticuloInsumo articuloInsumo) throws Exception {
        try{
            List<ArticuloInsumo> insumosEncontrados = articuloInsumoRepository.busquedaPorDenominacionIns(articuloInsumo.getDenominacion());
            if (insumosEncontrados.isEmpty()){
                articuloInsumoRepository.save(articuloInsumo);
                return (List<ArticuloInsumo>) articuloInsumo;
            }else {
                throw new Exception("Este insumo ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<InsumoDTO> bajoStock() throws Exception {
        try{
            List<InsumoDTO> insumos = articuloInsumoRepository.bajoStock();
            return insumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloInsumo> verificarFechaBajaIngrediente() throws Exception {
        try{
            List<ArticuloInsumo> insumosEncontrados = articuloInsumoRepository.verificarFechaBajaIngrediente();
            if (insumosEncontrados.isEmpty()){
                throw new Exception("No hay insumos disponibles");
            }else {
                return insumosEncontrados;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
