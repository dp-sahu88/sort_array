import java.util.Scanner;

class sortArray {

    public static void selectionSort(int[] arr) {
        // find the smallest element starting from position i
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // record the position of the smallest
            for (int j = i + 1; j < arr.length; j++) {
                // update min when finding a smaller element
                if (arr[j] < arr[min])
                    min = j;
            }

            // put the smallest element at position i
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // a temporary copy of the current element
            int tmp = arr[i];
            int j;

            // find the position for insertion
            for (j = i; j > 0; j--) {
                if (arr[j - 1] < tmp)
                    break;
                // shift the sorted part to right
                arr[j] = arr[j - 1];
            }

            // insert the current element
            arr[j] = tmp;
        }
    }

    public static void bubbleSort(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            // bubble up
            for (int j = 0; j <= i - 1; j++) {
                if (data[j] > data[j + 1])
                    swap(data, j, j + 1);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int n;
        char options = 'v';
        System.out.println("enter the number of element to be insert  in the array : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements into the array ... ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (("BbiIsS".indexOf(options)) == -1) {
            System.out.println("enter the type of sort to be performed : ");
            System.out.println("I - Insertion Sort \nS - Selection Sort\nB - Bubble Sort");
            options = sc.next().charAt(0);
        }
        sc.close();
        switch (options) {
            case 'I':
            case 'i':
                sortArray.insertionSort(arr);
                break;
            case 'b':
            case 'B':
                sortArray.bubbleSort(arr);
                break;
            case 's':
            case 'S':
                sortArray.selectionSort(arr);
                break;

            default:
                break;
        }
        System.out.println("after sorting , array looks like as follows : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+"  ");
        }
    }
}