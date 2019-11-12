package com.ifmo.lesson12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utils {

    @FunctionalInterface
    public interface Predicate<T> {  boolean isValid(T value); }

    @FunctionalInterface
    public interface Transformer<T,R>{ R convert(T t); }

    public static<T> List<T> filter(List<T> list, Predicate<T> filter){
        List<T> result = new ArrayList<>( list.size() );
        for (T item: list) {
            if ( filter.isValid(item) )
                result.add(item);
        }
        return result;
    }

    public static <T,K> List<K> transform(List<T> list, Transformer<T,K> transform ){
        List<K> result = new ArrayList<>( list.size() );
        for (T item: list) {
            result.add( transform.convert(item) );
        }
        return result;
    }

    public static <T, R> Iterable<R> view(Predicate<T> filter, Transformer<T, R> transformer, Iterable<T>...iterables) {
        Integer iC = iterables.length;
        if (iC == 0) return List.of();

        return new Iterable<R>() {
            @Override
            public Iterator<R> iterator() {
                return new Iterator<R>() {
                    private int pos;
                    Iterable<R> curList;
                    private Iterator<R> current;

                    @Override
                    public boolean hasNext() {
                        if (current == null)
                        {
                            curList =  transform(filter( (List<T>)iterables[pos], filter ), transformer);
                            current = curList.iterator();
                        }
                        if (!current.hasNext()) {
                            pos++;

                            if (pos < iterables.length) {
                                curList =  transform(filter( (List<T>)iterables[pos], filter ), transformer);
                                current = curList.iterator();
                            } else {
                                return false;
                            }
                        }
                        return current.hasNext();
                    }

                    @Override
                    public R next() {
                        return current.next();
                    }
                };
            }
        };
    }

        public static void main(String[] args){

        List<Integer> iIntegers = List.of(0,1,2,3,4,5,6,7,8,9);
        List<Integer> iInteger1 = List.of(30,31,32,33,34,35,36,37,38,39);
        List<Integer> iInteger2 = List.of(50,51,52,53,54,55,56,57,58,59);
        List<String> sIntegers = List.of("99","12","48","23","11","876","1239","7","345","50");
        List<String>  sStrings = List.of("This", "eBook", "is", "for", "the", "use", "of", "anyone", "anywhere", "at", "no", "cost", "and", "with", "almost");

        System.out.println("==== 1.a. ====");
        filter( iIntegers, i -> i % 2 == 0 ).forEach(System.out::println);
        System.out.println("==== 1.b. ====");
        filter( sStrings, s -> s.length() > 3 ).forEach(System.out::println);
        System.out.println("==== 2.a. ====");
        transform( iIntegers, integer -> integer.toString()).forEach(System.out::println);
        System.out.println("==== 2.b. ====");
        transform( sIntegers, Integer::valueOf ).forEach(System.out::println);
        System.out.println("==== 2.c. ====");
        transform( iIntegers, i -> i * i ).forEach(System.out::println);

        Predicate<Integer> preI =  i -> i % 2 == 0;
        Transformer<Integer, String> preS = i -> i.toString();

        view(  preI, preS, iIntegers, iInteger1, iInteger2 ).forEach(System.out::println);

    } // end main

}
