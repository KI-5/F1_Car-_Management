import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DefineButtons extends JButton {

    /**
     *
     * @param title button title
     * @param listener button event
     */
    public DefineButtons(String title, ActionListener listener) {

        this.setText(title);
        //set the button title

        this.setSize(135, 48);
        //set button size

        this.addActionListener(listener);
        //event listener

        this.setFont(new Font("Times New Roman", Font.BOLD, 15));
        //set the font styles

        this.setBackground(new Color(0x446561));
        //button background colour

        this.setForeground(new Color(0xFFFFFF));
        //button text colour

        this.setOpaque(false);

        this.setVisible(true);

    }

}
