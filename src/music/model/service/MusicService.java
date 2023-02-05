package music.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import music.model.dao.MusicDAO;
import music.model.vo.Music;


public class MusicService {
	
	// mDao라는 멤버변수를 통해
	private MusicDAO mDao;
	
	// 생성자 생성
	public MusicService() {
		// mDao 초기화
		mDao = new MusicDAO();
	}

	
	/**
	 * 플레이리스트 조회 Service
	 * @return mList
	 */
	public List<Music> selectPlaylist() {
		Connection conn = JDBCTemplate.getConnection();
		List<Music> mList = mDao.selectPlaylist(conn);
		return mList;
	}
	
	
	/**
	 * 곡 추가하기 Service
	 * @param music
	 * @return result
	 */
	public int registerMusic(Music music) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = mDao.insertMusic(conn, music);
		if(result > 0) {
			// 커밋
			JDBCTemplate.commit(conn);
		}else {
			// 롤백
			JDBCTemplate.rollback(conn);
		}
		// 연결 해제
		return result;
	}

	
	/**
	 * 곡 정보 수정하기 Service
	 * @param music
	 * @return result
	 */
	public int modifyMusic(Music music) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = mDao.modifyMusic(conn, music);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}


	/**
	 * 곡 삭제하기 Service
	 * @param musicTitle
	 * @return result
	 */
	public int deleteMusic(String musicTitle) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = mDao.deleteMusic(conn, musicTitle);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
