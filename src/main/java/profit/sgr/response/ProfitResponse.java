package profit.sgr.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfitResponse {
    Double inversion;
    Long rentabilidad;
    Double profit;
    
    public ProfitResponse(Double inversion, Long rentabilidad, Double profit) {
        this.inversion = inversion;
        this.rentabilidad = rentabilidad;
        this.profit = profit;
    }

    
}
