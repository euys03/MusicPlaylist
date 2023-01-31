package music.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.model.service.MusicService;
import music.model.vo.Music;

/**
 * Servlet implementation class MusicListServlet
 */
@WebServlet("/music/list")
public class MusicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MusicService mService = new MusicService();
		List<Music> mList = mService.selectPlaylist();
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("/WEB-INF/views/music/list.jsp").forward(request, response);
	}

}
