class quickSort{
    public static void main(String[] args) {
        int []arr = new int[]{7,9,4,8,3,6,2,1};
        show(arr);
        quicksort(arr, 0, arr.length-1);
        show(arr);
    }

    private static void quicksort(int[] arr, int lo, int hi) {
        if(lo >= hi){
            return ;
        }

        int pivot = arr[hi];
        int pi = partion(arr, pivot, lo, hi);
        quicksort(arr, lo, pi-1);
        quicksort(arr, pi+1, hi);
    }

    public static void partition(int[] arr, int pivot) {
        int i = 0;
        int j = 0;

        while(i < arr.length){
            if(arr[i] > pivot){
                i++;
            }else if(arr[i] <= pivot){
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    public static int partion(int [] arr, int pivot, int lo, int hi){
        int i = lo;
        int j = lo;

        while(i <= hi){
            if(arr[i] > pivot){
                i++;
            }else if(arr[i] <= pivot){
                swap(arr, i, j);
                i++;
                j++;
            }
        }

        return j-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void show(int[] arr) {
        for(int val : arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}