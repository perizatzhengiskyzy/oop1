package practice5;

import java.io.Serializable;

public class Book implements Serializable{
	private String title;
	private String author;
	transient int visitCount;
	
	Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.visitCount = 0;
    }
	 
	public String getInfo() {
		return "Author: " + author + ". Title: " + title;
	}
	
	public String getAuthor() {
		return "Author: " + author;
	}
	public String getTitle() {
		return "Title: " + title;
	}
	public void increment() {
		this.visitCount++;
	}
	@Override
	public String toString() {
		return this.getInfo();
	}
	
}
