package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxSPProd {

	public static void main(String[] args) {
		
		ArrayList<Integer> l = new ArrayList<>();
		l.add(7);
		l.add(5);
		l.add(7);
		l.add(9);
		l.add(8);
		l.add(7);
		//l.add(6);
		//l.add(9);
		//l.add(5);
		//l.add(4);
		//l.add(9);
		System.out.println(maxSpecialProduct(l));

	}
	
	public static int maxSpecialProduct(ArrayList<Integer> A){
		
		Stack<Integer> rightMaxStack = new Stack<>();
        int[] rightMaxArray = new int[A.size()];
        rightMaxStack.push(0);
        
        for(int i=1;i<A.size();i++){
            
            while(!rightMaxStack.isEmpty() && A.get(i)>A.get(rightMaxStack.peek())){
                int idx = (rightMaxStack.pop());
                rightMaxArray[idx] = i%1000000007;
            }
            rightMaxStack.push(i);
        }
        
        //System.out.println(Arrays.toString(rightMaxArray));
        Stack<Integer> leftMaxStack = new Stack<>();
        int[] leftMaxArray = new int[A.size()];
        leftMaxStack.push(A.size()-1);
        
        for(int i=A.size()-2;i>=0;i--){
            
            while(!leftMaxStack.isEmpty() && A.get(i)>A.get(leftMaxStack.peek())){
                int idx = (leftMaxStack.pop());
                leftMaxArray[idx] = i%1000000007;
            }
            leftMaxStack.push(i);
        }
        
        
        long max = 0;
        for(int i=0;i<A.size();i++){
            
            //if(leftMaxArray[i]<0 && rightMaxArray[i]<0)continue;
            
            long prod = ((leftMaxArray[i]%1000000007)*(rightMaxArray[i]%1000000007))%1000000007;
            if(prod>max){
                max = prod;
            }
        }
        //System.out.println(Arrays.toString(leftMaxArray));
        return (int)(max%1000000007);
	}

}
