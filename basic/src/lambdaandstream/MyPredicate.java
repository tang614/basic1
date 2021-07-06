package lambdaandstream;

/**
 * 比较规则的接口
 * @param <T>
 */
public interface MyPredicate<T> {
    boolean test(T t);
}
