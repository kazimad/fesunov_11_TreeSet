import java.io.Serializable;

public class Person implements Serializable,Comparable{

    private String name;
    private String phone;

    Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    Person() {
        this(null, null);
    }

    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public void toSrring(){
        System.out.println ("Фамилия"+getName()+ "телефон"+getPhone());
    }
}
