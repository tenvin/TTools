package com.twg.ttools.functional;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

/**
 * Created by hp on 2017/4/20.
 */
public class FunctionTest {
    public static void main(String[] args) {
        //consumer
        BiConsumer<PrintStream, Object> op4 = PrintStream::println;
        op4.accept(System.out, "haha");
        //function
        StringBuilder sb = new StringBuilder();
        BiFunction<StringBuilder, String, StringBuilder> op6 = StringBuilder::append;
        op6.apply(sb, "hehe");
        System.out.println(sb);
        //operator
        IntUnaryOperator op = Math::abs;
        System.out.println(op.applyAsInt(-5));
        //predicate
        BiPredicate<String, String> op7 = String::startsWith;
        System.out.println(op7.test("seedeed", "see"));
        //supplier
        Supplier<List> op8 = Collections::emptyList;
        System.out.println(op8.get().size());
        //action
        Action op9 = System::gc;
        op9.action();
        op9 = FunctionTest::sayHello;
        op9.action();
    }

    private static void sayHello() {
        System.out.println("hello seedeed!");
    }
}
