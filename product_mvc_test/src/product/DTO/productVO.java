package product.DTO;

public class productVO {
private Integer code=0;
private String name=null;
private Integer price =null;
private String pictureurl =null;
private String description =null;
private String pageNum ="1";	//페이지 번호
private String searchType = "";	//검색 항목
private String searchText = "";	//검색어
private int listCount = 10;		//목록페이지 게시물 노출 수
private int pagePerBlock = 10;	//목록 페이지 네비케이터 블록 
	public productVO() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {//toString 재정의 
		String str = this.code+"_____"; 
		str = this.name+"_____";
		str = this.price+"_____";		
		str = this.pictureurl+"_____";
		str = this.description+"_____";		
		return str;		
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	
}
