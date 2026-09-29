/*
Problem Statement:Given an array of integers, find and return the maximum sum that can be obtained using contiguous subarrays of the array using Divide and Conquer technique. 
Implement the logic in findMaxSum() method. To implement the logic, you need to also calculate the maximum sum of the subarray containing the middle element. 
You need to implement the logic of calculating the maximum sum of the subarray containing the middle element findMaxCrossingSubarraySum() method. 
Test the functionalities using the main() method of the Tester class.

Sample Input: arr = [-2, -5, 6, -2, -3, 1, 5, -6]
Expected Output: 7
*/
class Tester {

    public static int findMaxCrossingSubarraySum(int arr[], int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }

    public static int findMaxSum(int arr[], int low, int high) {
        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;

        return Math.max(Math.max(findMaxSum(arr, low, mid), 
                                 findMaxSum(arr, mid + 1, high)), 
                        findMaxCrossingSubarraySum(arr, low, mid, high));
    }
    
    public static void main(String[] args) {
        int arr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
        System.out.println("Maximum sum: " + findMaxSum(arr, 0, arr.length - 1));
    }
}
