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
        setLocation(0, 0);
        setVisible(true); // 프레임 출력
    }

    // 컨텐트 팬 설정 및 컴포넌트 추가
    private void ContentPane(String name, String gender, String age, String phone, String address,
                             String fruit, String hero, int moodValue) {
        Container contentPane = getContentPane(); // 컨텐트 팬을 알아낸다.
        contentPane.setBackground(Color.white); // 컨텐트팬의 배경색을 회색으로 설정
        contentPane.setLayout(new FlowLayout()); // FlowLayout 배치관리자 설정

        WelcomeUser(contentPane, name, gender, age, phone, address); // WelcomeUser 컴포넌트 추가
        FruitCheckbox(contentPane, fruit, name); // FruitCheckBox 컴포넌트 추가
        HeroCheckbox(contentPane, hero, name); // HeroCheckbox 컴포넌트 추가
        SliderChange(contentPane, moodValue, name); // SliderChange 컴포넌트 추가
    }

    private void WelcomeUser(Container c, String name, String gen, String age, String phone, String address) {
        c.setLayout(null); // 컨텐트팬의 배치관리자 제거

        // JLabel 컴포넌트 생성하고 위치와 크기를 직접 지정한다.
        JLabel welcome = new JLabel(String.format("%s님이 입력하신 정보입니다.", name));
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
        JLabel NameInput = new JLabel(name);
        NameInput.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
        NameInput.setLocation(200, 110);
        NameInput.setSize(200, 40);
        c.add(NameInput);

        // '성별' 라벨 필드
        JLabel gender = new JLabel("성별: ");
        gender.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
        gender.setLocation(450, 120);
        gender.setSize(200, 40);
        c.add(gender);

        // 초기 선택 설정
        if (gen.equals("남자")) {
            JLabel male = new JLabel("남자");
            male.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
            male.setLocation(500, 120);
            male.setSize(200, 40);
            c.add(male);
        } else if (gen.equals("여자")) {
            JLabel female = new JLabel("여자");
            female.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
            female.setLocation(500, 120);
            female.setSize(200, 40);
            c.add(female);
        }

        // '나이' 라벨 필드
        JLabel Age = new JLabel("나이: ");
        Age.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Age.setLocation(100, 170);
        Age.setSize(200, 20);
        c.add(Age);

        // '나이' 입력 필드
        JLabel AgeInput = new JLabel(age);
        AgeInput.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        AgeInput.setLocation(200, 160);
        AgeInput.setSize(200, 40);
        c.add(AgeInput);

        // '전화번호' 라벨 필드
        JLabel Phone = new JLabel("전화번호: ");
        Phone.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Phone.setLocation(450, 170);
        Phone.setSize(200, 20);
        c.add(Phone);

        // '전화번호' 입력 필드
        JLabel PhoneInput = new JLabel(phone);
        PhoneInput.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        PhoneInput.setLocation(550, 160);
        PhoneInput.setSize(200, 40);
        c.add(PhoneInput);

        // '주소' 라벨 필드
        JLabel Address = new JLabel("사는 지역: ");
        Address.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        Address.setLocation(100, 220);
        Address.setSize(200, 20);
        c.add(Address);

        // '주소' 입력 필드
        JLabel AddressInput = new JLabel(address);
        AddressInput.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
        AddressInput.setLocation(200, 210);
        AddressInput.setSize(200, 40);
        c.add(AddressInput);
    }

    // 체크박스 - 과일
    private void FruitCheckbox(Container c, String selectedFruit, String name) {
        Fruit[] fruits = {
                new Fruit("사과", "images/apple.jpg"),
                new Fruit("배", "images/pear.jpg"),
                new Fruit("체리", "images/cherry.jpg"),
                new Fruit("키위", "images/kiwi.jpg"),
                new Fruit("바나나", "images/banana.jpg")
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel(String.format("%s님이 좋아하는 과일입니다", name));
        CheckBoxContent.setFont(new Font("Malgun Gothic", Font.BOLD, 15)); // 폰트 설정
        CheckBoxContent.setLocation(50, 270);
        CheckBoxContent.setSize(400, 40);
        c.add(CheckBoxContent);

        for (int i = 0; i < fruits.length; i++) {
            Fruit fruit = fruits[i];

            JCheckBox checkBox = new JCheckBox(fruit.getName(), fruit.getIcon());
            if (fruit.getName().equals(selectedFruit)) {
                checkBox.setForeground(Color.RED);
                checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
                checkBox.setBorderPainted(true);

                checkBox.setBounds(50, 330, 100, 60);
                c.add(checkBox);
            }
        }
    }

    // 체크박스 - 히어로
    private void HeroCheckbox(Container c, String selectedHero, String name) {
        Hero[] heroes = {
                new Hero("스파이더 맨", "images/spider_man.jpg"),
                new Hero("원더 우먼", "images/wonder_woman.jpg"),
        };

        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel CheckBoxContent = new JLabel(String.format("%s님이 더 선호하는 히어로입니다", name));
        CheckBoxContent.setFont(new Font("Malgun Gothic", Font.BOLD, 15)); // 폰트 설정
        CheckBoxContent.setLocation(400, 270);
        CheckBoxContent.setSize(400, 40);
        c.add(CheckBoxContent);

        for (int i = 0; i < heroes.length; i++) {
            Hero hero = heroes[i];

            JCheckBox checkBox = new JCheckBox(hero.getName(), hero.getIcon());
            if (hero.getName().equals(selectedHero)) {
                checkBox.setForeground(Color.RED);
                checkBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
                checkBox.setBorderPainted(true);

                checkBox.setBounds(400, 330, 240, 200);
                c.add(checkBox);
            }
        }
    }

    // 슬라이더
    private void SliderChange(Container c, int moodValue, String name) {
        // 체크박스의 내용을 표시할 레이블 컴포넌트 생성
        JLabel SliderContent = new JLabel(String.format("%s님의 오늘 기분입니다", name));
        SliderContent.setFont(new Font("Malgun Gothic", Font.BOLD, 30)); // 폰트 설정
        SliderContent.setLocation(100, 650);
        SliderContent.setSize(500, 40);
        c.add(SliderContent);

        String value = String.valueOf(moodValue);
        JLabel SliderValue = new JLabel(value);
        SliderValue.setFont(new Font("Malgun Gothic", Font.BOLD, 30)); // 폰트 설정
        SliderValue.setLocation(500, 650);
        SliderValue.setSize(50, 40);
        c.add(SliderValue);
    }
}