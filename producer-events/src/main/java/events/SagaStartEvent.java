/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package events;

public class SagaStartEvent {

  private String name;
  private long startId;

  private SagaStartEvent() {
  }

  public SagaStartEvent(long startId) {
    this.startId = startId;
    this.name = "Start";
  }

  public String getName() {
    return name;
  }

  public long getStartId() {
    return startId;
  }

  @Override
  public String toString() {
    return String.format("Saga %s %d", this.name, this.startId);
  }
}
