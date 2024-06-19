import javax.swing.*;
import java.awt.*;

public class NewFrame extends Frame {

    public NewFrame() {
        super();
        setTitle("자바 팀 프로젝트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

        ContentPane(); // 컨텐트 팬 생성, 프레임에 삽입
        setSize(1000, 800); // 프레임 크기
        setVisible(true); // 프레임 출력
    }

    // 컨텐트 팬 설정 및 컴포넌트 추가
    private void ContentPane() {
        Container contentPane = getContentPane(); // 컨텐트 팬을 알아낸다.
        contentPane.setBackground(Color.LIGHT_GRAY); // 컨텐트팬의 배경색을 회색으로 설정
        contentPane.setLayout(new FlowLayout()); // FlowLayout 배치관리자 설정

        /**
         * 여기에 수빈씨가 작성한 코드를 추가해주세요.
         */
    }

    /**
     * 메서드 구현하고 위에 넣으면 됩니다.
     */

}