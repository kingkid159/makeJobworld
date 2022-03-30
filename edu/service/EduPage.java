package com.job.jobPro.edu.service;

import java.util.List;

import com.job.jobPro.edu.vo.EduVO;

public class EduPage {
	private int total;
	private int currentPage;
	private List<EduVO> content;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int size;
	
public EduPage(int startPage, int size) {
	this.startPage = startPage;
	this.size = size;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public EduPage(int total, int currentPage, int size, List<EduVO> content) {
	this.total = total;
	this.currentPage = currentPage;
	this.content = content;
	if (total == 0) {
		totalPage = 0;
		startPage = 0;
		endPage = 0;
	}else {
		totalPage = total/size;
		if(total % size > 0) {
			totalPage++;
		}
	int modVal = currentPage % 5;
	startPage = currentPage / 5 * 5 + 1;
	if (modVal == 0)startPage -= 5;
	endPage = startPage + 4;
	if (endPage > totalPage) endPage = totalPage;
	}
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

public List<EduVO> getContent() {
	return content;
}

public void setContent(List<EduVO> content) {
	this.content = content;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public int getStartPage() {
	return startPage;
}

public void setStartPage(int startPage) {
	this.startPage = startPage;
}

public int getEndPage() {
	return endPage;
}

public void setEndPage(int endPage) {
	this.endPage = endPage;
}
@Override
public String toString() {
	return "EduPage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPage="
			+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", size=" + size + "]";
}



}
