import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 메뉴바를 가진 프레임을 생성하는 클래스
 */
public class MainFrame extends Frame {

    private JSlider happySlider;

    private String name;
    private String gender;
    private String age;
    private String phoneNum;
    private String address;
    private String favoriteFruit;
    private String favoriteHero;


    public MainFrame() {
        super();
        setTitle("메인 페이지");
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

        WelcomeUser(contentPane); // WelcomeUser 컴포넌트 추가
        FruitCheckbox(contentPane); // FruitCheckBox 컴포넌트 추가
        HeroCheckbox(contentPane); // HeroCheckbox 컴포넌트 추가
        SliderChange(contentPane);// SliderChange 컴포넌트 추가
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
        Name.setLocation(100, 120);
        Name.setSize(200, 20);
        c.add(Name);

        // '이름' 입력 필드
        JTextField NameInput = new JTextField("");
        NameInput.setLocation(200, 120);
        NameInput.setSize(200, 40);
        c.add(NameInput);

        // 라디오 버튼 그룹 생성
        ButtonGroup buttonGroup = new ButtonGroup();

        // '남자' 라디오 버튼
        JRadioButton male = new JRadioButton("남자");
        male.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        male.setBounds(550, 120, 100, 40);
        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = "남자"; // '남자' 선택 시 gender 변수에 저장
            }
        });
        buttonGroup.add(male);
        c.add(male);

        // '여자' 라디오 버튼
        JRadioButton female = new JRadioButton("여자");
        female.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        female.setBounds(650, 120, 100, 40);
        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = "여자"; // '여자' 선택 시 gender 변수에 저장
            }
        });
        buttonGroup.add(female);
        c.add(female);

        // '나이' 라벨 필드
        JLabel Age = new JLabel("나이: ");
        Age.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Age.setLocation(100, 170);
        Age.setSize(200, 20);
        c.add(Age);

        // '나이' 입력 필드
        JTextField AgeInput = new JTextField("");
        AgeInput.setLocation(200, 170);
        AgeInput.setSize(200, 40);
        c.add(AgeInput);

        // '전화번호' 라벨 필드
        JLabel Phone = new JLabel("전화번호: ");
        Phone.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Phone.setLocation(450, 170);
        Phone.setSize(200, 20);
        c.add(Phone);

        // '전화번호' 입력 필드
        JTextField PhoneInput = new JTextField("");
        PhoneInput.setLocation(550, 170);
        PhoneInput.setSize(200, 40);
        c.add(PhoneInput);

        // '주소' 라벨 필드
        JLabel Address = new JLabel("사는 지역: ");
        Address.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Address.setLocation(100, 220);
        Address.setSize(200, 20);
        c.add(Address);

        // '주소' 입력 필드
        String[] AddressInput = {"서울", "부산", "그 외 광역시", "시/군/구"};
        JComboBox<String> addressCombo = new JComboBox<>(AddressInput);
        addressCombo.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        addressCombo.setLocation(200, 220);
        addressCombo.setSize(200, 40);
        c.add(addressCombo);

        // '확인' 버튼
        JButton OK = new JButton("확인");
        OK.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        OK.setLocation(530, 220);
        OK.setSize(100, 40);
        c.add(OK);

        // 확인 버튼을 누르면 새로운 Frame이 생성되고 현재 Frame을 닫음
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = NameInput.getText();
                age = AgeInput.getText();
                phoneNum = PhoneInput.getText();
                address = (String) addressCombo.getSelectedItem();
                int happyValue = happySlider.getValue();
                // 새로운 Frame을 생성하고 현재 Frame을 닫음
                SubFrame resultFrame = new SubFrame(name, gender, age, phoneNum, address, favoriteFruit, favoriteHero, happyValue);
                resultFrame.setVisible(true);
                dispose(); // 현재 프레임을 닫음
            }
        });

        // '취소' 버튼
        JButton Cancel = new JButton("취소");
        Cancel.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Cancel.setLocation(650, 220);
        Cancel.setSize(100, 40);
        c.add(Cancel);
    }

    // 체크박스 - 과일
    private void FruitCheckbox(Container c) {
        Fruit[] fruits = {
                new Fruit("사과", "images/apple.jpg"),
                new Fruit("배", "images/pear.jpg"),
                new Fruit("체리", "images/cherry.jpg"),
                new Fruit("키위", "images/kiwi.jpg"),
                new Fruit("바나나", "images/banana.jpg")
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel("당신이 좋아하는 과일은 무엇인가요?");
        CheckBoxContent.setFont(new Font("Malgun Gothic", Font.BOLD, 15)); // 폰트 설정
        CheckBoxContent.setLocation(50, 270);
        CheckBoxContent.setSize(400, 40);
        c.add(CheckBoxContent);

        int startX = 50;
        int startY = 330;
        int gapX = 130;
        int gapY = 70;

        // 과일 체크박스 생성 및 ActionListener 추가
        for (int i = 0; i < fruits.length; i++) {
            Fruit fruit = fruits[i];

            JCheckBox checkBox = new JCheckBox(fruit.getName(), fruit.getIcon());
            checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            checkBox.setBorderPainted(true);
            checkBox.setBounds(startX + i % 2 * gapX, startY + i / 2 * gapY, 100, 60);
            c.add(checkBox);

            // ActionListener 추가
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        favoriteFruit = fruit.getName(); // 선택된 과일 이름을 변수에 저장
                        System.out.println("선택된 과일: " + favoriteFruit); // 확인을 위해 콘솔에 출력
                    }
                }
            });
        }
    }

    // 체크박스 - 히어로
    private void HeroCheckbox(Container c) {
        Hero[] heroes = {
                new Hero("스파이더 맨", "images/spider_man.jpg"),
                new Hero("원더 우먼", "images/wonder_woman.jpg"),
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel("당신이 더 선호하는 히어로 무엇인가요?");
        CheckBoxContent.setFont(new Font("Malgun Gothic", Font.BOLD, 15)); // 폰트 설정
        CheckBoxContent.setLocation(500, 270);
        CheckBoxContent.setSize(400, 40);
        c.add(CheckBoxContent);

        int startX = 400;
        int startY = 330;
        int gapX = 250;

        for (int i = 0; i < heroes.length; i++) {
            Hero hero = heroes[i];

            JCheckBox checkBox = new JCheckBox(hero.getName(), hero.getIcon());
            checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            checkBox.setBorderPainted(true);

            checkBox.setBounds(startX + i%2 * gapX, startY, 240, 200);
            c.add(checkBox);

            // ActionListener 추가
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        favoriteHero = hero.getName(); // 선택된 과일 이름을 변수에 저장
                        System.out.println("선택된 히어로: " + favoriteHero); // 확인을 위해 콘솔에 출력
                    }
                }
            });
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
        timer.setBounds(890, 25, 100, 100); // 위치와 크기 설정

        // 레이아웃 매니저 해제 및 타이머 레이블 추가
        getContentPane().setLayout(null);
        getContentPane().add(timer);

        // 타이머 스레드 객체 생성. 타이머 값을 출력할 레이블을 생성자에 전달
        TimerThread th = new TimerThread(timer);
        th.start(); // 타이머 스레드의 실행을 시작하게 한다.
    }
}