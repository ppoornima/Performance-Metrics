package example;

import static spark.Spark.before;

import com.codahale.metrics.*;

import java.util.concurrent.TimeUnit;
import static spark.Spark.get;

public class MetricsTester {
	static final MetricRegistry metrics = new MetricRegistry();

	public static void main(String args[]) {
		startReport();
		Meter requests = metrics.meter("requests");

		before((request, response) -> {
			requests.mark();
		});

		get("/metrics", (req, res) -> {
			return "Hello World";
		});

	}

	static void startReport() {
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
				.convertRatesTo(TimeUnit.SECONDS)
				.convertDurationsTo(TimeUnit.MILLISECONDS).build();
		reporter.start(10, TimeUnit.SECONDS);
	}
}
