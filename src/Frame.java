import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    public Frame() {
        setTitle("Menu 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

        createMenuBar(); // 메뉴 생성, 프레임에 삽입
        //ContentPane(); // 컨텐트 팬 생성, 프레임에 삽입
        WelcomeUser(); // GridLayoutEx 생성, 프레임에 삽입

        setSize(1000,800); // 프레임 크기
        setVisible(true); // 프레임 출력
    }


    // 메뉴바 생성
    private void createMenuBar() {
        JMenuBar mb = new JMenuBar(); // 메뉴바 생성

        // Screen 메뉴 생성
        JMenu screenMenu = new JMenu("Screen");
        // Screen 메뉴에 메뉴아이템 생성 삽입
        screenMenu.add(new JMenuItem("Load"));
        screenMenu.add(new JMenuItem("Hide"));
        screenMenu.add(new JMenuItem("ReShow"));
        screenMenu.addSeparator(); // 분리선 삽입
        screenMenu.add(new JMenuItem("Exit"));

        // 메뉴바에 메뉴 삽입
        mb.add(screenMenu); // Screen 메뉴 삽입
        mb.add(new JMenu("Edit")); // Edit 메뉴 생성 삽입
        mb.add(new JMenu("Source")); // Source 메뉴 생성 삽입
        mb.add(new JMenu("Project")); // Project 메뉴 생성 삽입
        mb.add(new JMenu("Run")); // Run 메뉴 생성 삽입

        setJMenuBar(mb); // 메뉴바를 프레임에 부착
    }


    // 9-2: 컨텐트 팬에 FlowLayout 배치관리자를 달고, 버튼을 달아준다.
    private void ContentPane() {
        Container contentPane = getContentPane(); // 컨텐트 팬을 알아낸다.
        contentPane.setBackground(Color.ORANGE); // 컨텐트팬의 배경색을 오렌지색으로 설정
        contentPane.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 배치관리자 달기

        contentPane.add(new JButton("OK")); // OK 버튼 달기
        contentPane.add(new JButton("Cancel")); // Cancel 버튼 달기
        contentPane.add(new JButton("Ignore")); // Ignore 버튼 달기
    }


    private void WelcomeUser() {
        Container c = getContentPane();
        c.setLayout(null); // 컨텐트팬의 배치관리자 제거

        // JLabel 컴포넌트 생성하고 위치와 크기를 직접  지정한다.
        JLabel welcome = new JLabel("Hello, Welcome User!");
        welcome.setLocation(130, 50); // welcome를 (130,50) 위치로 지정
        welcome.setSize(200, 20); // welcome를 200x20 크기로 지정
        c.add(welcome); // welcome를 컨텐트팬에 부착

        // '이름' 라벨 필드
        JLabel Name = new JLabel("이름: ");
        Name.setLocation(130, 150);
        Name.setSize(200, 20);
        c.add(Name);

        // '이름' 입력 필드
        JTextField NameInput = new JTextField("");
        NameInput.setLocation(230, 150);
        NameInput.setSize(200, 40);
        c.add(NameInput);

        // '나이' 라벨 필드
        JLabel Age = new JLabel("나이: ");
        Age.setLocation(130, 200);
        Age.setSize(200, 20);
        c.add(Age);

        // '나이' 입력 필드
        JTextField AgeInput = new JTextField("");
        AgeInput.setLocation(230, 200);
        AgeInput.setSize(200, 40);
        c.add(AgeInput);

        // '전화번호' 라벨 필드
        JLabel Phone = new JLabel("전화번호: ");
        Phone.setLocation(130, 250);
        Phone.setSize(200, 20);
        c.add(Phone);

        // '전화번호' 입력 필드
        JTextField PhoneInput = new JTextField("");
        PhoneInput.setLocation(230, 250);
        PhoneInput.setSize(200, 40);
        c.add(PhoneInput);

        // '확인' 버튼
        JButton OK = new JButton("확인");
        OK.setLocation(130, 300);
        OK.setSize(100, 40);
        c.add(OK);

        // '취소' 버튼
        JButton Cancel = new JButton("취소");
        Cancel.setLocation(230, 300);
        Cancel.setSize(100, 40);
        c.add(Cancel);
    }


    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}