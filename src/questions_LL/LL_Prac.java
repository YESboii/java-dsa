package questions_LL;
import LinkedList.CustomLinkedList;

public class LL_Prac {

    public static void main(String[] args) {

        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.addLast(1);
        customLinkedList.addLast(2);
        customLinkedList.addLast(3);
        customLinkedList.addLast(4);
        customLinkedList.addLast(5);
        customLinkedList.printList();
        customLinkedList.ReverseLinkedList();
        customLinkedList.printList();

    }
}
