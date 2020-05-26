package epi;

public class RectangleIntersection {
/*
Write a program which tests if two rectangles have a nonempty intersection. If the
intersection is nonempty, return the rectangle formed by their intersection.
 */

    public static class Rectangle {
        int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("x = ");
            sb.append(x);
            sb.append(" y = ");
            sb.append(y);
            sb.append(" width = ");
            sb.append(width);
            sb.append(" height = ");
            sb.append(height);
            return sb.toString();
        }
    }

    public static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width &&  r1.x + r1.width >= r2.x &&
                r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y;
    }

    public static Rectangle isIntersectRectangle(Rectangle r1, Rectangle r2) {
        if(!isIntersect(r1, r2)) {
            return new Rectangle(0, 0, -1, -1);
        }
        int newX = Math.max(r1.x, r2.x);
        int newY = Math.max(r1.y, r2.y);
        int newWidth = Math.min(r1.x + r1.width , r2.x + r2.width) - newX;
        int newHeight = Math.min(r1.y + r1.height , r2.y + r2.height) - newY;
        return new Rectangle(newX , newY, newWidth, newHeight);
    }
    /*
        The time complexity is 0(1), since the number of operations is constant.
        The space complexity is 0(1), since the number of operations is constant.

     */

    public static void main(String args[]) {
        Rectangle r1 = new Rectangle(4,5,2,5);
        Rectangle r2 = new Rectangle(4,5,2,5);

       Rectangle result =  isIntersectRectangle(r1, r2);
       System.out.println("result " + result.toString());
    }
}
