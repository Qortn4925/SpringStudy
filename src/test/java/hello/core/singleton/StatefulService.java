package hello.core.singleton;

public class StatefulService {

    private int price;  // 사앹를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기가 문제!!  , 두 번 호출 되면 다른 문제가 발생할 수 있어서
    }

    public  int getPrice() {
        return price;
    }


}
