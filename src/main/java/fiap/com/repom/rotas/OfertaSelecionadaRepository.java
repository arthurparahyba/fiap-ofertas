package fiap.com.repom.rotas;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ofertaSelecionada", path = "ofertaSelecionada")
public interface OfertaSelecionadaRepository  extends PagingAndSortingRepository<OfertaSelecionada, Long> {
}
