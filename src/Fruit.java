import javax.swing.*;

// 과일 클래스 정의
public class Fruit {
    private String name;
    private ImageIcon icon;
    private ImageIcon selectedIcon;

    public Fruit(String name, String iconPath, String selectedIconPath) {
        this.name = name;
        this.icon = new ImageIcon(iconPath);
        this.selectedIcon = new ImageIcon(selectedIconPath);
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

//    public ImageIcon getSelectedIcon() {
//        return selectedIcon;
//    }
}