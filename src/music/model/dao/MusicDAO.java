package music.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import music.model.vo.Music;

public class MusicDAO {



	/**
	 * 플레이리스트 조회 DAO
	 * @param conn
	 * @return mList
	 */
	public List<Music> selectPlaylist(Connection conn) {
		String query = "SELECT * FROM MUSICWEB_TBL";
		List<Music> mList = null;
		
		try {
//			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, music.getMusicTitle());
//			pstmt.setString(1, musicTitle);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			
			// 후처리
			mList = new ArrayList<Music>();
			while(rset.next()) {
				Music music = new Music();
				music.setMusicTitle(rset.getString("MUSIC_TITLE"));
				music.setMusicSinger(rset.getString("MUSIC_SINGER"));
				music.setMusicRelease(rset.getString("MUSIC_RELEASE"));
				music.setMusicTime(rset.getString("MUSIC_TIME"));
				music.setMusicAgency(rset.getString("MUSIC_AGENCY"));
				
				// mList에 최종 저장
				mList.add(music);
			}
			rset.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	/**
	 * 곡 추가
	 * @param conn
	 * @param music
	 * @return result
	 */
	public int insertMusic(Connection conn, Music music) {
		// 위치홀더에 값을 넣을 땐 순서가 중요!
		String query = "INSERT INTO MUSICWEB_TBL VALUES(?,?,?,?,?)";
		int result = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			// 위치홀더에 값 넣기 (순서 중요!)
			pstmt.setString(1, music.getMusicTitle());
			pstmt.setString(2, music.getMusicSinger());
			pstmt.setString(3, music.getMusicRelease());
			pstmt.setString(4, music.getMusicTime());
			pstmt.setString(5, music.getMusicAgency());	// 쿼리문 실행 준비완료
			
			result = pstmt.executeUpdate();	// DML(INSERT, UPDATE, DELETE)는 executeUpdate();
			
			// 자원해제
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 곡 정보 수정하기 DAO
	 * @param conn
	 * @param music
	 * @return result
	 */
	public int modifyMusic(Connection conn, Music music) {
		String query = "UPDATE MUSICWEB_TBL SET MUSIC_SINGER=?, MUSIC_AGENCY=? WHERE MUSIC_TITLE=?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, music.getMusicSinger());
			pstmt.setString(2, music.getMusicAgency());
			pstmt.setString(3, music.getMusicTitle());	// 쿼리문 실행 준비 완료
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 곡 삭제 DAO
	 * @param conn
	 * @param musicTitle
	 * @return result
	 */
	public int deleteMusic(Connection conn, String musicTitle) {
		String query = "DELETE FROM MUSICWEB_TBL WHERE MUSIC_TITLE= ?";
		int result = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, musicTitle);
			result = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	

}
