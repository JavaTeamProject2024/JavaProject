import javax.swing.*;

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