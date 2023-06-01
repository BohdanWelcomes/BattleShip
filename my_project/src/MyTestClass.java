import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTestClass {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        int[] arr = {1, 2, 3, 5};

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            System.out.println(list);
        }

        System.out.println("onr");
    }
}