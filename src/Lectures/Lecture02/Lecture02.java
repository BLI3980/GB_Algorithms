package Lectures.Lecture02;

public class Lecture02 {

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};
//        bubbleSort(array);
//        directSort(array);
//        insertSort(array);
//        quickSort(array,0, array.length-1);
        pyramidSort(array);
        for (int item: array) {
            System.out.print(item + " ");
        }
//        System.out.println();
//        System.out.println("Simple search:\nSearched element is under index: " +
//                simpleFind(array,5));
//        System.out.println("Binary search:\nSearched element is under index: " +
//                binaryFind(array, 9, 0, array.length-1));
//        System.out.println("Overridden binary search:\nSearched element is under index: " +
//                binaryFind(array, 1));


    }
    public static void bubbleSort(int[] array){
        boolean finish;
        do{
            finish = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    finish = false;
                }
            }
        }while(!finish);

    }

    public static void directSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[minPosition] > array[j]){
                    minPosition = j;
                }
            }
            if(i != minPosition){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public static void insertSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int simpleFind(int[] array, int value){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binaryFind(int[] array, int value, int left, int right){
        int middle;
        if (right < left){
            return -1;
        } else {
            middle = (right - left) / 2 + left;
        }

        if(array[middle] < value){
            return binaryFind(array, value, middle + 1, right);
        } else {
            if (array[middle] > value) {
                return binaryFind(array, value, left, middle - 1);
            } else {
                return middle;
            }
        }

    }

    public static int binaryFind(int[] array, int value){
        return binaryFind(array, value, 0, array.length-1);
    }

    public static void quickSort(int[] array, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = array[(startPos + endPos) / 2];
        do {
            while(array[leftPos] < pivot) {
                leftPos++;
            }
            while(array[rightPos] > pivot) {
                rightPos--;
            }
            if(leftPos <= rightPos) {
                if(leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);
        if (leftPos < endPos) {
            quickSort(array, leftPos, endPos);
        }
        if (startPos < rightPos) {
            quickSort(array, startPos, rightPos);
        }
    }










    public static void pyramidSort(int[] array) {
        // Building a heap (regroup array)
        for (int i = array.length / 2 - 1 ; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // One by one take out elements from heap
        for (int i = array.length - 1; i >= 0 ; i--) {
            // Move current root to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call heapify in smaller heap
            heapify(array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // initialize max element as root
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // If leftChild element is more than root element
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // If rightChild element more than the largest element at the moment
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
             largest = rightChild;
        }

        // if largest element is not root element
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
        }

        // Recursively changing to binary heap the next one of two below tree branches
        // Depending on whether left of right child was swapped with root
        heapify(array, heapSize, largest);
    }















}
