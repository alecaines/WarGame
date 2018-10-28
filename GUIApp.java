


import javax.swing.JFrame;

import propackage.Deck;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author lambertk
 *
 */
public class GUIApp{

    public static void main(String[] args){
        final JFrame view = new MainView();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 300);
        view.setVisible(true);
    }
}
