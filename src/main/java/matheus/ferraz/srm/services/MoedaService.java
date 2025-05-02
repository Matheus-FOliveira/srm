package matheus.ferraz.srm.services;

import matheus.ferraz.srm.entities.Moeda;
import matheus.ferraz.srm.repositories.MoedaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class MoedaService {
    private final MoedaRepository moedaRepository;

    public MoedaService(MoedaRepository moedaRepository){
        this.moedaRepository = moedaRepository;
    }

    public List<Moeda> findAllMoedas(){
        return this.moedaRepository.findAll();
    }

    public Optional<Moeda> findMoedaById(Integer id){
        return this.moedaRepository.findById(id);
    }

    public void addMoeda(Moeda moeda){
        var save = this.moedaRepository.add(moeda);
        Assert.state(save == 1, "Erro ao salvar ");
    }

    public void updateMoeda(Moeda moeda, Integer id){
        var update = this.moedaRepository.update(moeda, id);
        if (update == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public void deleteMoeda(Integer id){
        var delete = this.moedaRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }
}
