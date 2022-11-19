package ooppractice.order;

import lombok.Getter;

import java.util.Objects;

@Getter
public class MenuItem {
    private final String name;

    private final int price;

    public MenuItem(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MenuItem menuItem = (MenuItem) o;
        return price == menuItem.price && Objects.equals(name, menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public boolean matches(final String name) {
        return this.name.equals(name);
    }
}
