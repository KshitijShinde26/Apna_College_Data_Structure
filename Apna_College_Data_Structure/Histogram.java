import java.util.Stack;
public class Histogram {
    public static void main(String[] args){
        int[] height = {2,1,5,6,2,3};
        largestRectangleArea(height);
    }
    public static void largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nsr = new int[heights.length];
        int[] nsl = new int[heights.length];
        // Next Smaller Right
        Stack<Integer> stack = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                //-1 means there is no smaller element
                nsr[i] = heights.length;
            }else{
                //top element is smaller
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        // Next Smaller Left
        stack.clear();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        //current area
        for(int i=0;i<heights.length;i++){
            int width = nsr[i] - nsl[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }
}
