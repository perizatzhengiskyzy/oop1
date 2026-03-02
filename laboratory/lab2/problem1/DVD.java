package problem1;

public class DVD extends LibraryItem {
    private int duration;
    private String director;
    
    public DVD(String title, String author, int year, int duration, String director) {
        super(title, author, year);
        this.duration = duration;
        this.director = director;
    }
    
    @Override
    public String getItemType() {
        return "DVD";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " min, Director: " + director;
    }
}