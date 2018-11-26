package io.github.subinbabu89;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculateDigiEvolution {

    private static final String filePath = "src/io/github/subinbabu89/DigimonList.txt";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        DigiEvolutionGraph graph = new DigiEvolutionGraph();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            list = stream.filter(line -> line.contains("->")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String lineItem : list) {
            String[] split = lineItem.split("->");
            graph.add(split[0], split[1]);
        }

        System.out.println(Util.findAllShortestPaths(graph, "195", "101"));
    }
}
