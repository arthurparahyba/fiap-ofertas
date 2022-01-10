package fiap.com.repom.rotas;

import fiap.com.repom.ofertas.Oferta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rotas", path = "rotas")
public interface RotaRepository extends PagingAndSortingRepository<Rota, Long> {
}
