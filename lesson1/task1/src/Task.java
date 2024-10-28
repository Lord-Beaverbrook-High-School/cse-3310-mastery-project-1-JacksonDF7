// I used https://www.geeksforgeeks.org/quick-sort-algorithm/ to see how quick sorts are programmed, but I didn't really understand the way they programmed it.
// The only thing I ended up borrowing from it is the way I handled my recursion (lines 66 and 69).
public class Task {
    public static void quick(int[] arr, int min, int max) {
        int pivot = getRandom(min, max);
        /*System.out.print(arr[pivot] + ": {");
        for (int f: arr){
            System.out.print(f + ", ");
        }
        System.out.print("} to {"); */
        int temp;
        int index = min;
        boolean moved;
        if (min < max) {
            while (index <= max){
                moved = false;
                if (index < pivot) {
                    if (arr[index] > arr[pivot]) {
                        for (int i = max; i > pivot; i--) {
                            if (arr[i] < arr[pivot]) {
                                temp = arr[i];
                                arr[i] = arr[index];
                                arr[index] = temp;
                                moved = true;
                                break;
                            }
                        }
                        if (!moved) {
                            temp = arr[index];
                            for (int k = index; k < pivot; k++){
                                arr[k] = arr[k + 1];
                            }
                            arr[pivot] = temp;
                            pivot--;
                            index--;
                        }
                    }
                } else {
                    if (arr[index] < arr[pivot]) {
                        for (int e = min; e < pivot; e++) {
                            if (arr[e] > arr[pivot]) {
                                temp = arr[e];
                                arr[e] = arr[index];
                                arr[index] = temp;
                                moved = true;
                                break;
                            }
                        }
                        if (!moved) {
                            temp = arr[index];
                            for (int r = index; r > pivot; r--){
                                arr[r] = arr[r - 1];
                            }
                            arr[pivot] = temp;
                            pivot++;
                        }
                    }
                }
                index++;
            }
            /*for (int q: arr){
                System.out.print(q + ", ");
            }
            System.out.println("}"); */
            if (pivot < arr.length - 1){ //This and line 68 may be redundant
                quick(arr, pivot + 1, max);
            }
            if (pivot > 0){
                quick(arr, min, pivot - 1);
            }
        }
    }
    //Generates a random number between min and max
    public static int getRandom(double min, double max){
        return (int)((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args){
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        int[] arr2 = {8,-1,3,0,112,2};
        int[] arr3 = new int[100];
        for (int i = 0; i < 100; i++){
            arr3[i] = getRandom (-100,100);
        }
        int[] arr4 = new int[10];
        for (int i = 0; i < 10; i++){
            arr4[i] = getRandom(-10, 10);
        }
        quick(arr1,0,arr1.length - 1);
        quick (arr2,0,arr2.length - 1);
        quick (arr3, 0, 99);
        quick(arr4, 0, 9);
        for (int i: arr1){
            System.out.print(i + ", ");
        }
        System.out.println();
        for (int i: arr2){
            System.out.print(i + ", ");
        }
        System.out.println();
        for (int i: arr3){
            System.out.print(i + ", ");
        }
        System.out.println("\n");
        for (int i: arr4){
            System.out.print(i + ", ");
        }
    }
}
/*
The code is tested by printing the value of the pivot followed by a colon. Then the array at the start of the method is printed, and then the array at the end of the method is printed. This is meant to show how the
array is being sorted based on the chosen pivot. Unfortunately the formatting becomes a bit messed up once recursion starts, but it's still legible. This is printed using lines 6-10 and 61-64

arr1 - Testing an array with every value being > 0:
7: {10, 7, 8, 9, 1, 5, } to {5, 1, 7, 8, 9, 10, }
9: {5, 1, 7, 8, 9, 10, } to {5, 1, 7, 8, 9, 10, }
10: {5, 1, 7, 8, 9, 10, } to {8: {5, 1, 7, 8, 9, 10, } to {5: {5, 1, 7, 8, 9, 10, } to {1, 5, 7, 8, 9, 10, }
5: {1, 5, 7, 8, 9, 10, } to {1: {1, 5, 7, 8, 9, 10, } to {

1, 5, 7, 8, 9, 10,

arr2 - Testing values <= 0, as well as triple digit numbers:
8: {8, -1, 3, 0, 112, 2, } to {-1, 3, 0, 2, 8, 112, }
112: {-1, 3, 0, 2, 8, 112, } to {3: {-1, 3, 0, 2, 8, 112, } to {-1, 0, 2, 3, 8, 112, }
3: {-1, 0, 2, 3, 8, 112, } to {0: {-1, 0, 2, 3, 8, 112, } to {-1, 0, 2, 3, 8, 112, }
2: {-1, 0, 2, 3, 8, 112, } to {-1: {-1, 0, 2, 3, 8, 112, } to {

-1, 0, 2, 3, 8, 112,

arr3 - Testing an array populated by 100 random numbers between -100 - 100:
testing is very large, so for the sake of conserving space I will just print the end result.
-99, -94, -94, -84, -84, -81, -76, -76, -75, -74, -73, -73, -73, -70, -67, -64, -56, -55, -53, -53, -51, -50, -50, -50, -50, -47, -47, -44, -42, -41, -40, -33, -33, -32, -31, -30, -29, -29, -23, -19, -11, -9, -6, -3,
-2, 2, 7, 8, 9, 10, 11, 12, 15, 17, 20, 20, 21, 21, 31, 37, 39, 41, 45, 54, 55, 55, 58, 59, 60, 62, 62, 63, 63, 65, 65, 70, 70, 72, 73, 74, 76, 77, 79, 79, 79, 80, 85, 86, 89, 89, 90, 90, 91, 92, 92, 93, 94, 95, 97, 98,

arr4 - Testing an array that's randomly populated by numbers between -10 - 10:
1: {8, 8, 2, 5, -3, 1, 5, -1, 4, -9, } to {-9, -1, -3, 1, 5, 2, 5, 8, 4, 8, }
4: {-9, -1, -3, 1, 5, 2, 5, 8, 4, 8, } to {-9, -1, -3, 1, 2, 4, 8, 5, 5, 8, }
5: {-9, -1, -3, 1, 2, 4, 8, 5, 5, 8, } to {-9, -1, -3, 1, 2, 4, 5, 8, 5, 8, }
5: {-9, -1, -3, 1, 2, 4, 5, 8, 5, 8, } to {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, }
8: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, }
8: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {5: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {5: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {4: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {2: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {-9: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, }
-1: {-9, -1, -3, 1, 2, 4, 5, 5, 8, 8, } to {-9, -3, -1, 1, 2, 4, 5, 5, 8, 8, }
-1: {-9, -3, -1, 1, 2, 4, 5, 5, 8, 8, } to {-3: {-9, -3, -1, 1, 2, 4, 5, 5, 8, 8, } to {

-9, -3, -1, 1, 2, 4, 5, 5, 8, 8,

 */