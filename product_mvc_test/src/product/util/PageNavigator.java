package product.util;

/**
 * 페이징 네비게이터 함수
 * @author stoneis.pe.kr
 * @since 2013.07.10
 */
public class PageNavigator {
	
	/**
	 * 페이징 네비게이터를 만들어주는 함수
	 * @param totalCount	- 총수
	 * @param listCount		- 노출될 목록 게시물 수
	 * @param pagePerBlock	- 노출될 블록 수
	 * @param pageNum		- 페이지 번호
	 * @param searchType	- 검색 항목
	 * @param searchText	- 검색어
	 * @return
	 */
	public String getPageNavigator(int totalCount, int listCount, int pagePerBlock,
			int pageNum, String searchType, String searchText) {
		StringBuffer sb = new StringBuffer();
		if(totalCount > 0) {
			int totalNumOfPage = (totalCount % listCount == 0) ? // 전체 블록 수
					totalCount / listCount : totalCount / listCount + 1;
			
			int totalNumOfBlock = (totalNumOfPage % pagePerBlock == 0) ? // 페이지 번호 그룹이 몇개가 필요한지
					totalNumOfPage / pagePerBlock :
					totalNumOfPage / pagePerBlock + 1;
			 
			int currentBlock = (pageNum % pagePerBlock == 0) ?   // 몇번째 그룹에 있는지 확인하기 위해서 클릭한 페이지로 다시 돌아가야 하기 때문에 
					pageNum / pagePerBlock :
					pageNum / pagePerBlock + 1;
			
			int startPage = (currentBlock - 1) * pagePerBlock + 1;
			int endPage = startPage + pagePerBlock - 1;
			
			if(endPage > totalNumOfPage)  // 다음으로 넘어가지 못하는 하는 코드
				endPage = totalNumOfPage;
			boolean isNext = false;
			boolean isPrev = false;
		

			if(currentBlock < totalNumOfBlock)
				isNext = true;
			if(currentBlock > 1)
				isPrev = true;
			if(totalNumOfBlock == 1){
				isNext = false;
				isPrev = false;
			}// 첫번째 그룹과 같은 둘다 false

			if(pageNum > 1){ //&amp; = & ,&nbsp; = 띄어쓰기 한칸
				sb.append("<a href=\"").append("boardListServlet?pageNum=1&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"<<\"><<</a>&nbsp;");
			}
			if (isPrev) {
				int goPrevPage = startPage - pagePerBlock;			
				sb.append("&nbsp;&nbsp;<a href=\"").append("BoardListServlet?pageNum="+goPrevPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"<\"><</a>");
			} else {
				
			}
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNum) {
					sb.append("<a href=\"#\"><strong>").append(i).append("</strong></a>&nbsp;&nbsp;");
				} else {
					sb.append("<a href=\"").append("BoardListServlet?pageNum="+i+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
					sb.append("\" title=\""+i+"\">").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			if (isNext) {
				int goNextPage = startPage + pagePerBlock;
	
				sb.append("<a href=\"").append("BoardListServlet?pageNum="+goNextPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\">\">></a>");
			} else {
				
			}
			if(totalNumOfPage > pageNum){
				sb.append("&nbsp;&nbsp;<a href=\"").append("BoardListServlet?pageNum="+totalNumOfPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\">>\">>></a>");
			}
			
		}
		return sb.toString();  //(sb는 StringBuffer 이기 때문에 to String으로 변환 시켜야 한다.
	}
}