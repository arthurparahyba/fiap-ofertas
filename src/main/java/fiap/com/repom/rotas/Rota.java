package fiap.com.repom.rotas;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="APP_ROTA")
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long idRota;

    @OneToMany(mappedBy = "rota")
    private List<OfertaSelecionada> ofertasSelecionada;
}
