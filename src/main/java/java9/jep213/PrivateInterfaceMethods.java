package java9.jep213;

public class PrivateInterfaceMethods {

    public interface After {

        default void active() {
            this.after("s");
        }


        private void after(String sss) {
            System.out.println(sss);
        }
    }
}
