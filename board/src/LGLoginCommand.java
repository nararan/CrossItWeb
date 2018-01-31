import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class LGLoginCommand implements LGCommand{
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mId = request.getParameter("id");
		String mPw = request.getParameter("pw");
		
		memberDAO mdao = memberDAO.getInstance();
		int check = mdao.memberCheck(mId, mPw);
		request.setAttribute("check", check);
		if (check == memberDAO.MEMBER_LOGIN_SUCCESS){
			memberDTO dto = mdao.getMember(mId);
//			request.setAttribute("memberInfo", dto);
			HttpSession session = request.getSession();
			session.setAttribute("memberId", dto.getmId());
			session.setAttribute("memberName", dto.getmName());
			

		}
	}

}
