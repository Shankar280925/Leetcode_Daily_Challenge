class Solution {
    public double getChange(int[] cl){
        double actual_diff = (double) cl[0]/cl[1];
        double new_diff = (double) (cl[0]+1)/(cl[1]+1);
        return new_diff - actual_diff; 
    }
    public void heapify(int[][] arr,int parent){
        int left_child = 2 * parent + 1;
        int right_child = 2 * parent + 2;
        int largest = parent;
        if(left_child < arr.length && getChange(arr[left_child]) > getChange(arr[largest])) largest = left_child;
        if(right_child < arr.length && getChange(arr[right_child]) > getChange(arr[largest])) largest = right_child;
        if(largest!=parent){
            int[] temp = arr[largest];
            arr[largest] = arr[parent];
            arr[parent] = temp;
            heapify(arr,largest);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        for(int i = (n/2)-1;i>=0;i--){
            heapify(classes,i);
        }
        for(int i = 0;i<extraStudents;i++){
            int[] max_class = classes[0];
            max_class[0]++;max_class[1]++;
            classes[0] = max_class;
            heapify(classes,0);
        }
        double res = 0.0;
        for(int[] cl: classes){
            res += (double) cl[0]/cl[1];
        }
        return res/n;
    }
}
