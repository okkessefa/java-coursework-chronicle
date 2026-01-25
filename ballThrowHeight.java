import java.util.Scanner;
public class ballThrowHeight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a hight to throw the ball: ");
        // Starting height from which the ball is dropped
        int height = scan.nextInt();
        
        // Counts how many times the ball hits the ground and rebounds
        int baunchCount = 0;
        
        
        while(height>1){
            // At the start of each cycle, the ball drops from the current height
            int droppedHeight = height;
            
            // Print the downward movement in 3-unit steps
            for(int top = droppedHeight; top>0; top-=3){
                System.out.print(top +" ");
            }
            // The loop does not print the ground level, so we print 0 explicitly
            System.out.print("0");
            System.out.println();
            
            // According to the problem, the next peak height is 75% of the previous height
            height = (int)(height * 0.75);
            
            // Compute the next height to verify whether another bounce is possible
            int newHeight = (int)(0.75*height);
            // If the next height is not positive, stop the simulation
            if(newHeight <= 0) break;
            
            // After the ball reaches the ground, increase the bounce counter
            baunchCount++;
            // Update the height to the next rebound height 
            height = newHeight;
            
            // Track the last printed value because the loop may not reach the exact peak
            int last = 0;
            // Print the upward movement in 3-unit steps
            for(int up = 0; up<height; up+=3){
                System.out.print(up + " ");
                last = up;
            }
            // If the last printed value is not the peak, print the exact peak height
            if(last != height) System.out.print(height);
            
            System.out.println();
        }
        System.out.println(baunchCount+" times bounced from ground");
        
    }
    
}
