/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package events;

public class SagaEndEvent {

  private String name;
  private long endId;

  private SagaEndEvent() {
  }

  public SagaEndEvent(long endId) {
    this.endId = endId;
    this.name = "End";
  }

  public String getName() {
    return name;
  }

  public long getEndId() {
    return endId;
  }

  @Override
  public String toString() {
    return String.format("Saga %s %d", this.name, this.endId);
  }
}
