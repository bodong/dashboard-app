package xyz.pakwo.dashboard.controller;

import org.openjdk.jol.info.GraphLayout;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** @author sarwo.wibowo */
public class SimpleTest {
  public static void main(String[] args) {
    Map<String, Object> data = new ConcurrentHashMap<>();
    data.put("test", 123232);
    data.put("test2", "Some data");

    long size = GraphLayout.parseInstance(data).totalSize();
    System.out.println("total size : " + size);

    data.put("test3", "Some data again lorem ipsum asdsds ");
    size = GraphLayout.parseInstance(data).totalSize();

    System.out.println("total size again : " + size);

    data.put("test4", getBiggerData(1000));

    size = GraphLayout.parseInstance(data).totalSize();

    System.out.println("total size last : " + size);

    System.out.println("total size last (human readable) : " + formatSize(size));
  }

  private static String getBiggerData(int max) {
    String str = "";
    for (int i = 0; i < max; i++) {
      str += "Lorem ipsum again again again";
    }

    return str;
  }

  private static String formatSize(long sizeData) {
    long absB = sizeData == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(sizeData);
    if (absB < 1024) {
      return sizeData + " B";
    }
    long value = absB;
    CharacterIterator ci = new StringCharacterIterator("KMGTPE");
    for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
      value >>= 10;
      ci.next();
    }
    value *= Long.signum(sizeData);
    return String.format("%.1f %ciB", value / 1024.0, ci.current());
  }
}
