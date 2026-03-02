package problem1;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private String publisher;
    
    public Magazine(String title, String author, int year, int issueNumber, String publisher) {
        super(title, author, year);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
    
    @Override
    public String getItemType() {
        return "Magazine";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Issue: " + issueNumber + ", Publisher: " + publisher;
    }
}