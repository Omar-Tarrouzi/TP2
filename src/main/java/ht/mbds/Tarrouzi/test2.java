package ht.mbds.Tarrouzi;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.output.TokenUsage;
public class test2 {
    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_API_KEY");
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash").temperature(0.7)
                .build();

        ChatResponse response = model.chat(
                UserMessage.from("il est quelle heure au maroc right now")
        );
        ChatResponse response2 = model.chat(
                UserMessage.from("je m'appelle Omar")
        );

        ChatResponse response3 = model.chat(
                UserMessage.from("can you guess my name ? ")
        );



        System.out.println("Réponse : " + response.aiMessage().text());

        TokenUsage tokens = response.tokenUsage();
        System.out.println( tokens);

        System.out.println("Réponse : " + response2.aiMessage().text());
        TokenUsage tokens2 = response2.tokenUsage();
        System.out.println( tokens2);

        System.out.println("Réponse : " + response3.aiMessage().text());
        TokenUsage tokens3 = response3.tokenUsage();
        System.out.println( tokens3);


    }
}