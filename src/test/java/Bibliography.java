/**
 * @author Armin Zheng
 * @since 2021-09-08
 */
public abstract class Bibliography {

    protected String HH = "No Happy";

    public Bibliography() {
        System.out.println(HH);
    }

    public Bibliography(String hh) {
        this.HH = hh;
        System.out.println(HH);
    }

    public static void PrintLove(){
        System.out.println("i love u");
    }
}
