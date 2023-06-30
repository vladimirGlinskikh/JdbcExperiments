package kz.zhelezyaka;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<String> inputList = List.of(
                "кошка123",
                "тра-ля-ля кошка тра-ля-ля",
                null,
                "какой-то текст без слова кошка",
                "");
        String result = concatStrings(inputList);
        System.out.println(result);

    }

    public static String concatStrings(List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String str : list) {
            if (str != null && str.contains("кошка")) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
