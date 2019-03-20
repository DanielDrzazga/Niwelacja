import javax.swing.*;

public class Main extends JFrame {
    private static final int WIDTH = 390;
    private static final int HEIGHT = 130;

    public Main() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Niwelacja ");
        frame.setPreferredSize(new java.awt.Dimension(410, 180));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        frame.pack();

        UserInterface ui = new UserInterface();

        frame.add(ui);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}