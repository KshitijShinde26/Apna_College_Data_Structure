import java.util.*;
public class StringShortestPath {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string in (W/N/E/S) format:");
        String path = sc.nextLine();
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char direction = path.charAt(i);
            switch(direction){
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                default:
                    System.out.println("Invalid direction: " + direction);
            }
        }
        System.out.println("Final Coordinates: (" + x + ", " + y + ")");
        int r = x*x + y*y;
        int s = (int) Math.sqrt(r);
        System.out.println("Shortest Path from (0,0) to (" + x + "," + y + ") is: " + s);
        sc.close();
    }
}
