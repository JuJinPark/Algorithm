package main.java.leetcode.hard;

public class MedianofTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
           return findMedianSortedArrays(nums2,nums1);
        }

        int low=0;
        int high=nums1.length;
        boolean isEven=false;
        if((nums1.length+nums2.length)%2==0){
            isEven=true;
        }

        int median=(nums1.length+nums2.length+1)/2;
        while(low<=high){
            int num1CutPoint=(low+high)/2;
            int num2CutPoint=median-num1CutPoint;

            int maxLeftNumInNums1=(num1CutPoint==0)?Integer.MIN_VALUE:nums1[num1CutPoint-1];
            int maxRightNumInNums1=(num1CutPoint==nums1.length)?Integer.MAX_VALUE:nums1[num1CutPoint];

            int maxLeftNumInNums2=(num2CutPoint==0)?Integer.MIN_VALUE:nums2[num2CutPoint-1];
            int maxRightNumInNums2=(num2CutPoint==nums2.length)?Integer.MAX_VALUE:nums2[num2CutPoint];

            if(maxLeftNumInNums1<=maxRightNumInNums2&&maxLeftNumInNums2<=maxRightNumInNums1){
                if(isEven){
                    return (Math.max(maxLeftNumInNums1,maxLeftNumInNums2)+Math.min(maxRightNumInNums1,maxRightNumInNums2))/2.0;
                }else{
                    return Math.max(maxLeftNumInNums1,maxLeftNumInNums2);
                }
            }else if(maxLeftNumInNums1>maxRightNumInNums2){
                high=num1CutPoint-1;
            }else{
                low=num1CutPoint+1;
            }
        }

        return -1;
    }
}
