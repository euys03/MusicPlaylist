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
 * Servlet implementation class AddServlet
 */
@WebServlet("/music/addMusic")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // url에 입력하는 것(get방식으로 동작)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// WEB-INF 아래에 있는 폴더들을 실행하기 위한 코드(보안 요소로 WEB-INF에 넣어 URL에서는 읽어들일 수 없는 파일들)
		request.getRequestDispatcher("/WEB-INF/views/music/add.jsp").forward(request, response);
	}
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 (setCharacterEncoding) - 한글로 입력한 곡명, 가수명, 기획사 깨지는 것 방지
		request.setCharacterEncoding("UTF-8");
		// <input>태그에 입력된 값들 getParameter를 통해 모두 서버로 가져옴.
		String musicTitle = request.getParameter("music-title");
		String musicSinger = request.getParameter("music-singer");
		String musicRelease = request.getParameter("music-release");
		String musicTime = request.getParameter("music-time");
		String musicAgency = request.getParameter("music-agency");
		
		Music music = new Music();
		music.setMusicTitle(musicTitle);
		music.setMusicSinger(musicSinger);
		music.setMusicRelease(musicRelease);
		music.setMusicTime(musicTime);
		music.setMusicAgency(musicAgency);
		
		MusicService mService = new MusicService();
		int result = mService.registerMusic(music);
		
		if(result > 0) {
			// 곡 추가 성공시 index.jsp (플레이리스트 페이지)로 이동
			response.sendRedirect("/index.jsp");
		}else {
			// 곡 추가 실패!
			request.setAttribute("title", "곡 추가 실패");
			request.setAttribute("msg", "곡 추가가 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/music/error.jsp").forward(request, response);
		}
		
	}

}
