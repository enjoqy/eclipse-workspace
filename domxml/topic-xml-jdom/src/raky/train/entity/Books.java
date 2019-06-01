package raky.train.entity;

public class Books {

	private int id;
	
	private String name;
	
	private String author;
	
	private String memo;
	
	public Books() {
		
	}

	public Books(int id, String name, String author, String memo) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.memo = memo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", memo=" + memo + "]";
	}
	
}
