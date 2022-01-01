package kitchenpos.menu.domain;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends Repository<Product, Long> {
    Product save(Product entity);

    Optional<Product> findById(Long id);

    List<Product> findAllByIdIn(List<Long> ids);

    List<Product> findAll();
}
