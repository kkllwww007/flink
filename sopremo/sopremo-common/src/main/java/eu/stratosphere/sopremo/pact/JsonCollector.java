package eu.stratosphere.sopremo.pact;

import org.codehaus.jackson.JsonNode;

import eu.stratosphere.pact.common.stub.Collector;
import eu.stratosphere.sopremo.pact.PactJsonObject.Key;

public class JsonCollector {
	private final Collector<PactJsonObject.Key, PactJsonObject> collector;

	public JsonCollector(Collector<Key, PactJsonObject> collector) {
		this.collector = collector;
	}

	public void collect(JsonNode key, JsonNode value) {
		if (SopremoUtil.LOG.isDebugEnabled())
			SopremoUtil.LOG.debug(String.format(" to %s/%s", key, value));
		this.collector.collect(PactJsonObject.keyOf(key), PactJsonObject.valueOf(value));
	}
}
