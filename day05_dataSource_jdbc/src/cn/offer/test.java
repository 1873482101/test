package cn.offer;


public class test {
    public static void main(String[] args) {
        int [] number = {6,3,2,0,2,5,0};
        int dupli = 0;
        duplicate1(number,number.length,dupli);
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.println();
        System.out.println(dupli);


    }
    static public boolean duplicate(int[] nums, int length, int duplication) {
        if (nums == null || length <= 0)
            return false;

        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);

                for (int i1 = 0; i1 < nums.length; i1++) {
                    System.out.print(nums[i1]);
                }
                System.out.println();
            }
        }
        return false;
    }

   public static boolean duplicate1(int numbers[], int length, int duplication) {
        for(int i = 0; i < length;i++){
            if(numbers[i]==i){

           }else if(numbers[numbers[i]] == numbers[i]){
                duplication = numbers[i];
               return true;
           }else{
               swap(numbers,numbers[numbers[i]], numbers[i]);
           }
       }
       return false;
   }




    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
