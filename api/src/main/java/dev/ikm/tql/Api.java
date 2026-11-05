package dev.ikm.tql;

import dev.ikm.tql.vocabulary.PredicateRegistry;
import dev.ikm.tql.vocabulary.VocabularyController;
import io.helidon.webserver.WebServer;

public class Api {

    static void main(String[] args) {
        // Initialize the vocabulary and create the PredicateRegistry
        PredicateRegistry predicateRegistry;
        try {
            predicateRegistry = initializeVocabulary();
        } catch (Exception e) {
            System.err.println("Failed to start the server: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
            return;
        }

        WebServer server = WebServer.builder()
                .port(8080)
                .routing(routing -> routing.register(new VocabularyController(predicateRegistry)))
                .build()
                .start();

        System.out.println("Server started at http://localhost:" + server.port());
    }

    private static PredicateRegistry initializeVocabulary() {
        PredicateRegistry predicateRegistry = new PredicateRegistry();
        predicateRegistry.initialize();
        return predicateRegistry;
    }
}