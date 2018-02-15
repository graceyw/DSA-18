# Day04 - Hashmaps

## Learning Goals:

Students will be able to:

- Know how to use Maps in software engineering applications.
- Create an efficient implementation of Java's `Map` interface using an array of `LinkedList`s of key-value pairs.
- Understand the key concepts of hashing
  - Understand hash functions and considerations when creating them
  - Understand how a hash map chooses which bucket to place objects in
- Understand how a hash map achieves average constant time for `put`, `get`, and `remove`.
- Identify when using a map / hash map is effective

## Due Date:

Midnight, Feb. 8, 2018


## Assignment

### Resources
- [Here](https://drive.google.com/open?id=194aE2RZ4tUBX4s9Ek1ot6HXRmfbfc2P4) are our slides for hashmaps.

- Today in lecture we spoke about the requirements of hash functions, but didn't actually cover how to write one. If you're curious, [this](https://youtu.be/VeHDbC02ENA?t=48s) video has got you covered.
- The Princeton Algorithms class has a great [video lecture](https://youtu.be/0Yor2eyR2U4) about how to use multiple buckets proportional to the number of key-value pairs in the Hashmap, a concept they call Separate Chaining. Their implementation is not identical to ours, but it should give you an idea about how you can write your functions.
- [This](https://youtu.be/shs0KM3wKv8?t=7s) this is a really short video explaining hashmaps. It does a really good job explaining exactly what a hash function does, and how it's used in Hashmaps.

### Code

In this assignment, you will be implementing your own Java Map. That is, your object will satisfy the Java Map API. If your code isn't passing tests, make sure you understand what each of your functions is supposed to do by reading the [Java Map API](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html). There are also comments in the code detailing what each function should do.

In `MyHashMap.java`, implement:
* `chooseBucket(Object key)`
* `get(Object key)`
* `containsKey(Object key)`
* `containsValue(Object value)`
* `rehash(double growthFactor)`
* `put(K key, V value)`
* `remove(Object key)`

### Problems

Read SillyString.java. Understand the potential use of this class and try to identify issues with its hashCode() method.

### Optional

- Learn about another implementation of Hashmaps called a Linear Probing Hash Map from this [video lecture](https://www.youtube.com/watch?v=En5dVdkDF-E). This is the implementation Java actually uses, and it has much better real-life performance that our Separate Chaining Hashmap (though not better big-O performance).

### Checkoff

To be checked off, you'll be expected to explain (among other things):
- the main purpose of a hash function. Are there any requirements or limitations when hashing?
- at least one problem with SillyString's hash function.

### Survey

You can fill out the survey ahead of next class [here](tinyurl.com/OlinDSA4).
