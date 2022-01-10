package fiap.com.repom.rotas;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Data
@Entity
@Table(name="APP_OFERTA_SELECIONADA")
public class OfertaSelecionada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long idOferta;

    @Column(nullable = false)
    private String cpfCaminhoneiro;

    @Column(length = 2000, nullable = false)
    private String conteudoJson;

    @ManyToOne
    @JoinColumn(name="id_rota", nullable = false)
    @RestResource(path = "rota", rel="rota")
    private Rota rota;
}
