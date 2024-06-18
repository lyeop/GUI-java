package DB_1;

import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class view extends  JFrame{

    JFrame jframe =new JFrame();
    JPanel JP =new JPanel();
    JTextField Jt1 =new JTextField();//아이디
    JPasswordField Jt2 =new JPasswordField(); //비밀번호
    JPasswordField Jt3 =new JPasswordField(); //비밀번호 확인

    JTextField jt4 =new JTextField(); // 이름

    JTextField jt5 =new JTextField(); // 전화번호
    UtilDateModel model = new UtilDateModel();
    //날짜를 저장하고 관리하기 위해 객체 생성

    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    //날짜를 선택할 수 있는 패널 생성 하고 앞서 생성한 model 인자로 전달
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    //실제로 사용자에게 보여지는 날짜 선택 위젯 생성 하고 앞서 생성한 datePanel을 인자로 전달
    JTextField jt6 =new JTextField(); // 포지션 조회
   JTextArea ta =new JTextArea(); //출력창
   // JTextPane ta =new JTextPane(); //가운데 정렬할수 있는 메소드
    //JTextpane 함수에 append 쓰기위해서는 다른 함수 StringBuffer 써서 넣어줘야 하기 때문에 메모리,소스상 비효율적이다.



    JButton bjt1, bjt2, bjt3, bjt4 ,bjt5, bjt6,bjt7,bjt8;
    JLabel JL1 =new JLabel("아이디 : ");//이름 창 이름
    JLabel JL2 =new JLabel("비밀번호 : "); //전화번호 창 이름
    JLabel JL3 =new JLabel("비밀번호확인: "); // 주소 창 이름
    JLabel JL4 =new JLabel("날짜  ");// 이름 검색 창 이름
    JLabel JL5 =new JLabel("이름 : ");
    JLabel JL6 =new JLabel("전화번호 : ");

    JLabel JL7=new JLabel(" 조 회 ");
    JLabel JL8=new JLabel(" 변 경 ");
    view(){

        gui_view();
    }
    public void gui_view(){

        jframe.setTitle("회원가입"); //GUI 이름 설정
        jframe.setBounds(50, 50, 550, 450); //전체 창크기 설정
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true); //입력 할수 있게 함
        JP.setLayout(null); //창 변경불가
        jframe.setResizable(false); // 전체 창을 드래그로 크기 변경 불가
        jframe.add(JP); // 전체창에 j패널 추가


        Jt1.setBounds(110,25,70,25); //아이디 입력창 추가 위치, 크기 설정
        JP.add(Jt1); //패널에 입력창 추가
        JL1.setBounds(30,20,80,30); //입력창 옆에 라벨 위치,크기 설정
        JP.add(JL1); //패널에 이름라벨 추가

        Jt2.setBounds(110,55,100,25); //비밀번호
        JP.add(Jt2); //비밀번호
        JL2.setBounds(30,50,80,30); //비밀번호 라벨
        JP.add(JL2); //비밀번호 라벨

        Jt3.setBounds(110,85,120,25); //비밀번호 확인
        JP.add(Jt3);//비밀번호 확인
        JL3.setBounds(30,80,90,30); //비밀번호 확인 라벨 위치 크기 설정
        JP.add(JL3); //패널에 주소 라벨 추가

        datePicker.setBounds(110,115,150,30); //날짜
        JP.add(datePicker); //패널에 입력창 추가
        JL4.setBounds(30,110,80,30); //날짜 라벨 위치
        JP.add(JL4); //패널에 이름검색 라벨추가
        jt5.setBounds(110,150,70,25); // 이름입력창 주소
        JP.add(jt5);
        jt6.setBounds(110,180,80,25); // 전화번호 입력창
        JP.add(jt6);
        JL5.setBounds(30,150,80,30); //이름 라벨
        JP.add(JL5);
        JL6.setBounds(30,180,80,30); //전화번호라벨
        JP.add(JL6);

/*
        //ta를 가져와서 styleDocument로 가운데 정렬
        StyledDocument doc = ta.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
         //가운데 정렬할 수 있는 메소드

 */

        JScrollPane jsp= new JScrollPane(ta); // 결과 값 나오는 스크롤되는 객체 추가
       ta.setEditable(false); // 출력창 수정이나 입력 할수 없게 설정
       // jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
       //jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jsp.setBounds(60,250,420,100); // 결과값 나오는 창  크기 위치 설정
        JP.add(jsp); // 패널에 결과값 창추가

        JP.add(bjt1= new JButton("회원 가입")); //정보추가 버튼 생성 JP객체에 추가
        bjt1.setBounds(30,350,100,30); //정보추가 버튼 위치와 크기 설정

        JP.add(bjt2= new JButton("뒤로 가기")); //번호수정 버튼 생성 JP객체에 추가
        bjt2.setBounds(150,350,100,30); //번호 수정 버튼 위치 크기 설정


        JP.add(bjt6=new JButton("종료")); //종료 버튼 생성 및 JP객체에 추가
        bjt6.setBounds(420,360,80,30); //종료 버튼 위치 크기 설정

        Controller con= new Controller(); //컨트롤러 객체 생성

        model.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if("value".equals(evt.getPropertyName())){
                    System.out.println(model.getValue());
                }//선택한 날짜 출력;
            }
        });


        //추가
        bjt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //출력 창 초기화
                ta.setText("");
                //이름 , 전화번호 , 주소 값 가져오기
                String id = Jt1.getText();
                char[] passwordChars = Jt2.getPassword();
                String password = new String(passwordChars);
                Date selectedDate = (Date) datePicker.getModel().getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(selectedDate);
                String name= jt5.getText();
                String tel =jt6.getText();
                //입력된 이름 전화번호 주소를 con객체의 insert 함수로 Data객체에 넣어서 mysql에 추가
                con.insert(new Data(id, password, date,name,tel));
                //입력창에 추가완료 했다고 출력


            }
        });
        //포지션 수정

        //전체출력


        //삭제


        //팀 검색

        //팀 변경

         //포지션 조회

        //종료 버튼
        bjt6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}



