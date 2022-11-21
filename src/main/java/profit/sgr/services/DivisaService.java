package profit.sgr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import profit.sgr.models.entity.Divisa;
import profit.sgr.models.repository.IDivisaRepository;
import profit.sgr.services.interfaces.IDivisaService;

@Service
public class DivisaService implements IDivisaService {

    @Autowired
    private IDivisaRepository divisaRepository;


    @Override
    public List<Divisa> findAll() {
        return this.divisaRepository.findAll();
    }
        
}
