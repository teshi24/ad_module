package ch.hslu.ad.sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AhaRuntime {
  private final static Logger LOG = LogManager.getLogger(AhaRuntime.class);

  private final static Map<String, Integer> TASK_CALLS = new HashMap<>();
  private final static String TASK_1 = "task 1";
  private final static String TASK_2 = "task 2";
  private final static String TASK_3 = "task 3";

  public static void main(String[] args) {
    runMethods(1);
    runMethods(2);
    runMethods(3);
    runMethods(4);
    runMethods(5);
    runMethods(6);
    runMethods(7);
    runMethods(8);
    runMethods(9);
    runMethods(10);
  }

  private static void runMethods(final int n) {
    initializeTasks();
    executeTasks(n);
    printTaskCalls(n);
  }

  private static void printTaskCalls(final int n) {
    LOG.info("-------- {} --------", n);
    LOG.info("Task: Counts");
    TASK_CALLS.forEach((key, value) -> LOG.info("{}: {}", key, value));
    LOG.info("TOTAL: {}", TASK_CALLS.values().stream().mapToInt(Integer::valueOf).sum());
  }

  private static void initializeTasks() {
    TASK_CALLS.put(TASK_1, 0);
    TASK_CALLS.put(TASK_2, 0);
    TASK_CALLS.put(TASK_3, 0);
  }

  public static void executeTasks(final int n) {
    task1();
    task1();
    task1();
    task1(); // T ~ 4
    for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
      task2();
      task2();
      task2(); // T ~ n · 3
      for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
        task3();
        task3(); // T ~ n · n· 2
      }
    }
  }

  private static void increaseTaskCallCounter(final String taskKey) {
    TASK_CALLS.put(taskKey, TASK_CALLS.get(taskKey) + 1);
  }

  private static void task1() {
    increaseTaskCallCounter(TASK_1);
    try {
      Thread.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void task2() {
    increaseTaskCallCounter(TASK_2);
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void task3() {
    increaseTaskCallCounter(TASK_3);
    try {
      Thread.sleep(15);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
