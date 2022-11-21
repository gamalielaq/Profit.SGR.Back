package profit.sgr.services.interfaces;

import profit.sgr.models.entity.Entries;
import profit.sgr.response.ProfitResponse;

public interface IEntrie {

    public ProfitResponse getProfit(Entries entries);

}
