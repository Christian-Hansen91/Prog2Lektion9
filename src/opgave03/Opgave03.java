package opgave03;

import opgave03.models.ArrayListRing;

public class Opgave03 {
    public static void main(String[] args) {
        ArrayListRing<String> ring = new ArrayListRing<>();

        ring.add("test1");
        ring.add("test2");
        ring.add("test3");
        System.out.println(ring.size());
        System.out.println(ring.getCurrentItem());
        ring.advance();
        ring.removeItem("test2");
        System.out.println(ring.getCurrentItem());
        System.out.println(ring.size());
        ring.removeCurrentItem();
        System.out.println(ring.getCurrentItem());
        System.out.println(ring.size());
    }

}
