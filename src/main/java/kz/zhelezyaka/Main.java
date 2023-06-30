package kz.zhelezyaka;

import jakarta.annotation.Nonnull;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

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

    @NotNull
    public static String concatStrings(List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String str : list) {
            if (Objects.nonNull(str) && str.contains("кошка")) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
