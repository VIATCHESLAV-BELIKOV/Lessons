package com.ifmo.lesson13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {

    static class Person {
        final String name;
        final int age;
        final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        List<Person> people = generatePeople(100).collect(Collectors.toList());

      //  people.forEach(P -> System.out.printf("%s,%d,%s\n",P.name,P.age,P.country));

        List<String> countries = countriesSortedByTheirPopulationDescending(people.stream());
        String countryThatHasMostKids = countryThatHasMostKids(people.stream());
        Map<String, Long> populationByCountry = populationByCountry(people.stream());

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {
        // TODO implement.
        return people
                .collect(Collectors.groupingBy(x -> x.country, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .map(x -> x.getKey())
                .collect(Collectors.toList());
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        // TODO implement.
        return people
                .filter(x -> x.age < 18)
                .collect(Collectors.groupingBy(x ->x.country, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("?");
    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        // TODO implement.
        return people.collect(Collectors.groupingBy(x -> x.country, Collectors.counting()));
    }

    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        // TODO implement.
        Random random = new Random();
        String[] saNames = { "Feofan", "Leo", "Illarion", "Matilda", "Jane", "Faina", "Lucia", "Nicola", "Maria", "Isolda", "Kirill", "Ivan", "Milana", "Bzdyshek", "Miroslav", "Moisha", "Karina", "Albina", "Fima", "Alvaro", "Konchita", "Pedro", "Artos", "Portos", "Aramis" };
        String[] saCountries = {"Mozambique", "Mexico", "USA", "Netherlands", "Belgium", "France", "Spain" };
        return Stream.generate( () -> new Person( saNames[random.nextInt(saNames.length)], random.nextInt(101), saCountries[random.nextInt(saCountries.length)] ) ).limit(number);
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {
        // TODO implement.
        return  words.stream().collect( Collectors.groupingBy( x -> x.length(), Collectors.mapping( x -> x, Collectors.toSet() )) );
     }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        // TODO implement.
        return (int)Math.round( words.stream().collect(Collectors.averagingInt(x->x.length())) );
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        // TODO implement.
       // words.stream().max(Comparator.comparing(String::length))
        int i = words.stream().max(Comparator.comparing(String::length)).orElse("").length();
        return words.stream().filter( (x) -> ( i == x.length()) ).collect(Collectors.toSet());
    }


}
