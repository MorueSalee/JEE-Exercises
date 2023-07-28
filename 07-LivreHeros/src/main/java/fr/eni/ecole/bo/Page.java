package fr.eni.ecole.bo;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private Integer pageNumber;
	private String storySection;
	private List<Page> pageList = new ArrayList<>();
	private String object;
	private boolean thief = false;

	public boolean getThief() {
		return thief;
	}

	public void setThief(boolean thief) {
		this.thief = thief;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getStorySection() {
		return storySection;
	}

	public void setStorySection(String storySection) {
		this.storySection = storySection;
	}

	public List<Page> getPageList() {
		return pageList;
	}

	public void setPageList(List<Page> pageList) {
		this.pageList = pageList;
	}

	public Page(Integer pageNumber, String storySection,String object) {
		super();
		this.pageNumber = pageNumber;
		this.storySection = storySection;
		this.object = object;
	}
	
	public Page(Integer pageNumber, String storySection, List<Page> pageList) {
		super();
		this.pageNumber = pageNumber;
		this.storySection = storySection;
		this.pageList = pageList;
	}
	
	public Page(Integer pageNumber, String storySection) {
		super();
		this.pageNumber = pageNumber;
		this.storySection = storySection;
	}

	public Page(Integer pageNumber, String storySection, List<Page> pageList, String object, boolean thief) {
		super();
		this.pageNumber = pageNumber;
		this.storySection = storySection;
		this.pageList = pageList;
		this.object = object;
		this.thief = thief;
	}

	public Page(Integer pageNumber, String storySection, List<Page> pageList, boolean thief) {
		super();
		this.pageNumber = pageNumber;
		this.storySection = storySection;
		this.pageList = pageList;
		this.thief = thief;
	}
	
	public Page(Integer pageNumber, String storySection, boolean thief) {
		super();
		this.pageNumber = pageNumber;
		this.storySection = storySection;
		this.thief = thief;
	}

	public Page() {

	}

}
