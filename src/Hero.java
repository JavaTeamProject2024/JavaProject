import javax.swing.*;

public class Hero implements IconItem {
    private String heroName;
    private ImageIcon heroIcon;

    public Hero(String name, String iconPath) {
        this.heroName = name;
        this.heroIcon = new ImageIcon(iconPath);
    }

    @Override
    public String getName() {
        return heroName;
    }

    @Override
    public ImageIcon getIcon() {
        return heroIcon;
    }
}