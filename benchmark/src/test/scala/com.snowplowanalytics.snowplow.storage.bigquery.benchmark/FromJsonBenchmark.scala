package com.snowplowanalytics.snowplow.storage.bigquery.benchmark

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._
import com.snowplowanalytics.snowplow.storage.bigquery.loader.LoaderRow

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime, Mode.Throughput))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class FromJsonBenchmark {
  @Benchmark
  def fromJson(state: States.ExampleEventState): Unit = {
    LoaderRow.fromJson(state.resolver)(state.baseEvent)
  }
}
