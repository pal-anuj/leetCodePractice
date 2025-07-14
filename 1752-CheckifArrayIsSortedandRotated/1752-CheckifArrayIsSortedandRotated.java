// Last updated: 15/07/2025, 00:36:08
class Solution {
    public boolean check(int[] arr) {

        // //GFG solution
        // int n= arr.length;
        // if(arr[n-1]<arr[0]){
        //     int pivotalPoint=0;
        //     for(int i=0; i<n-1; i++){
        //         if(arr[i+1] < arr[i])
        //             pivotalPoint++;
        //     }
        //     if(pivotalPoint==1) 
        //         return true; 
        // }else if(arr[n-1] > arr[0]){
        //     int pivotalPoint=0;
        //     for(int i=0; i<n-1; i++){
        //         if(arr[i+1] > arr[i])
        //             pivotalPoint++;
        //     }
        //     if(pivotalPoint==1) 
        //         return true;
        // }
        // return false;

        //My solution
        int n= arr.length;
        int j;
        //Checking if array is only sorted in Asc order
        for(j=1; j<n; j++){
            if(arr[j] < arr[j-1])
                break;
        }
        if(j==n)
            return true;

        // //Checking if array is only sorted in desc order
        // for(j=1; j<n; j++){
        //     if(arr[j] > arr[j-1])
        //         break;
        // }
        // if(j==n)
        //     return false;
        
        int asc=0;
        int dsc=0;
        for(int i=0; i<n; i++){
            if(arr[i] > arr[(i+1) % n])
                asc++;
            // if(arr[i] < arr[(i+1) % n])
            //     dsc++;
        }
        return (asc==1 );
    }
}