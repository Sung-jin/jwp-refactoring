package kitchenpos.menu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kitchenpos.menu.domain.MenuProduct;

public interface MenuProductRepository extends JpaRepository<MenuProduct, Long> {

    List<MenuProduct> findAllByMenuId(Long menuId);
}
