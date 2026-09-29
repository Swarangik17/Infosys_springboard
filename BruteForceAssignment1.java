/* Problem Statement
Given two square matrices, find the product of the two matrices using brute force technique. Implement the logic in multiply() method.

Test the functionalities using the main() method of the Tester class.
Sample Input: arr1 = [[2,4], [1,4]], arr2 = [[1,4], [1,3]]
Expected Output: [[6,20], [5,16]] */
class Tester {

    public static int[][] multiply(int arr1[][], int arr2[][]) {
        int n = arr1.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0; 
                for (int k = 0; k < n; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[][]=new int [][] {{2,4},{1,4}};
        int arr2[][]=new int [][] {{1,4},{1,3}};
        
        int[][] arr3=multiply(arr1,arr2);
        
        for(int index1=0;index1<arr3.length;index1++){
            for(int index2=0;index2<arr3.length;index2++){
                System.out.print(arr3[index1][index2]+" ");
            }
            System.out.println();
        }
    }
}
