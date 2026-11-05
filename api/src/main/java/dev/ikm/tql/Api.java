package dev.ikm.tql;

import dev.ikm.tql.vocabulary.PredicateRegistry;
import dev.ikm.tql.vocabulary.VocabularyController;
import io.helidon.webserver.WebServer;
import org.slf4j.Logger;

public class Api {
    
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Api.class);

    static void main(String[] args) {
        // Initialize the vocabulary and create the PredicateRegistry
        PredicateRegistry predicateRegistry;
        try {
            predicateRegistry = initializeVocabulary();
        } catch (Exception e) {
            System.err.println("Failed to start the server: " + e.getMessage());
            LOG.error("Failed to start the server", e);
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