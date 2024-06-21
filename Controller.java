package DB_1;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Controller {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement psmt;

    public Controller() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isIdExist(String id) {
        try {
            psmt = conn.prepareStatement("SELECT COUNT(*) FROM 회원관리 WHERE id = ?;");
            psmt.setString(1, id);
            rs = psmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insert(Data d) {
        try {
            if (isIdExist(d.id)) {
                JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
                return;
            }
            psmt = conn.prepareStatement("INSERT INTO 회원관리 VALUES(?,?,?,?,?);");
            psmt.setString(1, d.id);
            psmt.setString(2, d.password);
            psmt.setString(3, d.date);
            psmt.setString(4, d.name);
            psmt.setString(5, d.tel);
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "회원 가입이 완료되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Data> searchId(String name) {
        ArrayList<Data> arr = new ArrayList<>();
        try {
            psmt = conn.prepareStatement("SELECT * FROM 회원관리 WHERE id LIKE ?");
            psmt.setString(1, "%" + name + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                arr.add(new Data(rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("date"),
                        rs.getString("name"), rs.getString("tel")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public void deleteData(String name) {
        try {
            psmt = conn.prepareStatement("DELETE FROM 회원관리 WHERE name = ?;");
            psmt.setString(1, name);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean reserveSeat(String seatNumber, String userId) {
        try {
            psmt = conn.prepareStatement("SELECT COUNT(*) FROM 좌석예약 WHERE 예약자ID = ?;");
            psmt.setString(1, userId);
            rs = psmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return false; // 예약 실패
            }

            psmt = conn.prepareStatement("INSERT INTO 좌석예약 (좌석번호, 예약자ID) VALUES (?, ?);");
            psmt.setString(1, seatNumber);
            psmt.setString(2, userId);
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {

                return true; // 예약 성공
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // 예약 실패
    }

    public ArrayList<String> getReservedSeats() {
        ArrayList<String> reservedSeats = new ArrayList<>();
        try {
            psmt = conn.prepareStatement("SELECT 좌석번호 FROM 좌석예약;");
            rs = psmt.executeQuery();
            while (rs.next()) {
                reservedSeats.add(rs.getString("좌석번호"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservedSeats;
    }

    public void exitSeat(String userId) {
        try {
            psmt = conn.prepareStatement("DELETE FROM 좌석예약 WHERE 예약자ID = ?;");
            psmt.setString(1, userId);
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {

            } else {
                JOptionPane.showMessageDialog(null, "예약된 좌석이 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserSeat(String userId) {
        try {
            psmt = conn.prepareStatement("SELECT 좌석번호 FROM 좌석예약 WHERE 예약자ID = ?;");
            psmt.setString(1, userId);
            rs = psmt.executeQuery();
            if (rs.next()) {
                return rs.getString("좌석번호");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}