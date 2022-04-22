/open ImmutableMap.java

ImmutableMap<String, Integer> map = new ImmutableMap<String, Integer>();
map.put("one", 1);
map.put("one", 1).isEmpty();
map.put("one", 1).put("two", 2).put("three", 3);
map;
map.isEmpty();
map.put("one", 1).put("two", 2).put("three", 3).put("one", 11);

/exit
