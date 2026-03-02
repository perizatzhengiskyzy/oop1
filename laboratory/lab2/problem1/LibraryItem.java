package problem1;


abstract class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    
    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    
    public abstract String getItemType();
    
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear;
    }
}

