package ht.mbds.Tarrouzi;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
public class Test1 {
    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_API_KEY");
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash").temperature(0.7)
                .build();

        String question1 = model.chat(
                "Yo , il est quelle heure frére ?"
        );

        String question2 = model.chat(
                "Bonjour , je m'appelle Omar Tarrouzi , ça ne te dit rien mainteneant mais un jour je serais connu...pour de bonnes raisons "
        );

        String question3 = model.chat(
                "Juste pour check si tu suivais , c'est quoi mon nom ? "
        );



        // Affichage de sa réponse
        System.out.println(question1);
        System.out.println(question2);
        System.out.println(question3);
    }
}