- the logger

```java

for(String[] rec: records){
    
    if (counter > 50) {
        break;
    }
    
    if (logger.isLoggable(java.util.logging.Level.INFO)) {
        // logger.info(Arrays.toString(rec));
        logger.log(Level.INFO, "Record  {0} : {1}", new Object[]{counter, String.join(", ", rec)});
    }   

    counter ++;

```

- the processor
```java

dataProcessor.randomProcess(records);

Map<String, Integer> artistPlayCount = dataProcessor.process(records);
artistPlayCount.forEach((artist, count) -> {
    System.out.println("Artist: " + artist + ", Play Count: " + count); // we can use logger here
});
        

```