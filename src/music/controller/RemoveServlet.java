package music.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.model.service.MusicService;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/music/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicTitle = request.getParameter("title");
		MusicService mService = new MusicService();
		int result = mService.deleteMusic(musicTitle);
		if(result > 0) {
			// 성공 시 playlist로 이동
			response.sendRedirect("/music/list");
		}else {
			request.setAttribute("title", "곡 삭제 실패");
			request.setAttribute("msg", "곡 삭제가 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
		}
	}

}
