package ht.mbds.Tarrouzi;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
public class Test5 {
    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_API_KEY");
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash").temperature(0.7)
                .build();

        String question1 = model.chat(
                "comment s'appelle la tortue de pierre?"
        );

        System.out.println(question1);

    }
}