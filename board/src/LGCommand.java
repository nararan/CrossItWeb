import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LGCommand {
	public void execute(HttpServletRequest request,HttpServletResponse response);
}
