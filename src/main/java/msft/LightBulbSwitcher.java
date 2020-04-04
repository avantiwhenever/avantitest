package msft;

public class LightBulbSwitcher {
    /*
     * https://leetcode.com/discuss/interview-question/502549/ Better explained -
     * https://leetcode.com/problems/bulb-switcher-iii/
     */
    public static void main(String args[]) {
        printResult(new int[] { 2, 1, 3, 5, 4 });
        printResult(new int[] { 3, 2, 4, 1, 5 });
        printResult(new int[] { 4, 1, 2, 3 });
        printResult(new int[] { 2, 1, 4, 3, 6, 5 });
        printResult(new int[] { 1, 2, 3, 4, 5, 6 });
        printResult(new int[] { 6, 5, 4, 3, 2, 1 });
        printResult(new int[] { 6 });
    }

    private static void printResult(int[] lights) {
        System.out.print("Integer list- [");
        for (int light : lights) {
            System.out.print(light + ", ");
        }
        System.out.print("] \n");
        System.out.println("Total moments when all bulbs are blue - " + numTimesAllBlue(lights));
        System.out.println();
    }

    public static int numTimesAllBlue(int[] light) {
        int rightMostLight = 0;
        int blueMoments = 0;
        int onLights = 0;

        for (int index = 0; index < light.length; index++) {
            rightMostLight = Math.max(rightMostLight, light[index]);
            onLights++;

            if (rightMostLight == onLights) {
                blueMoments++;
            }
        }

        return blueMoments;
    }
}
