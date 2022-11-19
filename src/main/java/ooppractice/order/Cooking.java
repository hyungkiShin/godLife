package ooppractice.order;

public class Cooking {

    public Cook makeCook(final MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return cook;
    }
}
