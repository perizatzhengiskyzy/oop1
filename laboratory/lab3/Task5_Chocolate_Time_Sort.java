// Task 5: Chocolate, Time, Sort

class Chocolate implements Comparable<Chocolate> {
    private double weight;
    private String name;
    
    public Chocolate(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Chocolate{name='" + name + "', weight=" + weight + "g}";
    }
    
    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }
}

class Time implements Comparable<Time> {
    private int hours;
    private int minutes;
    private int seconds;
    
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalize();
    }
    
    private void normalize() {
        minutes += seconds / 60;
        seconds %= 60;
        hours += minutes / 60;
        minutes %= 60;
        hours %= 24;
    }
    
    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }
    
    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.toSeconds(), other.toSeconds());
    }
    
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

class Sort {
    static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    static <E extends Comparable<E>> void bubbleSort(E[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    static <E extends Comparable<E>> void mergeSort(E[] array) {
        if (array.length <= 1) return;
        mergeSortHelper(array, 0, array.length - 1);
    }
    
    private static <E extends Comparable<E>> void mergeSortHelper(E[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(array, left, mid);
            mergeSortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    private static <E extends Comparable<E>> void merge(E[] array, int left, int mid, int right) {
        @SuppressWarnings("unchecked")
        E[] leftArray = java.util.Arrays.copyOfRange(array, left, mid + 1);
        @SuppressWarnings("unchecked")
        E[] rightArray = java.util.Arrays.copyOfRange(array, mid + 1, right + 1);
        
        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }
}