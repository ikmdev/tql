package dev.ikm.tql;

import rife.bld.Project;
import rife.bld.dependencies.Repository;
import java.util.List;
import static rife.bld.dependencies.Repository.MAVEN_CENTRAL;
import static rife.bld.dependencies.Repository.RIFE2_RELEASES;
import static rife.bld.dependencies.Scope.compile;
import static rife.bld.dependencies.Scope.test;

public class ApiBuild extends Project {
	public ApiBuild() {
		pkg = "dev.ikm.tql";
		name = "api";
		mainClass = "dev.ikm.tql.Api";
		version = version(0, 1, 0);

		downloadSources = true;
		repositories = List.of(
				MAVEN_CENTRAL,
				RIFE2_RELEASES,
					new Repository (
						"https://nexus.yourcompany.com/repository/maven-releases/",
						System.getProperty("nexus.user"),
						System.getProperty("nexus.password")
				));

		var helidonVersion = version(27, 0, 1); // check latest release

		scope(compile)
				// Core web server + routing
				.include(dependency("io.helidon.webserver", "helidon-webserver", helidonVersion))
				// JSON support for request/response bodies (optional, but typical for REST)
				.include(dependency("io.helidon.http.media", "helidon-http-media-jackson", helidonVersion));

		scope(test)
				.include(dependency("org.junit.jupiter", "junit-jupiter", version(6, 1, 3)))
				.include(dependency("org.junit.platform", "junit-platform-console-standalone", version(6, 1, 3)))
				.include(dependency("io.helidon.webserver.testing.junit5", "helidon-webserver-testing-junit5", helidonVersion));
	}

	static void main(String[] args) {
		new ApiBuild().start(args);	
	}
}