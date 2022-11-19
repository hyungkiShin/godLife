package ooppractice.order;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking) {
        final MenuItem menuItem = menu.choose(menuName);
        final Cook cook = cooking.makeCook(menuItem);
    }
}
