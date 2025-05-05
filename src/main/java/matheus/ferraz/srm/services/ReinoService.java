package matheus.ferraz.srm.services;

import matheus.ferraz.srm.entities.Reino;
import matheus.ferraz.srm.repositories.ReinoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ReinoService {
    private final ReinoRepository reinoRepository;

    public ReinoService(ReinoRepository reinoRepository){
        this.reinoRepository = reinoRepository;
    }

    public List<Reino> findAllReinos(){
        return this.reinoRepository.findAll();
    }

    public Optional<Reino> findReinoById(Integer id){
        return this.reinoRepository.findById(id);
    }

    public void addReino(Reino reino){
        var save = this.reinoRepository.add(reino);
        Assert.state(save == 1, "Erro ao salvar ");
    }

    public void updateReino(Reino reino, Integer id){
        var update = this.reinoRepository.update(reino, id);
        if (update == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }

    public void deleteReino(Integer id){
        var delete = this.reinoRepository.delete(id);
        if (delete == 0){
            throw new RuntimeException("ID não encontrado");
        }
    }
}
