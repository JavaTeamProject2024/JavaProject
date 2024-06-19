import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// java.lang.Runnable 인터페이스 상속
public class FallingTextGame extends JPanel implements Runnable {
    // 창 크기
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private static final int TEXT_SIZE = 30;    // 떨어지는 문자 크기
    private static final int INITIAL_SPEED = 1; // 최소 속도
    private static final int MAX_SPEED = 3;     // 최대 속도
    private static final String[] WORDS = {"자바", "스윙", "키보드", "게임", "코딩", "도전",
            "사과","체리","바나나","키위","딸기"};

    private List<FallingText> fallingTexts;
    private Random random;
    private JTextField inputField;
    private int score;
    private Font koreanFont;
    private String userInput;
    private boolean isGameOver;

    public FallingTextGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        // 상단 제목 패널 생성
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("타자 연습 게임을 해봅시다", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // 상단 버튼 패널 생성
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        JButton retryButton = new JButton("다시하기");
        JButton exitButton = new JButton("종료");

        exitButton.addActionListener(e -> System.exit(0));
        retryButton.addActionListener(e -> resetGame());

        buttonPanel.add(retryButton);
        buttonPanel.add(exitButton);

        add(topPanel, BorderLayout.NORTH);  // 제목 패널 위치
        topPanel.add(buttonPanel, BorderLayout.EAST); // 제목 패널 내에 버튼 생성

        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 0)); // 1행 2열의 그리드 레이아웃
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백 설정

        inputField = new JTextField(20); // 입력 창의 너비 설정
        inputField.setFont(koreanFont); // 입력 창 폰트 설정

        inputField.addActionListener(e -> handleSubmit()); // Enter 키 이벤트 처리

        JButton submitButton = new JButton("Submit"); // 제출 버튼 생성
        submitButton.addActionListener(e -> handleSubmit()); // 제출 버튼 리스너 설정

        inputPanel.add(inputField); // 입력 창 추가
        inputPanel.add(submitButton); // 제출 버튼 추가

        add(inputPanel, BorderLayout.SOUTH); // 입력 패널을 하단에 추가

        setFocusable(true);     // 컴포넌트 포커스
        requestFocusInWindow(); // New 패널에 포커스 설정

        // 시스템 폰트 중 한글을 지원하는 폰트 선택 (맑은 고딕, 돋움, 굴림 등)
        koreanFont = new Font("맑은 고딕", Font.PLAIN, TEXT_SIZE);

        fallingTexts = new ArrayList<>();
        random = new Random();
        score = 0;
        userInput = "";

        Thread thread = new Thread(this);
        thread.start();
    }

    // 입력 이벤트
    private void handleSubmit() {
        String inputText = inputField.getText().trim(); // 입력 받은 텍스트 얻기
        for (Iterator<FallingText> iterator = fallingTexts.iterator(); iterator.hasNext();) {
            FallingText text = iterator.next();
            if (text.getText().equals(inputText)) {
                score += 10; // 맞춘 경우 점수 증가
                iterator.remove(); // 리스트에서 해당 글자 제거
                break;
            }
        }
        userInput = ""; // 입력 초기화
        inputField.setText(""); // 입력 창 초기화
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isGameOver) {   // 점수 0점
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.RED);
            g.setFont(new Font("맑은 고딕", Font.BOLD, 50));
            g.drawString("Game Over", WIDTH / 2 - 150, HEIGHT / 2 - 50);

        } else {
            for (FallingText text : fallingTexts) {
                g.setColor(text.getColor()); // 글자 색상 설정
                g.setFont(koreanFont); // 한글 폰트 설정
                g.drawString(text.getText(), text.getX(), text.getY()); // FallingText 객체의 텍스트를 그림
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Score: " + score, 10, 50);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (!isGameOver) {
                updateGame();
                repaint();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {     // 게임 생성
        if (fallingTexts.isEmpty() || random.nextInt(100) < 4) {    // 난수에 따라 글자 생성
            spawnFallingText();
        }

        // 글자 위치 업데이트
        Iterator<FallingText> iterator = fallingTexts.iterator();
        while (iterator.hasNext()) {
            FallingText text = iterator.next();
            text.setY(text.getY() + text.getSpeed());

            // 화면 아래로 벗어난 글자 제거 및 점수 감점
            if (text.getY() > HEIGHT) {
                iterator.remove();
                score -= 5; // 화면 아래로 벗어난 경우 점수 감점
                if (score <= 0) {
                    isGameOver = true;
                }
            }
        }
    }

    private void resetGame() {      // 게임 재시작
        score = 0;
        fallingTexts.clear();
        isGameOver = false;
        setLayout(new BorderLayout()); // 원래 레이아웃 복원
        requestFocusInWindow(); // 포커스 재설정
    }

    // 떨어지는 글자 생성
    private void spawnFallingText() {
        String word = WORDS[random.nextInt(WORDS.length)];
        int x = random.nextInt(WIDTH - TEXT_SIZE);
        int speed = random.nextInt(MAX_SPEED - INITIAL_SPEED + 1) + INITIAL_SPEED;
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        fallingTexts.add(new FallingText(word, x, TEXT_SIZE, speed, color));
    }
}

class FallingText {
    private String text;
    private int x, y;
    private int speed;
    private Color color;

    public FallingText(String text, int x, int y, int speed, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }

    public void setY(int y) {
        this.y = y;
    }
}
