package aPIs;

import java.util.List;

public class User {

	//Define variable 
	public int page;
	public int per_page; 
	public int total; 
	public int total_pages; 
	public List <DataPOJO> data;
	public SupportPOJO support;
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<DataPOJO> getDp() {
		return data;
	}
	public void setDp(List<DataPOJO> dp) {
		this.data = data;
	}
	public SupportPOJO getSp() {
		return support;
	}
	public void setSp(SupportPOJO sp) {
		this.support = support;
	}  

}
