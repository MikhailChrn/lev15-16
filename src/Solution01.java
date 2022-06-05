public class Solution01 {
    //lev15:
    //Создать 7 нестатических public полей класса:
    //Убедиться, что они инициализируются дефолтными значениями.
    //Вывести их значения в заданном порядке в методе main()

    int intVar;
    double doubleVar;
    Double DoubleVar;
    boolean booleanVar;
    Object ObjectVar;
    Exception ExceptionVar;
    String StringVar;

    public static void main(String[] args) {
        //Для использования нестатических переменных требуется создать объект
        Solution01 solution = new Solution01();
        System.out.println(solution.intVar);
        System.out.println(solution.doubleVar);
        System.out.println(solution.DoubleVar);
        System.out.println(solution.booleanVar);
        System.out.println(solution.ObjectVar);
        System.out.println(solution.ExceptionVar);
        System.out.println(solution.StringVar);
    }
}
