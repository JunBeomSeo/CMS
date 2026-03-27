package com.example.page;

public class pageModule {
	
	public static String makePage(int cp, int totalCnt, int listSize, int pageSize) {
	
		int userGroup = cp/pageSize;
		if(cp%pageSize==0) {
			userGroup--;
		}
		
		int totalPage = totalCnt/listSize+1;
		if(totalCnt%listSize==0) {
			totalPage--;
		}
		
		int startPage = userGroup*pageSize+1;
		int endPage = startPage+pageSize-1;
		
		StringBuffer sb = new StringBuffer();
		
		if(userGroup != 0) {
			sb.append("<a href='#' class='prev' onclick='boardList(" + (startPage - 1) + ")'>이전</a> ");
		}
		
		for(int i=startPage; i<=endPage; i++) {
			if(totalPage<i) {
				break;
			}
			sb.append("<a href='#' class='page-num' onclick='boardList(" + i + ")'>" + i + "</a> ");
		}
		
        if (endPage < totalPage) {
            sb.append("<a href='#' class='next' onclick='boardList(" + (endPage + 1) + ")'>다음</a>");
        }
		
		return sb.toString();
		
	}

}
