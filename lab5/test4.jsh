/open ImmutableMap.java
ImmutableMap<String, Integer> map = new ImmutableMap<String, Integer>()
map = map.put("one", 1).put("two", 2).put("three", 3)
// iteration via enhanced for loop
for (Map.Entry<String, Integer> e : map) {
System.out.println(e);
System.out.println(e.getValue() + " is mapped to " + e.getKey());
}
Iterator<Map.Entry<String, Integer>> iter = map.iterator()
while (iter.hasNext()) {
System.out.println(iter.next());
}
/exit