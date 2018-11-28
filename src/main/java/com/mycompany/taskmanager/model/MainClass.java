public class MainClass {
    public static void main(String[] args) {
        IdGenerator arr[] = new IdGenerator[2];
        for (int i = 0; i < 2; i++) {
            arr[i]=IdGenerator.generateId();
            System.out.println(arr[i].counter);
        }
        IdGenerator id=IdGenerator.generateId();
        IdGenerator id1=IdGenerator.generateId();
        TaskIpml taskIpml=new TaskIpml();
        TaskIpml taskIpml1=new TaskIpml();
        System.out.println(taskIpml.id.counter);
        System.out.println(taskIpml1.id.counter);
    }
}