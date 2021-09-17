package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.KoreaMemberDao;



public class KoreaMemberDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
    	String id = request.getParameter("id");
       	//memo m = new memo();  //권장사항
    	//m.setId(id);
    	
    	KoreaMemberDao dao = new KoreaMemberDao(); //POINT
		int result = dao.deleteMember(id);
    	
		 	String msg="";
		 	String url="";
		    if(result > 0){
		    	msg ="삭제하였습니다.";
		    	url ="KoreaMemberDelete.do";
		    }else{
		    	msg="삭제에 실패하였습니다.";
		    	url="memo.html";
		    }
		    
		    request.setAttribute("board_msg",msg);
		    request.setAttribute("board_url", url);
		
		    ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/views/redirect.jsp");
		    
		return forward;
	}

}






