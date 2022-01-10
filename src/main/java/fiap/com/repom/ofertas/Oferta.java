package fiap.com.repom.ofertas;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "APP_OFERTA")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long idOferta;

    @Column(nullable = false)
    private String cpfCaminhoneiro;

    @Column(nullable = false)
    private String listRotas;

    @Column(length = 2000, nullable = false)
    private String conteudoJson;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dtCriacao;

}
