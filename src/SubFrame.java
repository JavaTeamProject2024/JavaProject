import javax.swing.*;
import java.awt.*;

/**
 * 메뉴바를 가진 프레임을 생성하는 클래스
 */
public class SubFrame extends Frame {

    public SubFrame(String name, String gender, String age, String phone, String address,
                    String fruit, String hero, int happyValue) {
        super();
        setTitle("서브 페이지");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

        ContentPane(name, gender, age, phone, address, fruit, hero, happyValue); // 컨텐트 팬 생성, 프레임에 삽입
        setSize(1000, 800); // 프레임 크기
        setLocation(800, 0);
        setVisible(true); // 프레임 출력
    }

    // 컨텐트 팬 설정 및 컴포넌트 추가
    private void ContentPane(String name, String gender, String age, String phone, String address,
                             String fruit, String hero, int moodValue) {
        Container contentPane = getContentPane(); // 컨텐트 팬을 알아낸다.
        contentPane.setBackground(Color.LIGHT_GRAY); // 컨텐트팬의 배경색을 회색으로 설정
        contentPane.setLayout(new FlowLayout()); // FlowLayout 배치관리자 설정

        WelcomeUser(contentPane, name, gender, age, phone, address); // WelcomeUser 컴포넌트 추가
        FruitCheckbox(contentPane, fruit); // FruitCheckBox 컴포넌트 추가
        HeroCheckbox(contentPane, hero); // HeroCheckbox 컴포넌트 추가
        SliderChange(contentPane, moodValue); // SliderChange 컴포넌트 추가
    }

    private void WelcomeUser(Container c, String name, String gen, String age, String phone, String address) {
        c.setLayout(null); // 컨텐트팬의 배치관리자 제거

        // JLabel 컴포넌트 생성하고 위치와 크기를 직접 지정한다.
        JLabel welcome = new JLabel("사용자님이 입력하신 정보입니다.");
        welcome.setFont(new Font("Malgun Gothic", Font.PLAIN, 30)); // 폰트 설정
        welcome.setLocation(100, 50); // welcome를 (130,50) 위치로 지정
        welcome.setSize(500, 40); // welcome를 400x30 크기로 지정
        c.add(welcome); // welcome를 컨텐트팬에 부착

        // '이름' 라벨 필드
        JLabel Name = new JLabel("이름:");
        Name.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
        Name.setLocation(100, 120);
        Name.setSize(200, 20);
        c.add(Name);

        // '이름' 입력 필드
        JTextField NameInput = new JTextField(name);
        NameInput.setLocation(200, 120);
        NameInput.setSize(200, 40);
        c.add(NameInput);

        // '성별' 라벨 필드
        JLabel gender = new JLabel("성별: ");
        gender.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
        gender.setLocation(450, 120);
        gender.setSize(200, 40);
        c.add(gender);

        ButtonGroup buttonGroup = new ButtonGroup(); // 버튼 그룹 객체 생성
        JRadioButton male = new JRadioButton("남자"); // 라디오 버튼 생성
        male.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        JRadioButton female = new JRadioButton("여자");
        female.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        buttonGroup.add(male); // 버튼 그룹에 버튼 추가
        buttonGroup.add(female);

        male.setLocation(550, 120);
        male.setSize(100, 40);
        female.setLocation(650, 120);
        female.setSize(100, 40);

        c.add(male); // 컨텐트 팬에 버튼 추가
        c.add(female);

        // 초기 선택 설정
        if (gen.equals("남자")) {
            male.setSelected(true);
        } else if (gen.equals("여자")) {
            female.setSelected(true);
        }

        // '나이' 라벨 필드
        JLabel Age = new JLabel("나이: ");
        Age.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Age.setLocation(100, 170);
        Age.setSize(200, 20);
        c.add(Age);

        // '나이' 입력 필드
        JTextField AgeInput = new JTextField(age);
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
        JTextField PhoneInput = new JTextField(phone);
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
        JTextField AddressInput = new JTextField(address);
        AddressInput.setLocation(200, 220);
        AddressInput.setSize(200, 40);
        c.add(AddressInput);
    }

    // 체크박스 - 과일
    private void FruitCheckbox(Container c, String selectedFruit) {
        Fruit[] fruits = {
                new Fruit("사과", "images/apple.jpg"),
                new Fruit("배", "images/pear.jpg"),
                new Fruit("체리", "images/cherry.jpg"),
                new Fruit("키위", "images/kiwi.jpg"),
                new Fruit("바나나", "images/banana.jpg")
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel("당신이 좋아하는 과일입니다");
        CheckBoxContent.setFont(new Font("Malgun Gothic", Font.BOLD, 15)); // 폰트 설정
        CheckBoxContent.setLocation(50, 270);
        CheckBoxContent.setSize(400, 40);
        c.add(CheckBoxContent);

        int startX = 50;
        int startY = 330;
        int gapX = 130;
        int gapY = 70;

        for (int i = 0; i < fruits.length; i++) {
            Fruit fruit = fruits[i];

            JCheckBox checkBox = new JCheckBox(fruit.getName(), fruit.getIcon());
            if (fruit.getName().equals(selectedFruit)) {
                checkBox.setForeground(Color.RED);
            }
            checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            checkBox.setBorderPainted(true);

            checkBox.setBounds(startX + i%2 * gapX, startY + i/2 * gapY, 100, 60);
            c.add(checkBox);
        }
    }

    // 체크박스 - 히어로
    private void HeroCheckbox(Container c, String selectedHero) {
        Hero[] heroes = {
                new Hero("스파이더 맨", "images/spider_man.jpg"),
                new Hero("원더 우먼", "images/wonder_woman.jpg"),
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel("당신이 더 선호하는 히어로입니다");
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
            if (hero.getName().equals(selectedHero)) {
                checkBox.setForeground(Color.RED);
            }
            checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            checkBox.setBorderPainted(true);

            checkBox.setBounds(startX + i%2 * gapX, startY, 240, 200);
            c.add(checkBox);
        }
    }

    // 슬라이더
    private void SliderChange(Container c, int moodValue) {
        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel SliderContent = new JLabel("당신의 오늘 기분입니다");
        SliderContent.setFont(new Font("Malgun Gothic", Font.BOLD, 30)); // 폰트 설정
        SliderContent.setLocation(100, 650);
        SliderContent.setSize(500, 40);
        c.add(SliderContent);

        JSlider happySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, moodValue);  // 슬라이더 생성 (수평, 최소값, 최대값, 초기값)
        happySlider.setPaintLabels(true);   // 눈금 레이블 표시
        happySlider.setPaintTicks(true);    // 눈금 표시
        happySlider.setPaintTrack(true);    // 트랙 표시
        happySlider.setMajorTickSpacing(25);    // 주 눈금 간격
        happySlider.setMinorTickSpacing(10);    // 보조 눈금 간격
        happySlider.setBounds(500, 650, 300, 60);    // 슬라이더 위치, 크기 설정
        c.add(happySlider);
    }
}