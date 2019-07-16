package test.testng.demo;

/**
 * @author fokui
 * @date 2019/6/28 14:51
 */
public class TestBasicDataType {
    int a[] = {1,2,3,4,5,6,7,8};
    public void plusFunc(int i){
        System.out.println(a[i++]++);
        System.out.println(a[i++] = a[i++] + 1);
        for (int j=0;j<a.length;j++){
            System.out.print(a[j]);
            System.out.print(",");
        }
        System.out.println();
        System.out.println(i);
    }

    public void plusFunc2(int i){
        System.out.println(a[i++]+=2);
//        System.out.println(a[i++] = a[i++] + 2);
        for (int j=0;j<a.length;j++){
            System.out.print(a[j]);
            System.out.print(",");
        }
        System.out.println();
        System.out.println(i);
    }

    public static void main(String[] args){
        int a = 'A';
        Integer i = 10;
        double d =  1.234E2;
/*        System.out.println(a);
        System.out.println(i);
        System.out.println(d);
//        TestBasicDataType j = new TestBasicDataType();
//        j.plusFunc(2);
        TestBasicDataType t = new TestBasicDataType();
        t.plusFunc2(0);*/
        int flags = 128;
        int f = 2;
        System.out.println(flags &= ~f);

    }
}
