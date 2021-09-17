package kr.or.bit.dao;

import kr.or.bit.dto.KoreaMemberDto;
import kr.or.bit.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KoreaMemberDao {
    public int insertKoreanMember(KoreaMemberDto koreaMemberDto){
        Connection conn=null;
        int resultRow=0;
        PreparedStatement pstmt = null;

        try{
            conn = ConnectionHelper.getConnection("oracle");

            String sql="insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, koreaMemberDto.getId());
            pstmt.setString(2, koreaMemberDto.getPwd());
            pstmt.setString(3, koreaMemberDto.getName());
            pstmt.setInt(4,koreaMemberDto.getAge());
            pstmt.setString(5, koreaMemberDto.getGender());
            pstmt.setString(6, koreaMemberDto.getEmail());
            pstmt.setString(7, koreaMemberDto.getIp());

            resultRow = pstmt.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resultRow;
    }
    public int deleteMember(String id) {

        Connection conn =null;
        int resultrow=0;
        PreparedStatement pstmt = null;

        try {
            conn= ConnectionHelper.getConnection("oracle");//추가

            String sql = "delete from koreaMember where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);


            resultrow = pstmt.executeUpdate();

        }catch(Exception e) {
            System.out.println("Delete : " + e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
            try {
                conn.close(); //반환하기
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultrow;
    }
    //멤버 상세 페이지
    public KoreaMemberDto detailMember(String id){

        KoreaMemberDto kdto = new KoreaMemberDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try{
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "select id,pwd,name,age,gender,email from koreamember where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();
            //rs.next(); 추후에 데이터 1건 경우  (while 없이 )
            while(rs.next()){
                kdto.setId(rs.getString("id"));
                kdto.setPwd(rs.getString("pwd"));
                kdto.setName(rs.getString("name"));
                kdto.setAge(rs.getInt("age"));
                kdto.setGender(rs.getNString("gender"));
                kdto.setEmail(rs.getString("email"));


            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return kdto;
    }

    //여러명의 멤버 데이터 불러오기
    public KoreaMemberDao getMemoListById(String id){

        return null;
    }

}

