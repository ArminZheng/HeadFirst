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
    public BibliographyImpl(String hh,Integer i) {
        super(hh);
    }

    /**
     * 抽象类有构造方法，但不能直接创建抽象类的实例对象
     * 通过实例化子类，就会初始化父类，无论父类是否抽象类都会调用父类的构造方法。初始化一个类，会先初始化父类。
     *
     * 接口成员变量是常量：public static final ;
     * 接口是一种规范，被调用时，主要关注的是里边的方法，而方法是不需要初始化的，
     */
    public BibliographyImpl() {
    }

    public static void main(String[] args) {
        new BibliographyImpl();
        new BibliographyImpl("happy", 1);
        Bibliography.PrintLove();
    }
}
