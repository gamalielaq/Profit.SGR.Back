package profit.sgr.services;

import org.springframework.stereotype.Service;

import profit.sgr.models.entity.Entries;
import profit.sgr.response.ProfitResponse;
import profit.sgr.services.interfaces.IEntrie;

@Service
public class EntrieService implements IEntrie {

    @Override
    public ProfitResponse getProfit(Entries entries) {
        Double profit = (entries.getInversion() * entries.getRentabilidad())/100;
        ProfitResponse entrieResponse = new ProfitResponse(entries.getInversion(), entries.getRentabilidad(), profit);
        return entrieResponse;
    }
    
}
