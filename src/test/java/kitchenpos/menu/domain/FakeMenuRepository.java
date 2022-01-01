package kitchenpos.menu.domain;

import java.util.*;
import java.util.stream.Collectors;

public class FakeMenuRepository implements MenuRepository {
    private Map<Long, Menu> map = new HashMap<>();
    private Long menuKey = 1L;
    private Long menuProductKey = 1L;

    @Override
    public Menu save(Menu inputMenu) {
        Menu menu = new Menu(menuKey, inputMenu.getName(), inputMenu.toBigDecimal(), inputMenu.getMenuGroup(), createMenuProductList(inputMenu));
        map.put(menuKey, menu);
        menuKey++;
        return menu;
    }

    private List<MenuProduct> createMenuProductList(Menu inputMenu) {
        List<MenuProduct> menuProducts = new ArrayList<>();
        Menu menu = new Menu(menuKey, inputMenu.getName(), inputMenu.toBigDecimal(), inputMenu.getMenuGroup(), inputMenu.getMenuProducts());

        for (MenuProduct inputMenuProduct : inputMenu.getMenuProducts()) {
            MenuProduct menuProduct = new MenuProduct(menuProductKey, menu, inputMenuProduct.getProduct(), inputMenuProduct.getQuantity());
            menuProducts.add(menuProduct);
            menuProductKey++;
        }
        return menuProducts;
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public long countByIdIn(List<Long> ids) {
        return map.entrySet().stream()
                .filter(entry -> ids.contains(entry.getKey()))
                .distinct()
                .count();
    }

    @Override
    public List<Menu> findAllByIdIn(List<Long> ids) {
        return map.values()
                .stream()
                .filter(menu -> ids.contains(menu.getId()))
                .collect(Collectors.toList());
    }
}
