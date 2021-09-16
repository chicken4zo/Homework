package kr.or.bit.dao;

import kr.or.bit.dto.KoreaMemberDto;
import kr.or.bit.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
