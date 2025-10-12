public class Task4 {
    public int countConsonants(String user){
        int count = 0;
        for(int i=0; i<user.length(); i++){
            char ch = user.charAt(i);
            if(Character.isLetter(ch)){
                if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U'){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Task4 task = new Task4();
        String user = "hello Sir";
        int value = task.countConsonants(user);
        System.out.println(value);
    }
}
