public class Task2 {
    public int fibSeq(int number){
        if(number == 0 || number == 1){
            return number;
        }
        return fibSeq(number-1)+fibSeq(number-2);
    }
    public static void main(String[] args) {
        Task2 task = new Task2();
        System.out.println(task.fibSeq(6));
    }
}
