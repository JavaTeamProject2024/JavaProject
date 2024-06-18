import javax.swing.*;
import javax.swing.event.*;     // MyChangeListener 클래스를 사용하기 위해 import
import java.awt.*;


class TimerThread extends Thread {
    private JLabel timerLabel; // 타이머 값이 출력되는 레이블

    public TimerThread(JLabel timerLabel) {
        this.timerLabel = timerLabel; // 타이머 카운트를 출력할 레이블
    }
    // 스레드 코드. run()이 종료하면 스레드 종료
    @Override
    public void run() {
        int n=0; // 타이머 카운트 값
        while(true) { // 무한 루프
            timerLabel.setText(Integer.toString(n)); // 레이블에 카운트 값 출력
            n++; // 카운트 증가
            try {
                Thread.sleep(1000); // 1초 동안 잠을 잔다.
            }
            catch(InterruptedException e) {
                return; // 예외가 발생하면 스레드 종료
            }
        }
    }
}

public class Frame extends JFrame {
    private JSlider happySlider;

    public Frame() {
        setTitle("자바 팀 프로젝트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

        createMenuBar(); // 메뉴 생성, 프레임에 삽입
        ContentPane(); // 컨텐트 팬 생성, 프레임에 삽입

        setSize(1000, 800); // 프레임 크기
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

    // 컨텐트 팬 설정 및 컴포넌트 추가
    private void ContentPane() {
        Container contentPane = getContentPane(); // 컨텐트 팬을 알아낸다.
        contentPane.setBackground(Color.LIGHT_GRAY); // 컨텐트팬의 배경색을 회색으로 설정
        contentPane.setLayout(new FlowLayout()); // FlowLayout 배치관리자 설정

        WelcomeUser(contentPane); // WelcomeUser 컴포넌트 추가
        CheckBox(contentPane); // CheckBox 컴포넌트 추가
        SliderChange(contentPane); // SliderChange 컴포넌트 추가
        ThreadTimer(contentPane); // ThreadTimer 컴포넌트 추가
    }

    private void WelcomeUser(Container c) {
        c.setLayout(null); // 컨텐트팬의 배치관리자 제거

        // JLabel 컴포넌트 생성하고 위치와 크기를 직접 지정한다.
        JLabel welcome = new JLabel("사용자님, 안녕하세요!");
        welcome.setFont(new Font("Malgun Gothic", Font.PLAIN, 40)); // 폰트 설정
        welcome.setLocation(100, 50); // welcome를 (130,50) 위치로 지정
        welcome.setSize(400, 40); // welcome를 400x30 크기로 지정
        c.add(welcome); // welcome를 컨텐트팬에 부착

        // '이름' 라벨 필드
        JLabel Name = new JLabel("이름: ");
        Name.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
        Name.setLocation(100, 150);
        Name.setSize(200, 20);
        c.add(Name);

        // '이름' 입력 필드
        JTextField NameInput = new JTextField("");
        NameInput.setLocation(200, 150);
        NameInput.setSize(200, 40);
        c.add(NameInput);

        // '성별' 라벨 필드
        JLabel gender = new JLabel("성별: ");
        gender.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
        gender.setLocation(450, 150);
        gender.setSize(200, 40);
        c.add(gender);

        ButtonGroup buttonGroup = new ButtonGroup(); // 버튼 그룹 객체 생성
        JRadioButton male = new JRadioButton("남자"); // 라디오 버튼 생성
        male.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        JRadioButton female = new JRadioButton("여자");
        female.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        buttonGroup.add(male); // 버튼 그룹에 버튼 추가
        buttonGroup.add(female);

        male.setLocation(550, 150);
        male.setSize(100, 40);
        female.setLocation(650, 150);
        female.setSize(100, 40);

        c.add(male); // 컨텐트 팬에 버튼 추가
        c.add(female);

        // '나이' 라벨 필드
        JLabel Age = new JLabel("나이: ");
        Age.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Age.setLocation(100, 200);
        Age.setSize(200, 20);
        c.add(Age);

        // '나이' 입력 필드
        JTextField AgeInput = new JTextField("");
        AgeInput.setLocation(200, 200);
        AgeInput.setSize(200, 40);
        c.add(AgeInput);

        // '전화번호' 라벨 필드
        JLabel Phone = new JLabel("전화번호: ");
        Phone.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Phone.setLocation(450, 200);
        Phone.setSize(200, 20);
        c.add(Phone);

        // '전화번호' 입력 필드
        JTextField PhoneInput = new JTextField("");
        PhoneInput.setLocation(550, 200);
        PhoneInput.setSize(200, 40);
        c.add(PhoneInput);

        // '주소' 라벨 필드
        JLabel Address = new JLabel("사는 지역: ");
        Address.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Address.setLocation(100, 250);
        Address.setSize(200, 20);
        c.add(Address);

        // '주소' 입력 필드
        String[] AddressInput = {"서울", "부산", "그 외 광역시", "시/군/구"};
        JComboBox<String> addressCombo = new JComboBox<>(AddressInput);
        addressCombo.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        addressCombo.setLocation(200, 250);
        addressCombo.setSize(200, 40);
        c.add(addressCombo);

        // '확인' 버튼
        JButton OK = new JButton("확인");
        OK.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        OK.setLocation(530, 250);
        OK.setSize(100, 40);
        c.add(OK);

        // '취소' 버튼
        JButton Cancel = new JButton("취소");
        Cancel.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Cancel.setLocation(650, 250);
        Cancel.setSize(100, 40);
        c.add(Cancel);
    }

    // 체크박스
    private void CheckBox(Container c) {
        Fruit[] fruits = {
                new Fruit("사과", "images/apple.jpg", "images/selectedApple.jpg"),
                new Fruit("배", "images/pear.jpg", "images/selectedPear.jpg"),
                new Fruit("체리", "images/cherry.jpg", "images/selectedCherry.jpg"),
                new Fruit("멜론", "images/melon.jpg", "images/selectedMelon.jpg"),
                new Fruit("바나나", "images/banana.jpg", "images/selectedBanana.jpg")
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel("당신이 좋아하는 과일은 무엇인가요?");
        CheckBoxContent.setFont(new Font("Malgun Gothic", Font.BOLD, 30)); // 폰트 설정
        CheckBoxContent.setLocation(100, 350);
        CheckBoxContent.setSize(500, 40);
        c.add(CheckBoxContent);

        int startX = 100;
        int startY = 400;
        int gapX = 250;
        int gapY = 70;

        for (int i = 0; i < fruits.length; i++) {
            Fruit fruit = fruits[i];

            JCheckBox checkBox = new JCheckBox(fruit.getName(), fruit.getIcon());
            checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
            checkBox.setBorderPainted(true);
            //checkBox.setSelectedIcon(fruit.getSelectedIcon());

            checkBox.setBounds(startX + i%3 * gapX, startY + i/3 * gapY, 200, 60);
            c.add(checkBox);
        }
    }

    // 슬라이더
    private void SliderChange(Container c) {
        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel SliderContent = new JLabel("당신의 오늘의 기분은?");
        SliderContent.setFont(new Font("Malgun Gothic", Font.BOLD, 30)); // 폰트 설정
        SliderContent.setLocation(100, 650);
        SliderContent.setSize(500, 40);
        c.add(SliderContent);

        happySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);  // 슬라이더 생성 (수평, 최소값, 최대값, 초기값)
        happySlider.setPaintLabels(true);   // 눈금 레이블 표시
        happySlider.setPaintTicks(true);    // 눈금 표시
        happySlider.setPaintTrack(true);    // 트랙 표시
        happySlider.setMajorTickSpacing(25);    // 주 눈금 간격
        happySlider.setMinorTickSpacing(10);    // 보조 눈금 간격
        happySlider.setBounds(500, 650, 300, 60);    // 슬라이더 위치, 크기 설정
        c.add(happySlider);

    }

    // 타이머 스레드 클래스
    private void ThreadTimer(Container c) {
        // '타이머' 라벨 필드
        JLabel timerLabel = new JLabel("사용 시간(초)");
        timerLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        timerLabel.setLocation(850, 20);
        timerLabel.setSize(200, 20);
        c.add(timerLabel);

        // 타이머 값을 출력할 레이블 생성
        JLabel timer = new JLabel();
        timer.setFont(new Font("Gothic", Font.ITALIC, 50));
        timer.setBounds(880, 25, 100, 100); // 위치와 크기 설정

        // 레이아웃 매니저 해제 및 타이머 레이블 추가
        getContentPane().setLayout(null);
        getContentPane().add(timer);

        // 타이머 스레드 객체 생성. 타이머 값을 출력할 레이블을 생성자에 전달
        TimerThread th = new TimerThread(timer);
        th.start(); // 타이머 스레드의 실행을 시작하게 한다.
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
