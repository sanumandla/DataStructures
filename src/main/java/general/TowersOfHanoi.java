package main.java.general;

/**
 * Created by sridhar.anumandla on 1/29/15.
 */
public class TowersOfHanoi {

    public void moveSingleDisk(char start, char finish) {
        System.out.println("Move disk from " + start + " to " + finish);
    }

    public void moveTower(int numberOfDisks, char start, char finish, char temp) {
        if (numberOfDisks == 1) {
            moveSingleDisk(start, finish);
        } else {
            moveTower(numberOfDisks - 1, start, temp, finish);
            moveSingleDisk(start, finish);
            moveTower(numberOfDisks - 1, temp, finish, start);
        }
    }

    public static void main(String[] args) {
        int numberOfDisks = 5;
        char start = 'A';
        char finish = 'B';
        char temp = 'C';

        new TowersOfHanoi().moveTower(numberOfDisks, start, finish, temp);
    }

}
