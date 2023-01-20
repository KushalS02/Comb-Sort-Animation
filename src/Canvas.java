/**
 * @author Kushal Saini
 * @author Pelvain Dhanda
 * @author Nimrat Brar
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Canvas extends JPanel {

    private Rectangle rectArr[] = new Rectangle[MainDraw.getArrmax()];
    private int iterator;
    Color normColor = new Color(100, 149, 247);

    private final int rectWidth = 29; //29
    private final int rectPadding = 5; //5
    private final int rectHeightMultiplier = 3;
    private final int rectYPos = 400;

    private static final long serialVersionUID = 1L;

    // for initial and final
    public Canvas(int[] arr) {

        for (iterator = 0; iterator < MainDraw.getArrmax(); iterator++) {
            rectArr[iterator] = new Rectangle((iterator * (rectWidth + rectPadding)) + 10, rectYPos - (arr[iterator] * 3),
                    rectWidth, arr[iterator] * rectHeightMultiplier, normColor);
        }
    }

    // for highlight and fade
    public Canvas(int[] arr, int index1, int index2, Color color) {
        for (iterator = 0; iterator < MainDraw.getArrmax(); iterator++) {
            if (iterator != index1 && iterator != index2) {
                rectArr[iterator] = new Rectangle((iterator * (rectWidth + rectPadding) + 10), rectYPos - (arr[iterator] * 3),
                        rectWidth, arr[iterator] * rectHeightMultiplier, normColor);
            } else {
                rectArr[iterator] = new Rectangle((iterator * (rectWidth + rectPadding) + 10), rectYPos - (arr[iterator] * 3),
                        rectWidth, arr[iterator] * rectHeightMultiplier, color);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (iterator = 0; iterator < MainDraw.getArrmax(); iterator++) {
            rectArr[iterator].drawRect(g2d);
        }
    }
}

