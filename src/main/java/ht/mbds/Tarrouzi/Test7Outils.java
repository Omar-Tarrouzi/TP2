package ht.mbds.Tarrouzi;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import ht.mbds.Tarrouzi.outil.meteo.MeteoTool;

import java.util.Scanner;

public class Test7Outils {

    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "La variable GEMINI_API_KEY n'est pas définie."
            );
        }

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash")
                .temperature(0.2)
                .logRequestsAndResponses(true)
                .build();

        AssistantMeteo assistant = AiServices
                .builder(AssistantMeteo.class)
                .chatModel(model)
                .chatMemory(
                        MessageWindowChatMemory.withMaxMessages(20)
                )
                .tools(new MeteoTool())
                .build();

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Posez une question, ou tapez 'exit'.");

            while (true) {
                System.out.print("\nVous : ");

                if (!scanner.hasNextLine()) {
                    break;
                }

                String question = scanner.nextLine();

                if (question.equalsIgnoreCase("exit")) {
                    break;
                }

                if (question.isBlank()) {
                    continue;
                }

                String reponse = assistant.chat(question);

                System.out.println("Assistant : " + reponse);
            }
        }
    }
}