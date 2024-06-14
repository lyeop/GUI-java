package DB_1;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    Connection conn =null;
    ResultSet rs= null;
    Statement st= null;
    PreparedStatement psmt;
    Controller(){ //생성자 커넥션 mysql 연결
        try{
            // 자바와 mysql에 esports테이블에 연결
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/esports","root","1234");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void insert(Data d){ //회원 추가

        try{
            st =conn.createStatement(); //connection 클래스로 mysql와 연동
           psmt =conn.prepareStatement("INSERT INTO 선수관리 VALUES(?,?,?,?,?,?,?,?);");  //
           psmt.setString(1,d.name); //Data 클래스에서 받은 name 값 대입
           psmt.setString(2,d.team); //Data 클래스에서 받은 team 갑 대입
           psmt.setString(3,d.position); //Data 클래스에서 받은 position 값 대입
            psmt.setString(4,d.age); //Data 클래스에서 받은 age 값 대입
            psmt.setString(5,null); //file 값이 입력이 없기 때문에 null으로 입력
            psmt.setString(6,null); //debut 값이 입력이 없기때문에 null으로 입력
            psmt.setString(7,null);//career 값이 입력이 없기 때문에 null으로 입력
            psmt.setString(8,null);//num 값이 입력이 없기 때문에 null으로 입력
           psmt.executeUpdate(); //업데이트로 추가
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Data> readData(){ //전체 출력
        ArrayList<Data> arr= new ArrayList<Data>();
      //  System.out.println(arr); //arraylist에 있는 data 값 출력
        try{
            st= conn.createStatement(); // mysql에 연결
            rs= st.executeQuery("select *from 선수관리;"); //mysql에 전체출력명령어 입력
            //mysql에 테이블 고객관리에 저장 되어있는 이름,전화번호, 주소 arraylist 변수 data에 추가
            while(rs.next()){
                String name = rs.getString("name");
                String team = rs.getString("team");
                String position = rs.getString("position");
                String age = rs.getString("age");
                arr.add(new Data(name,team,position,age));

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }
    void updateData(String name, String team){ //팀 변경
        try{
            st=conn.createStatement(); //mysql에 연결
            //이름 조건에 맞는 전화번호를 입력한 전화번호로 변경
            psmt =conn.prepareStatement("update 선수관리 set team = ? where name= ?;");
            psmt.setString(1,team);
            psmt.setString(2,name);
            psmt.executeUpdate(); //수정된 정보를 업데이트

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    void updateData2(String name,String position){ //포지션 변경
        try{

            st=conn.createStatement(); //mysql에 연결
            //이름 조건에 맞는 주소를 입력한 주소로 변경
            psmt=conn.prepareStatement("update 선수관리 set position = ? where name = ? ;");
            psmt.setString(1,position);
            psmt.setString(2,name);
            psmt.executeUpdate(); //수정된 정보를 업데이트

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    void deleteData(String name){ //고객관리 삭제

        try{
            st= conn.createStatement(); // mysql에 연결
            //mysql에 이름 조건에 맞는 정보를 삭제;
            psmt =conn.prepareStatement("delete from 선수관리 where name = ? ;");
            psmt.setString(1,name); // ?에 대한 값을 String 변수 name 대입
            psmt.executeUpdate(); // 수정된 정보 업데이트
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    ArrayList<Data> searchData(String name){ //선수관리 이름검색
        ArrayList<Data> arr= new ArrayList<>(); //arraylist data 를 변수 arr로 객체 생성
       // System.out.println(arr); //arraylist 변수 arr을 출력
        try{
            st= conn.createStatement(); //mysql 에 연결
            // mysqldp 명령어 고객관리안에 이름 String 변수 name 에 맞는 값을 입력
          rs = st.executeQuery("select * from 선수관리 where team like '%" + name + "%';");
          //  psmt =conn.prepareStatement("select * from 고객관리 where 이름  like  '%(?)%' ;");
          // psmt.setString(1,name);
         //  ResultSet rs = psmt.executeQuery(); // 결과물 받는다. executeQuery
            //조건에 맞는 값을 변수 rs값을 가져와서 arr변수에 저장
            while(rs.next()){
                arr.add(new Data(rs.getString("name"),rs.getString("team"),rs.getString("position"),
                        rs.getString("age")));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return arr;
    }
    ArrayList<Data> searchpositon(String position){ //포지션관리 이름검색
        ArrayList<Data> arr= new ArrayList<>(); //arraylist data 를 변수 arr로 객체 생성
        // System.out.println(arr); //arraylist 변수 arr을 출력
        try{
            st= conn.createStatement(); //mysql 에 연결
            // mysqldp 명령어 고객관리안에 이름 String 변수 name 에 맞는 값을 입력
            rs = st.executeQuery("select * from 선수관리 where position like '%"+ position + "%';");
            //  psmt =conn.prepareStatement("select * from 고객관리 where 이름  like  '%(?)%' ;");
            // psmt.setString(1,name);
            //  ResultSet rs = psmt.executeQuery(); // 결과물 받는다. executeQuery
            //조건에 맞는 값을 변수 rs값을 가져와서 arr변수에 저장
            while(rs.next()){
                arr.add(new Data(rs.getString("name"),rs.getString("team"),rs.getString("position"),
                        rs.getString("age")));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return arr;

    }
}
