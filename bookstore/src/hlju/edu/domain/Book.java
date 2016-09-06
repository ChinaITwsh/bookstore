package hlju.edu.domain;

public class Book {
	private String id;
	private String name;
	private Double price;
	private String auth;
	private String img;
	private Double rebate;//折扣
	private Integer stock;//进货
	private String publisher;
	private String publishdate;
	private Integer pages;
	private Integer size;
	private Integer printtimes;
	private Integer versions;
	private String brief;//摘要
	private String content;
	private String onlinetime;
	
	private Integer sum;//买入的数量
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	private Double currentPrice;//现价


	public void setOnlinetime(String onlinetime) {
		this.onlinetime = onlinetime;
	}

	public String getOnlinetime() {
		return onlinetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getRebate() {
		return rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPrinttimes() {
		return printtimes;
	}

	public void setPrinttimes(Integer printtimes) {
		this.printtimes = printtimes;
	}

	public Integer getVersions() {
		return versions;
	}

	public void setVersions(Integer versions) {
		this.versions = versions;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", auth=" + auth + ", img=" + img + ", rebate=" + rebate
				+ ", stock=" + stock + ", publisher=" + publisher
				+ ", publishdate=" + publishdate + ", pages=" + pages
				+ ", size=" + size + ", printtimes=" + printtimes
				+ ", versions=" + versions + ", brief=" + brief + ", content="
				+ content + ", onlinetime=" + onlinetime + ", currentPrice="
				+ currentPrice + "]";
	}

}
