import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    public Frame() {
        setTitle("Menu 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

        createMenu(); // 메뉴 생성, 프레임에 삽입
        ContentPane(); // 컨텐트 팬 생성, 프레임에 삽입

        setSize(1000,800); // 프레임 크기
        setVisible(true); // 프레임 출력
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


    // 메뉴바 생성
    private void createMenu() {
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

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}