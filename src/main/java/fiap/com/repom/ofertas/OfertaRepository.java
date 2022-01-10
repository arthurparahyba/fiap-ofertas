package fiap.com.repom.ofertas;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ofertas", path = "ofertas")
public interface OfertaRepository  extends PagingAndSortingRepository<Oferta, Long>, QuerydslPredicateExecutor<Oferta> {

}
