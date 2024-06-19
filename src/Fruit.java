import javax.swing.*;

// 과일 클래스 정의
public class Fruit implements IconItem {
    private String fruitName;
    private ImageIcon fruitIcon;

    public Fruit(String name, String iconPath) {
        this.fruitName = name;
        this.fruitIcon = new ImageIcon(iconPath);
    }

    @Override
    public String getName() {
        return fruitName;
    }

    @Override
    public ImageIcon getIcon() {
        return fruitIcon;
    }
}