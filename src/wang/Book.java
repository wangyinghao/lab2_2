package wang;

public class Book {
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private String PublishDate;
	private float Price;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}
	public String getTitle() {
		return this.Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public int getAuthorID() {
		return this.AuthorID;
	}
	public void setAuthorID(int authorID) {
		this.AuthorID = authorID;
	}
	public String getPublisher() {
		return this.Publisher;
	}
	public void setPublisher(String publisher) {
		this.Publisher = publisher;
	}
	public String getPublishDate() {
		return this.PublishDate;
	}
	public void setPublishDate(String publishDate) {
		this.PublishDate = publishDate;
	}
	public float getPrice() {
		return this.Price;
	}
	public void setPrice(float price) {
		this.Price = price;
	}
}
