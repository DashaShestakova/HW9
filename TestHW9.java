package HW9;

public class TestHW9 implements Comparable<TestHW9> {
    String len;

    public String getLen() {
        return len;
    }

    public TestHW9(String s) {
        this.len = s;
    }

    public static void main(String[] args) {
        TestHW9 [] arr = new TestHW9[5];
        arr[0] = new TestHW9("asdfgh");
        arr[1] = new TestHW9("asdf");
        arr[2] = new TestHW9("asdfg");
        arr[3] = new TestHW9("asd");
        arr[4] = new TestHW9("asdfghj");


        DataContainer dataContainer = new DataContainer(arr);
        System.out.println(dataContainer.add("asdfg"));
        System.out.println(dataContainer.get(1));
        System.out.println(dataContainer.getItems().length);
        System.out.println(dataContainer.delete(1));
        System.out.println(dataContainer.getItems().length);
        System.out.println(dataContainer.delete("asd"));
        System.out.println(dataContainer.getItems().length);
        dataContainer.sort(new DataContainer<TestHW9>(arr));
        System.out.println(dataContainer.get(2));


    }


    @Override
    public int compareTo(TestHW9 testHW9) {

        return this.len.compareTo(testHW9.len);
    }
}
