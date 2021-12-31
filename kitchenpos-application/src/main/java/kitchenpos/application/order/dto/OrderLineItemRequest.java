package kitchenpos.application.order.dto;

import kitchenpos.core.order.domain.OrderLineItem;

public class OrderLineItemRequest {
    private final Long menuId;
    private final long quantity;

    public OrderLineItemRequest(Long menuId, long quantity) {
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public Long getMenuId() {
        return menuId;
    }

    public long getQuantity() {
        return quantity;
    }


    public OrderLineItem toEntity() {
        return OrderLineItem.of(menuId, quantity);
    }
}
