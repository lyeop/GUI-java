package DB_1;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class view {
    JFrame jframe;
    JPanel JP;
    JTextField Jt1;
    JPasswordField Jt2;
    JPasswordField Jt3;
    JTextField jt5;
    JTextField jt6;
    JButton bjt1;
    JButton bjt2;
    JButton bjt6;
    JLabel JL1;
    JLabel JL2;
    JLabel JL3;
    JLabel JL4;
    JLabel JL5;
    JLabel JL6;
    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;

    public view() {
        longin();
    }
    public view(boolean skipLogin) {
        if (skipLogin) {
            Admin();  // 매개변수가 true일 때만 admin() 실행
        }
    }

    public void gui_newMember() {
        jframe = new JFrame();
        JP = new JPanel();
        Jt1 = new JTextField();
        Jt2 = new JPasswordField();
        Jt3 = new JPasswordField();
        jt5 = new JTextField();
        jt6 = new JTextField();
        bjt1 = new JButton("정보 추가");
        bjt2 = new JButton("돌아가기");
        bjt6 = new JButton("종료");
        JL1 = new JLabel("아이디 입력:");
        JL2 = new JLabel("비밀번호 입력:");
        JL3 = new JLabel("비밀번호 확인:");
        JL4 = new JLabel("날짜 선택:");
        JL5 = new JLabel("이름 입력:");
        JL6 = new JLabel("전화번호 입력:");
        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);

        jframe.setTitle("회원 가입");
        jframe.setBounds(50, 50, 400, 350);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        JP.setLayout(null);
        jframe.setResizable(false);
        jframe.add(JP);

        Jt1.setBounds(110, 25, 70, 25);
        JP.add(Jt1);
        JL1.setBounds(30, 20, 80, 30);
        JP.add(JL1);
        Jt2.setBounds(110, 55, 120, 25);
        JP.add(Jt2);
        JL2.setBounds(30, 50, 80, 30);
        JP.add(JL2);
        Jt3.setBounds(110, 85, 120, 25);
        JP.add(Jt3);
        JL3.setBounds(30, 80, 100, 30);
        JP.add(JL3);
        datePicker.setBounds(110, 115, 120, 30);
        JP.add(datePicker);
        JL4.setBounds(30, 110, 100, 30);
        JP.add(JL4);
        jt5.setBounds(110, 145, 120, 25);
        JP.add(jt5);
        JL5.setBounds(30, 140, 100, 30);
        JP.add(JL5);
        jt6.setBounds(110, 175, 120, 25);
        JP.add(jt6);
        JL6.setBounds(30, 170, 100, 30);
        JP.add(JL6);

        JP.add(bjt1);
        bjt1.setBounds(30, 250, 100, 30);
        JP.add(bjt2);
        bjt2.setBounds(150, 250, 100, 30);
        JP.add(bjt6);
        bjt6.setBounds(280, 250, 60, 30);

        Controller con = new Controller();

        bjt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = Jt1.getText();
                String password = new String(Jt2.getPassword());
                String passwordConfirm = new String(Jt3.getPassword());
                String date = new SimpleDateFormat("yyyy-MM-dd").format((Date) datePicker.getModel().getValue());
                String name = jt5.getText();
                String tel = jt6.getText();

                if (!password.equals(passwordConfirm)) {
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
                } else {
                    con.insert(new Data(id, password, date, name, tel));
                    Jt1.setText("");
                    Jt2.setText("");
                    Jt3.setText("");
                    jt5.setText("");
                    jt6.setText("");
                }
            }
        });

        bjt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                longin();
            }
        });

        bjt6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void Admin(){

        jframe = new JFrame();
        JP = new JPanel();
        bjt1 = new JButton("회원관리");
        bjt2 = new JButton("예약관리");
        bjt6 = new JButton("로그인");
        jframe.setTitle("관리자 페이지");
        jframe.setBounds(50, 50, 400, 350);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);

        JP.setLayout(null);
        jframe.add(JP);

        JL1 = new JLabel("회원 관리 GUI 이동 : ");
        JL2 = new JLabel("예약 관리 GUI 이동 : ");
        JL3 = new JLabel("로그인 GUI 이동 : ");
        JL1.setBounds(30, 20, 130, 30);
        JL2.setBounds(30, 80, 130, 30);
        JL3.setBounds(30,140,130,30);
        JP.add(JL1);
        JP.add(JL2);
        JP.add(JL3);
        bjt1.setBounds(170, 20, 100, 30);
        bjt2.setBounds(170, 80, 100, 30);
        bjt6.setBounds(170,140,100,30);
        JP.add(bjt1);
        JP.add(bjt2);
        JP.add(bjt6);

        jframe.setVisible(true);
        bjt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                new MemberManagementGUI();
            }
        });

        bjt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                new SeatReservation("admin");
            }
        });
        bjt6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                longin();
            }
        });
    }

    public void longin() {
        jframe = new JFrame();
        JP = new JPanel();
        JTextField jt1 = new JTextField();
        JPasswordField jt2 = new JPasswordField();
        bjt1 = new JButton("로그인");
        bjt2 = new JButton("회원 가입");
        bjt6 = new JButton("종료");
        JL1 = new JLabel("아이디 입력:");
        JL2 = new JLabel("비밀번호 입력:");
        jframe.setTitle("로그인");
        jframe.setBounds(50, 50, 400, 350);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        JP.setLayout(null);
        jframe.setResizable(false);
        jframe.add(JP);
        jt1.setBounds(110, 25, 70, 25);
        JP.add(jt1);
        JL1.setBounds(30, 20, 80, 30);
        JP.add(JL1);
        jt2.setBounds(110, 55, 120, 25);
        JP.add(jt2);
        JL2.setBounds(30, 50, 80, 30);
        JP.add(JL2);
        JP.add(bjt1);
        bjt1.setBounds(30, 250, 100, 30);
        JP.add(bjt2);
        bjt2.setBounds(150, 250, 100, 30);
        JP.add(bjt6);
        bjt6.setBounds(280, 250, 60, 30);

        Controller con = new Controller();

        bjt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jt1.getText();
                String password = new String(jt2.getPassword());
                ArrayList<Data> arr = con.searchId(id);

                if (id.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "관리자 GUI로 이동합니다.");
                    jframe.setVisible(false);
                    Admin(); // Admin 메소드 호출
                }
                // 일반 사용자 로그인 체크
                else if (!arr.isEmpty() && id.equals(arr.get(0).getId()) && password.equals(arr.get(0).getPassword())) {
                    JOptionPane.showMessageDialog(null, "자리예약 GUI로 이동합니다.");
                    jframe.setVisible(false);
                    new SeatReservation(id);

                }else {
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
                    jt1.setText("");
                    jt2.setText("");
                }
            }
        });

        bjt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                gui_newMember();
            }
        });

        bjt6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}