import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 메뉴바를 추상 클래스 묶음
 */
public abstract class Frame extends JFrame {

    // 메뉴바 생성
    public Frame() {
        JMenuBar mb = new JMenuBar(); // 메뉴바 생성

        // Screen 메뉴 생성
        JMenu screenMenu = new JMenu("Screen");
        // Screen 메뉴에 메뉴아이템 생성 삽입
        createScreen(screenMenu);

        // 메뉴바에 메뉴 삽입
        mb.add(screenMenu); // Screen 메뉴 삽입
        mb.add(new JMenu("Edit")); // Edit 메뉴 생성 삽입
        mb.add(new JMenu("Source")); // Source 메뉴 생성 삽입
        mb.add(new JMenu("Project")); // Project 메뉴 생성 삽입
        
        // Run 메뉴 생성 및 ActionListener 등록
        JMenu runMenu = new JMenu("Run");
        JMenuItem runItem = new JMenuItem("Run Falling Text Game");
        runItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Falling Text Game"); // 새로운 JFrame 생성
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 해당 JFrame 닫기
                FallingTextGame fallingTextPanel = new FallingTextGame(); // 객체 생성
                frame.getContentPane().add(fallingTextPanel); // 패널 프레임에 연결
                frame.pack();
                frame.setLocationRelativeTo(null); // 화면 중앙에 위치
                frame.setVisible(true); // JFrame 보이기
                fallingTextPanel.requestFocusInWindow(); // 패널에 포커스 설정
            }
        });
        runMenu.add(runItem);
        mb.add(runMenu); // Run 메뉴 삽입

        setJMenuBar(mb); // 메뉴바를 프레임에 부착
    }

    private static void createScreen(JMenu screenMenu) {
        screenMenu.add(new JMenuItem("Load"));
        screenMenu.add(new JMenuItem("Hide"));
        screenMenu.add(new JMenuItem("ReShow"));
        screenMenu.addSeparator(); // 분리선 삽입
        screenMenu.add(new JMenuItem("Exit"));
    }
}