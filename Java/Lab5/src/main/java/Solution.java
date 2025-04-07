public class Solution {
    public static void main(String[] args) {
        Injector injector = new Injector();
        SomeBean someBean = injector.inject(new SomeBean());
        someBean.foo();
    }
}
