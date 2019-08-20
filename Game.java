import java.awt.*;
import javax.swing.*;

public class Game extends JPanel{
    static Image title;
    static JPanel panel;
    static JFrame frame;
    static JScrollPane scrollPane;
    static final int WINDOW_WIDTH = 1024;
    static final int WINDOW_HEIGHT = 600;
    static final int START_MENU = 0;
    static final int STORY_MODE = 1;
    static final int FINAL_MODE = 2;

    public static void main(String[] args) {
	    panel = new Game();
	    panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame = new JFrame("Teddy");
        frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);
        frame.setContentPane(panel);

        //Request Focus
        frame.requestFocus();
        frame.pack();
        frame.setVisible(true);


        // write your code here



//        while (firstBubble.getArray != NULL){
//
//        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font font = new Font("Jokerman", Font.BOLD, 13);
        g.setColor(Color.black);
        g.drawRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setFont(font);
        g.setColor(Color.white);

        Bubble firstBubble = new Bubble(1);
        firstBubble.loadFromFile();

        int xPosition = 0;
        int yPosition = 0;
        for(String line : firstBubble.getStory().split("\n")){
            g.drawString(line, xPosition, yPosition += g.getFontMetrics().getHeight());
        }

    } // paintComponent
}
