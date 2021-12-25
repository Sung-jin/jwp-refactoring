package kitchenpos.menu.dto;

import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.Price;

import java.util.List;
import java.util.stream.Collectors;

public class MenuResponse {
    private Long id;
    private String name;
    private Price price;
    private String menuGroupName;
    private List<MenuProductResponse> menuProducts;

    public MenuResponse(Long id, String name, Price price, String menuGroupName, List<MenuProductResponse> menuProducts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.menuGroupName = menuGroupName;
        this.menuProducts = menuProducts;
    }

    public static MenuResponse of(Menu menu) {
        return new MenuResponse(
                menu.getId(),
                menu.getName(),
                menu.getPrice(),
                menu.getMenuGroup().getName(),
                menu.getMenuProducts().stream()
                        .map(MenuProductResponse::of)
                        .collect(Collectors.toList()));
    }

    public static List<MenuResponse> ofList(List<Menu> menus) {
        return menus.stream()
                .map(MenuResponse::of)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public String getMenuGroupName() {
        return menuGroupName;
    }

    public List<MenuProductResponse> getMenuProducts() {
        return menuProducts;
    }
}
