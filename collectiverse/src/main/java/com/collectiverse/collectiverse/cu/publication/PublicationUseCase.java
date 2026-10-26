package com.collectiverse.collectiverse.cu.publication;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collectiverse.collectiverse.cu.product.exception.ProductNotFoundException;
import com.collectiverse.collectiverse.cu.publication.exception.PublicationNotFoundException;
import com.collectiverse.collectiverse.cu.publication.request.RequestPublication;
import com.collectiverse.collectiverse.cu.publication.request.RequestPublication.RequestPublicationExchange;
import com.collectiverse.collectiverse.cu.publication.response.ResponsePublication;
import com.collectiverse.collectiverse.cu.publication.response.ResponsePublication.ResponsePublicationExchange;
import com.collectiverse.collectiverse.dominio.entity.Product;
import com.collectiverse.collectiverse.dominio.entity.Publication;
import com.collectiverse.collectiverse.dominio.repository.RepoProduct;
import com.collectiverse.collectiverse.dominio.repository.RepoPublication;

/** Caso de uso: consultar y registrar Publication. */
@Service
public class PublicationUseCase {

    private final RepoPublication repository;
    private final RepoProduct repoProduct;

    public PublicationUseCase(RepoPublication repository, RepoProduct repoProduct) {
        this.repository = repository;
        this.repoProduct = repoProduct;
    }

    @Transactional(readOnly = true)
    public List<ResponsePublication> listar() {
        return repository.findAll().stream().map(this::aResponse).toList();
    }

    @Transactional(readOnly = true)
    public ResponsePublication consultar(Integer id) {
        return aResponse(repository.findById(id)
                .orElseThrow(() -> new PublicationNotFoundException(id)));
    }

    @Transactional
    public ResponsePublication registrar(RequestPublication request, String usuario) {
        // El producto publicado debe existir
        Product product = repoProduct.findById(request.idProduct())
                .orElseThrow(() -> new ProductNotFoundException(request.idProduct()));
        Publication p = new Publication();
        p.setUsername(usuario); // dueño de la publicación
        p.setProduct(product);
        p.setTitle(request.title());
        p.setDescription(request.description());
        p.setType(request.type());
        p.setState(request.state());
        p.setCreatedBy(usuario);
        // Agrega los intercambios solicitados, si los hay
        if (request.exchanges() != null) {
            for (RequestPublicationExchange item : request.exchanges()) {
                p.addExchange(item.requestedName(), item.description(), item.quantity());
            }
        }
        // Los intercambios nuevos también necesitan createdBy (campo obligatorio)
        p.getExchanges().forEach(x -> x.setCreatedBy(usuario));
        return aResponse(repository.save(p));
    }

    // Convierte la entidad en el Response que ve el cliente
    private ResponsePublication aResponse(Publication e) {
        return new ResponsePublication(e.getId(), e.getUsername(), e.getProduct().getId(), e.getTitle(),
                e.getDescription(), e.getType(), e.getState(), e.getDate(),
                e.getExchanges().stream()
                        .map(x -> new ResponsePublicationExchange(x.getId(), x.getRequestedName(),
                                x.getDescription(), x.getQuantity()))
                        .toList(),
                e.getStatus());
    }
}
