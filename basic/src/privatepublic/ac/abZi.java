package privatepublic.ac;

import privatepublic.ab;

public class abZi extends ab {





    @Override
    public void method() {
        super.a = 14;
    }


    //在demo4中创建相同的main函数却不能访问，说明 protected修饰的变量允许子类访问，这里的访是指直接super.a访问父类属性/创建对象访问
    public static void main(String[] args) {
        abZi abZi = new abZi();
        abZi.a = 10;
        System.out.println(abZi.a);
    }

}
