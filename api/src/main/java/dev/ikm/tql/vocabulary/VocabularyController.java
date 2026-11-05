package dev.ikm.tql.vocabulary;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class VocabularyController implements HttpService {

	private final PredicateRegistry predicateRegistry;

	public VocabularyController(PredicateRegistry predicateRegistry) {
		this.predicateRegistry = predicateRegistry;
	}

	/**
	 * Configures the HTTP routing for the vocabulary endpoints.
	 *
	 * @param httpRules the HTTP rules to configure
	 */
	@Override
	public void routing(HttpRules httpRules) {
		httpRules.get("/vocabulary/predicates", this::listPredicates);

	}

	/**
	 * Handles the request to list all predicates in the vocabulary.
	 *
	 * @param serverRequest  the incoming server request
	 * @param serverResponse the server response to be sent back
	 */
	private void listPredicates(ServerRequest serverRequest, ServerResponse serverResponse) {

	}
}
