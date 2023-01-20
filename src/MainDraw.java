/**
 * @author Kushal Saini
 * @author Pelvain Dhanda
 * @author Nimrat Brar
 */

import java.awt.Color;

import javax.swing.JFrame;

public class MainDraw {

    static JFrame f = new JFrame();
    static Canvas animation;
    static final int frameTime = 325; //325
    static final int canvasWidth = 720;
    static final int canvasHeight = 480;
    static final int arrMax = 20; //20
    static final int maxValue = 130;
    static int arr[] = new int[arrMax];

    public static void main(String[] args) {

        for (int i = 0; i < arrMax; i++) {
            arr[i] = randomNum(arrMax);
            System.out.print(arr[i] + " ");
        }

        drawInitial();
        sort(arr);
        drawFinal();
    }

    private static void drawInitial() {
        animation = new Canvas(arr);
        f.setSize(canvasWidth,canvasHeight);
        f.setTitle("Comb Sort Algo. Animation");
        f.add(animation);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static void drawFinal() {
        f.remove(animation);
        animation = new Canvas(arr);
        f.setSize(canvasWidth,canvasHeight);
        f.setTitle("Comb Sort Algo. Animation");
        f.add(animation);
        f.repaint();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static void drawHighlight(int index1, int index2) {
        try {
            Thread.sleep(frameTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f.remove(animation);
        Color highlight = new Color(245, 78, 66);
        animation = new Canvas(arr, index1, index2, highlight);
        f.add(animation);
        f.repaint();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static void drawFadeOut(int index1, int index2) {
        Color fade;
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(frameTime/5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.remove(animation);
            fade = new Color(245, 78, 66, 255 - i*51);
            animation = new Canvas(arr, index1, index2, fade);
            f.add(animation);
            f.repaint();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
    }

    private static void drawFadeIn(int index1, int index2) {
        Color fade;
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(frameTime/5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.remove(animation);
            fade = new Color(245, 78, 66, 0 + i*51);
            animation = new Canvas(arr, index1, index2, fade);
            f.add(animation);
            f.repaint();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
    }

    private static int randomNum(int max) {
        double rand = Math.random() * maxValue+1;
        //System.out.println(rand);
        return (int)rand;
    }

    public static int getArrmax() {
        return arrMax;
    }

    /**
     * CombSort algorithm from:
     * https://www.geeksforgeeks.org/comb-sort/
     */

    private static int updateGap(int gap)
    {
        // Shrink gap by Shrink factor
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    private static void sort(int arr[])
    {
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = updateGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i=0; i<n-gap; i++)
            {
                drawHighlight(i, i+gap);
                if (arr[i] > arr[i+gap])
                {
                    //drawSwap
                    // fade animations, switch heights
                    // Swap arr[i] and arr[i+gap]
                    drawFadeOut(i, i+gap);
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;
                    drawFadeIn(i, i+gap);
                    // Set swapped
                    swapped = true;
                }
            }
        }
    }
}
