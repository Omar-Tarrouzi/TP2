package ht.mbds.Tarrouzi;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class test3traduct {
    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_API_KEY");
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash").temperature(0.7)
                .build();

        PromptTemplate template = PromptTemplate.from(
                "Traduis le texte suivant en espagnol : {{texte}}"
        );

        Prompt prompt = template.apply(
                Map.of("texte", "je te donne mes notes , je te donne mes mots quand ta voix les emportent à son porte tempo")
        );
        String traduction = model.chat(prompt.text());
        System.out.println(traduction);
    }
}