package Lesson6.Homework;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class ShowTree extends JFrame {

    private static final int COUNT = 100;

    private JTree tree;

    private static ArrayList<Boolean> resultList = new ArrayList<>();

    public ShowTree()
    {
        BinaryTree bt = new BinaryTree();
        Random rnd = new Random();
        for (int i=0; i<100; i++) {
            bt.add(rnd.nextInt(200) - 100);
        }

        boolean result = bt.isBalanced();
        System.out.println(result);
        setResultList(result);

        tree = new JTree(bt.buildSwingTree());
        JScrollPane treeView = new JScrollPane(tree);
        treeView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        treeView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(treeView);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ShowTree();
                }
            });
        }
        Thread.sleep(COUNT * 100);
        System.out.printf("Процент несбалансированных деревьев: %f%%", percent());
    }

    private static float percent() {
        float result = 0f;
        for (Boolean bool : resultList){
            if (!bool){
                result += (float) 1 / resultList.size();
            }
        }

        return result * 100;
    }

    public static void setResultList(boolean result) {
        ShowTree.resultList.add(result);
    }
}
