
import java.util.Scanner;

public class QuickSortExample {

    // Quick Sort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        if (n < 3) {
            System.out.println("Need at least 3 numbers to calculate averages.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Average of top 3 numbers
        double topAvg = (arr[n - 1] + arr[n - 2] + arr[n - 3]) / 3.0;

        // Average of bottom 3 numbers
        double bottomAvg = (arr[0] + arr[1] + arr[2]) / 3.0;

        double difference = topAvg - bottomAvg;

        System.out.println("Average of top 3 numbers: " + topAvg);
        System.out.println("Average of bottom 3 numbers: " + bottomAvg);
        System.out.println("Difference (Top Avg - Bottom Avg): " + difference);

        sc.close();
    }
}
