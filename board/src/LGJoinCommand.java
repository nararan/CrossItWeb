import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class LGJoinCommand implements LGCommand{
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mId = request.getParameter("id");
		String mPw = request.getParameter("pw");
		String mName = request.getParameter("name");
		String mAddress = request.getParameter("address");
		String mEmail = request.getParameter("email"); 
		
		memberDAO mdao = memberDAO.getInstance();
		int a = mdao.insertMember(mId, mPw, mName, mAddress, mEmail);
		System.out.println(a);
	}

}
