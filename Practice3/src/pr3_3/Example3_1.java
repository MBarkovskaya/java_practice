package pr3_3;

import java.util.ArrayList;
import java.util.Objects;

public class Example3_1 {
    private ArrayList<Integer> list1 = listCreation();
    private ArrayList<Integer> list2 = listCreation();

    public static void main(String[] args) {
        Example3_1 example3_1 = new Example3_1();
        example3_1.compareArrayLists();
        example3_1.createAndCompareUserLists();
    }

    private void createAndCompareUserLists() {
        ArrayList<User> list1 = new ArrayList<>();
        list1.add(new User("Name", "Nickname", 14));
        list1.add(new User("Name2", "Nickname2", 13));
        list1.add(new User("Name3", "Nickname2", 12));

        ArrayList<User> list2 = new ArrayList<>();
        list2.add(new User("Name", "Nickname", 14));
        list2.add(new User("Name2", "Nickname2", 13));
        list2.add(new User("Name3", "Nickname2", 12));

        User testUser = new User("Name", "Nickname", 14);
        boolean result1 = list1.contains(testUser);
        System.out.println("List1 contains testUser so the result1 is: " + result1);
        boolean remove1 = list1.remove(testUser);
        boolean result1AfterRemoving = list1.contains(testUser);
        System.out.println("testUser was removed from the List1 so the result1AfterRemoving is: " + result1AfterRemoving);
        boolean result2 = list2.contains(testUser);
        System.out.println("List2 contains testUser so the result1 is: " + result2);
        list2.remove(testUser);
        boolean result2AfterRemoving = list2.contains(testUser);
        System.out.println("testUser was removed from the List2 so the result2AfterRemoving is: " + result2AfterRemoving);
        compareArrayLists(list1, list2);
    }

    private ArrayList<Integer> listCreation() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    private void compareArrayLists() {
        for (int i = 0; i < 10; i++) {
            if (list1.get(i).equals(list2.get(i))) {
                System.out.println("element " + i + " of the list1 equals to the element " + i + " of the list2");
            } else
                System.out.println("element " + i + " of the list1 not equals to the element " + i + " of the list2");
        }
    }

    private void compareArrayLists(ArrayList<User> list1, ArrayList<User> list2) {
        if (list1.equals(list2)) {
            System.out.println("the list1 equals to the list2");
        } else {
            System.out.println("The lists doesn't equal");
        }

    }

    public class User {
        private String name;
        private String nickName;
        private int age;

        public User(String name, String nickName, int age) {
            this.name = name;
            this.nickName = nickName;
            this.age = age;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    name.equals(user.name) &&
                    nickName.equals(user.nickName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, nickName, age);
        }
    }
}

