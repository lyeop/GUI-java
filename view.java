package DB_1;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class view {

    JFrame jframe =new JFrame();
    JPanel JP =new JPanel();
    JTextField Jt1 =new JTextField();//이름
    JTextField Jt2 =new JTextField(); //전화번호
    JTextField Jt3 =new JTextField(); //주소
    JTextField Jt4 =new JTextField(); // 나이

    JTextField jt5 =new JTextField(); //팀 조회

    JTextField jt6 =new JTextField(); // 포지션 조회
   JTextArea ta =new JTextArea(); //출력창
   // JTextPane ta =new JTextPane(); //가운데 정렬할수 있는 메소드
    //JTextpane 함수에 append 쓰기위해서는 다른 함수 StringBuffer 써서 넣어줘야 하기 때문에 메모리,소스상 비효율적이다.



    JButton bjt1, bjt2, bjt3, bjt4 ,bjt5, bjt6,bjt7,bjt8;
    JLabel JL1 =new JLabel("이름 : ");//이름 창 이름
    JLabel JL2 =new JLabel("소속 팀 : "); //전화번호 창 이름
    JLabel JL3 =new JLabel("포지션 : "); // 주소 창 이름
    JLabel JL4 =new JLabel("닉네임 : ");// 이름 검색 창 이름
    JLabel JL5 =new JLabel("팀 조회 : ");
    JLabel JL6 =new JLabel("포지션 조회 : ");

    JLabel JL7=new JLabel(" 조 회 ");
    JLabel JL8=new JLabel(" 변 경 ");
    view(){
        gui_view();
    }
    public void gui_view(){
        jframe.setTitle("선수관리"); //GUI 이름 설정
        jframe.setBounds(50, 50, 550, 450); //전체 창크기 설정
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true); //입력 할수 있게 함
        JP.setLayout(null); //창 변경불가
        jframe.setResizable(false); // 전체 창을 드래그로 크기 변경 불가
        jframe.add(JP); // 전체창에 j패널 추가


        Jt1.setBounds(75,25,70,25); //이름 입력창 추가 위치, 크기 설정
        JP.add(Jt1); //패널에 입력창 추가
        JL1.setBounds(30,20,80,30); //입력창 옆에 라벨 위치,크기 설정
        JP.add(JL1); //패널에 이름라벨 추가

        Jt2.setBounds(270,25,100,25); //팀 입력 위치,크기 설정
        JP.add(Jt2); //패널에 입력창추가
        JL2.setBounds(220,20,80,30); //입력창 옆에 라벨 위치 크기설정
        JP.add(JL2); //패널에 전화번호 라벨 추가

        Jt3.setBounds(75,60,120,25); //포지션 입력 위치 크기 설정
        JP.add(Jt3);//패널에 입력창 추가
        JL3.setBounds(30,55,80,30); //입력창 옆에 주소 라벨 위치 크기 설정
        JP.add(JL3); //패널에 주소 라벨 추가

        Jt4.setBounds(270,60,100,25); //나이 위치 크기설정
        JP.add(Jt4); //패널에 입력창 추가
        JL4.setBounds(220,55,80,30); //입력창 옆에 이름검색 라벨 위치 크기설정
        JP.add(JL4); //패널에 이름검색 라벨추가
        jt5.setBounds(75,175,70,25); // 이름검색 창
        JP.add(jt5);
        jt6.setBounds(280,175,80,25); //포지션 검색
        JP.add(jt6);
        JL7.setBounds(30,170,80,30);
        JP.add(JL7);
        JL8.setBounds(30,110,80,30);
        JP.add(JL8);

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

        JP.add(bjt1= new JButton("선수추가")); //정보추가 버튼 생성 JP객체에 추가
        bjt1.setBounds(410,20,90,30); //정보추가 버튼 위치와 크기 설정

        JP.add(bjt2= new JButton("포지션변경")); //번호수정 버튼 생성 JP객체에 추가
        bjt2.setBounds(80,110,100,30); //번호 수정 버튼 위치 크기 설정

        JP.add(bjt3= new JButton("전체출력")); //전체출력 버튼 생성 JP객체에 추가
        bjt3.setBounds(410,100,90,30); //전체출력 버튼 위치 크기 설정

        JP.add(bjt7=new JButton("소속팀변경")); //주소 변경 버튼 생성 JP객체에 추가
        bjt7.setBounds(210,110,100,30);

        JP.add(bjt4= new JButton("삭제")); //삭제 버튼 생성 JP객체에 추가
        bjt4.setBounds(410,60,90,30); //삭제 버튼 위치 크기 설정

        JP.add(bjt5=new JButton("팀 조회")); //이름검색 버튼 생성 JP객체에 추가
        bjt5.setBounds(160,175,90,30); //이름검색 버튼 위치 크기 설정
        JP.add(bjt8=new JButton("포지션조회"));
        bjt8.setBounds(380,175,100,30);
        JP.add(bjt6=new JButton("종료")); //종료 버튼 생성 및 JP객체에 추가
        bjt6.setBounds(420,360,80,30); //종료 버튼 위치 크기 설정

        Controller con= new Controller(); //컨트롤러 객체 생성


        //추가
        bjt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //출력 창 초기화
                ta.setText("");
                //이름 , 전화번호 , 주소 값 가져오기
                String name = Jt1.getText();
                String team = Jt2.getText();
                String position =Jt3.getText();
                String age= Jt4.getText();
                //입력된 이름 전화번호 주소를 con객체의 insert 함수로 Data객체에 넣어서 mysql에 추가
                con.insert(new Data(name, team, position,age));
                //입력창에 추가완료 했다고 출력
                ta.append("\n");
                ta.append("\t"+name+" 추가 완료\n");
                //입력했던 값 초기화
                Jt1.setText("");
                Jt2.setText("");
                Jt3.setText("");
                Jt4.setText("");
                jt5.setText("");
                jt6.setText("");

            }
        });
        //포지션 수정
        bjt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //출력 창 초기화
                ta.setText("");
                // 이름 전화번호 주소 값 가져오기
                String rname = Jt1.getText();
                String rposition = Jt3.getText();

                //입력된 이름 전화번호 con객체의 updatadata로 이름 기준으로 tel을 변경
                con.updateData2(rname, rposition);
                //입력창에 이름의 번호를 입력했던 번호로 수정완료했다고 출력
                ta.append("\n");
                ta.append("\t"+rname+" 포지션 "+ rposition +" 으로 수정완료\n");
                //입력했던 값 초기화
                Jt1.setText("");
                Jt2.setText("");
                Jt3.setText("");
                Jt4.setText("");
                jt5.setText("");
                jt6.setText("");

            }
        });
        //전체출력
        bjt3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //입력창 초기화
                ta.setText("");
                // 이름 전화번호 주소 값 가져오기

                //arraylist<Data> 객체 arr 생성

                ArrayList<Data> arr = new ArrayList<Data>();
                //arr 객체에 con객체에 readData 함수 를 대입
                arr = con.readData();
                //출력창에 이름 전화번호 주소 기준점 출력
                ta.append("\n");
                ta.append("    "+"    "+ "이름" + "\t" + "소속 팀" + "\t" + "포지션" + "\t"+ "닉네임" + "\n");
                ta.append("    "+"    "+  "----------------------------------------------------------------------------\n");
                //arr에 저장되있는 크기 만큼 이름,전화번호,주소를 반복 해서 출력
                for (int i = 0; i < arr.size(); i++) {
                    ta.append("    "+"    "+  arr.get(i).getName() + "\t" + arr.get(i).getTeam()
                            + "\t" + arr.get(i).getPosition()+"\t"+ arr.get(i).getAge()+"\n");
                }
            }
        });

        //삭제
        bjt4.addActionListener(new AbstractAction() { //삭제
            @Override
            public void actionPerformed(ActionEvent e) {
                //출력창 초기화
                ta.setText("");
                //입력 값을 이름 입력 값으로 가져오기
                String name =Jt1.getText();
                //con 객체에 있는 deletData 함수에 String 변수 name 을 대입해서 실행
                con.deleteData(name);
                //삭제 완료했다고 출력창에 출력
                ta.append("\n");
                ta.append("\t"+name +" 정보 삭제 완료 \n");
                //입력했던 값 초기화
                Jt1.setText("");
                Jt2.setText("");
                Jt3.setText("");
                Jt4.setText("");
                jt5.setText("");
                jt6.setText("");
            }
        });

        //팀 검색
        bjt5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //출력 창 초기화
                ta.setText("");
                //String 변수 content 를 jt4에 있는 값으로 가져오기
                String content = jt5.getText();
                //arraylist<data> arr 객체 생성
                ArrayList<Data> arr= new ArrayList<>();
                //arr객체에 con객체에 있는 searchData 함수에 content 입력해서 실행
                arr=con.searchData(content);
                //출력창에 기본으로 표시 되는 값 출력
                ta.append("\n");
                ta.append("    "+"    "+ "이름" + "\t" + "소속 팀" + "\t" + "포지션" + "\t"+ "닉네임" + "\n");
                ta.append("    "+"    "+ "----------------------------------------------------------------------------\n");
                //searchData 함수에 content 입력해서 맞는 값의 arr.size의 크기만큼 전부 출력
                for (int i = 0; i < arr.size(); i++) {
                    ta.append("    "+"    "+ arr.get(i).getName() + "\t" + arr.get(i).getTeam()
                            + "\t" + arr.get(i).getPosition()+"\t"+ arr.get(i).getAge()+"\n");
                }
                //입력 값 초기화
                Jt1.setText("");
                Jt2.setText("");
                Jt3.setText("");
                Jt4.setText("");
                jt5.setText("");
                jt6.setText("");

            }
        });
        //팀 변경
        bjt7.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //출력 창 초기화
                ta.setText("");
                // 이름 전화번호 주소 값 가져오기
                String name = Jt1.getText();
                String team =Jt2.getText();
                //입력된 이름 전화번호 con객체의 updatadata로 이름 기준으로 address을 변경
                con.updateData(name, team);
                //입력창에 이름의 주소를 입력했던 주소로 수정완료했다고 출력
                ta.append("\n");
                ta.append("\t"+name+" 팀 "+ team +" 으로 수정완료\n");
                //입력했던 값 초기화
                Jt1.setText("");
                Jt2.setText("");
                Jt3.setText("");
                Jt4.setText("");
                jt5.setText("");
                jt6.setText("");
            }
        }); //포지션 조회
        bjt8.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //출력 창 초기화
                ta.setText("");
                //String 변수 content 를 jt4에 있는 값으로 가져오기
                String content = jt6.getText();
                //arraylist<data> arr 객체 생성
                ArrayList<Data> arr= new ArrayList<>();
                //arr객체에 con객체에 있는 searchData 함수에 content 입력해서 실행
                arr=con.searchpositon(content);
                //출력창에 기본으로 표시 되는 값 출력
                ta.append("\n");
                ta.append("    "+"    "+ "이름" + "\t" + "소속 팀" + "\t" + "포지션" + "\t"+ "닉네임" + "\n");
                ta.append("    "+"    "+ "----------------------------------------------------------------------------\n");
                //searchData 함수에 content 입력해서 맞는 값의 arr.size의 크기만큼 전부 출력
                for (int i = 0; i < arr.size(); i++) {
                    ta.append("    "+"    "+ arr.get(i).getName() + "\t" + arr.get(i).getTeam()
                            + "\t" + arr.get(i).getPosition()+"\t"+ arr.get(i).getAge()+"\n");
                }
                //입력 값 초기화
                Jt1.setText("");
                Jt2.setText("");
                Jt3.setText("");
                Jt4.setText("");
                jt5.setText("");
                jt6.setText("");

            }
        });
        //종료 버튼
        bjt6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}



