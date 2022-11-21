package profit.sgr.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ForeignKey;

@Getter
@Setter
@Entity
public class Entries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonIgnore
    private Long id;

    private Double inversion;
    // private Long cantidad;
    // private Long total;
    private Long rentabilidad;
    private Double profit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="divisa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="FK_Entries_DIVISA"))
    })
    private Divisa divisa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="session_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="FK_Entries_Session"))
    })
    private Session session;
}
