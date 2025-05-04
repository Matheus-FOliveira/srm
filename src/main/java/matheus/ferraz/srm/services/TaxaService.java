package matheus.ferraz.srm.services;

import matheus.ferraz.srm.entities.Taxa;
import matheus.ferraz.srm.repositories.TaxaRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class TaxaService {
    private final TaxaRepository taxaRepository;

    public TaxaService(TaxaRepository taxaRepository){
        this.taxaRepository = taxaRepository;
    }

    public List<Taxa> findAllTaxas(){
        return this.taxaRepository.findAll();
    }

    public Optional<Taxa> findTaxaById(Integer id){
        return this.taxaRepository.findById(id);
    }

    public Optional<Taxa> getCurrent(){
        return this.taxaRepository.getCurrent();
    }

    public void addTaxa(Taxa taxa){
        var save = this.taxaRepository.add(taxa);
        Assert.state(save == 1, "Erro ao salvar ");
    }

    public void updateTaxa(Taxa taxa, Integer id){
        var update = this.taxaRepository.update(taxa, id);
        if (update == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public void deleteTaxa(Integer id){
        var delete = this.taxaRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }
}
