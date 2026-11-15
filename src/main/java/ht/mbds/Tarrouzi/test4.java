package ht.mbds.Tarrouzi;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

public class test4{

    public static void main(String[] args) {

        EmbeddingModel model = new BgeSmallEnV15EmbeddingModel();

        String[][] couples = {
                {"Le chat dort", "Le félin est inconscient "},
                {"J'aime le café.", "Je déteste le café."},
                {"Il fait froid.", "La température est basse."},
                {"Je développe en Java.", "Je prépare une soupe."},
                {"Il achète une voiture.", "Il fait l'acquisition d'un véhicule."},
                {"J'étudie dans une université prestigieuse", "je suis étudiant à l'emsi"}
        };

        for (String[] couple : couples) {

            String phrase1 = couple[0];
            String phrase2 = couple[1];

            Embedding embedding1 = model.embed(phrase1).content();
            Embedding embedding2 = model.embed(phrase2).content();

            double score = CosineSimilarity.between(
                    embedding1, embedding2
            );

            System.out.println("\nPhrase 1 : " + phrase1);
            System.out.println("Phrase 2 : " + phrase2);
            System.out.printf("Similarité : %.4f%n", score);
        }
    }
}
