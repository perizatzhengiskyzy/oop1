package problem1;

public class Book extends LibraryItem {
    private int numberOfPages;
    
    public Book(String title, String author, int year, int pages) {
        super(title, author, year);
        this.numberOfPages = pages;
    }
    
    @Override
    public String getItemType() {
        return "Book";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Pages: " + numberOfPages;
    }
}