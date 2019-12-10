package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("C:\\Java\\resources\\wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        System.out.println(top10Words(words));
        System.out.println(top10Phrases(words));
        System.out.println(charactersFrequency(words));

    }

    public static Map<String, Integer> top10Words(List<String> words) {
        // todo implement

        Map< String, Integer > map = new LinkedHashMap<>();

        Comparator< Entry< String, Integer > > valueComparator = new Comparator< Entry< String, Integer > >() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            };
        };

        List< Entry< String, Integer > > sortedList;

        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String word) {
                Integer cnt = map.get(word);
                if (cnt == null) {
                    map.put(word, 1);
                } else {
                    map.put(word, cnt + 1);
                }
            }
        });

        sortedList = new ArrayList< Entry< String, Integer > >(map.entrySet());

        Collections.sort(sortedList, valueComparator);

        map.clear();

        for (int j = 0; j < 10; j++) {
            map.put( sortedList.get(j).getKey(), sortedList.get(j).getValue() );
        }

        return map;

    }

    public static Map<String, Integer> top10Phrases(List<String> words) {
        // todo implement

        Map< String, Integer > map = new LinkedHashMap<>();

        String sPhrase, aStr = "";

        Comparator< Entry< String, Integer > > valueComparator = new Comparator< Entry< String, Integer > >() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            };
        };

        List< Entry< String, Integer > > sortedList;

        for ( String word : words) {
            if ( aStr.length() > 0 ) {
                sPhrase = aStr + " " + word;
                Integer cnt = map.get(sPhrase);
                if (cnt == null) {
                    map.put(sPhrase , 1);
                } else {
                    map.put(sPhrase, cnt + 1);
                }
            }
            aStr = word;
        }

        sortedList = new ArrayList< Entry< String, Integer > >(map.entrySet());

        Collections.sort(sortedList, valueComparator);

        map.clear();

        for (int j = 0; j < 10; j++) {
            map.put( sortedList.get(j).getKey(), sortedList.get(j).getValue() );
        }

        return map;

    }

    public static Map<Character, Integer> charactersFrequency(List<String> words) {
        // todo implement

        Map< Character, Integer > map = new LinkedHashMap<>();

        Comparator< Entry< Character, Integer > > valueComparator = new Comparator< Entry< Character, Integer > >() {
            @Override
            public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            };
        };

        List< Entry< Character, Integer > > sortedList;

        for ( String word : words) {
            char[] wordChars = word.toCharArray();
            int iLen = word.length();
            for ( int i = 0; i < iLen; i++ ){
                Integer cnt = map.get(wordChars[i]);
                if (cnt == null) map.put(wordChars[i], 1); else map.put(wordChars[i], cnt + 1);
            }
        }

        sortedList = new ArrayList< Entry< Character, Integer > >(map.entrySet());

        Collections.sort(sortedList, valueComparator);

        map.clear();

        for (int j = 0; j < 10; j++) {
            map.put( sortedList.get(j).getKey(), sortedList.get(j).getValue() );
        }

        return map;

    }
}
