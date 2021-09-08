/**
 * @author Armin Zheng
 * @since 2021-09-08
 */
public class BibliographyImpl extends Bibliography {

    /**
     * 如果父类抽象类中含有 有参构造函数，在子类继承是就必须写一个构造函数来调用父类的构造函数;
     * 如果父类抽象类中没有 有参构造函数，在子类中可以不显示的写父类的构造函数，Java会自动生成并调用没有参数的构造函数;
     *
     * @param hh (´▽`ʃ♡ƪ)
     */
    public BibliographyImpl(String hh) {
        super(hh);
    }

    public BibliographyImpl() {
    }

    public static void main(String[] args) {
        new BibliographyImpl();
        new BibliographyImpl("happy");
    }
}
