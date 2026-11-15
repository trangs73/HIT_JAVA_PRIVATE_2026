package model;

public class Book extends Product {
    private String author;

    public Book(String id, String name, double price, int stock, String author) {
        super(id, name, price, stock);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return getName() + " - Tác giả: " + author;
    }
}
