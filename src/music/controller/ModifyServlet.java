package music.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.model.service.MusicService;
import music.model.vo.Music;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/music/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 곡명, 가수명, 발매일, 재생시간, 기획사 => 수정 가능
		request.setCharacterEncoding("UTF-8");
		String musicTitle = request.getParameter("title");
		String musicSinger = request.getParameter("singer");
		String musicAgency = request.getParameter("agency");
		
		// Music.java에 해당 매개변수가 있는 생성자 생성
		Music music = new Music(musicTitle, musicSinger, musicAgency);
		
		MusicService mService = new MusicService();
		int result = mService.modifyMusic(music);
		if(result > 0) {
			// 성공하면 메인페이지
			response.sendRedirect("/index.jsp");
		}else {
			// 실패하면 에러페이지
			request.setAttribute("title", "곡 정보 수정 실패");
			request.setAttribute("msg", "곡 정보 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/music/error.jsp").forward(request, response);
		}
	}

}
