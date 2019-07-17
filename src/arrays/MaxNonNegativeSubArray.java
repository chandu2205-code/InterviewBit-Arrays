package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>() {{
		    add(1);
		    add(0);
		    add(4);
		    add(0);
		    add(1);
		    add(-1);
		    add(-1);
		    add(0);
		    add(0);
		    add(1);
		    add(0);
		}};
		System.out.println(maxset(list));

	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int startIdx = 0,  endIdx = 0, segLength = 0, minStartIdx = 0;
        long sum = 0, maxSum = 0;
        for(int i=0;i<A.size();i++){
            startIdx = i;
            sum = 0;
            
            while(i<A.size() && A.get(i)>=0){
                sum+=A.get(i);
                i++;
            }
            //System.out.println(sum);
            if(sum>maxSum){
                maxSum = sum;
                minStartIdx = startIdx;
                endIdx = i-1;
                segLength = endIdx - minStartIdx;
            }else if(sum == maxSum && i-startIdx > segLength){
                minStartIdx = startIdx;
                endIdx = i-1;
                segLength = endIdx - minStartIdx;
            }
        }
        //System.out.println(minStartIdx+"........"+endIdx);
        if(endIdx == 0 && A.get(endIdx) < 0)return new ArrayList<Integer>();
        ArrayList<Integer> array= new ArrayList<Integer>(endIdx-minStartIdx+1);
        int k=0;
        for(int i=minStartIdx;i<=endIdx;i++){
            //array[k++] = arr[i];
            array.add(k++,A.get(i));
        }
        //System.out.println(Arrays.toString(array));
        return array;

    }

}
