## Graphs 05

This homework is due on **Tuesday, April 24th**
It is strongly recommended you work with a partner for this assignment

Congrats on solving the 8-puzzle! We now have another classic challenge for you: solve a Rubik’s Cube! For computation’s sake, we are only asking you to solve a 2x2x2 cube. Due to the potential complexity of this assignment we are giving you two options for this homework. But first some terminology:

### Resources

* [Our Slides](https://drive.google.com/open?id=1laH_lHZGCGfWeQ-lmDR2Wh_Be6R0Br2_xBDWKLj_yaY)

### Glossary

* Block - A single colored square. There are 24 blocks on a 2x2x2 Rubik's Cube
* Cubie - An unalterable piece of the cube, the corner. Each cubie contains 3 blocks. There are 8 cubies on a 2x2x2 Rubik’s Cube
* Face - A side of a Rubik's Cube. Each face is made up of four blocks and four cubies. There are 6 faces on a 2x2x2 Rubik's Cube.
* Rotation - Counterclockwise or clockwise movement of the cubies relative to a given face. There are 6 specific and unique rotations, where direction is defined as when looking at the front face of the cube:
    * Rotate the front face clockwise: **f**
    * Rotate the upper face clockwise: **u**
    * Rotate the right face clockwise: **r**
    * Rotate the front  face counterclockwise: **F**
    * Rotate the upper face counterclockwise: **U**
    * Rotate the right face counterclockwise: **R**
* Solved - When every face is composed of four blocks of the same color.

![](https://i.imgur.com/1XeMT1L.png)

### Option 1- Create your own data-structure, and use BFS

Keeping true to the name of **Data Structures** and Algorithms, in this version of the homework you will be implementing your own model of a 2x2x2 Rubik's Cube, as a class in `RubicksCube.java` .

Methods and variables (written out as shown) necessary for passing our tests will be:

* `public RubiksCube()` - Constructor for the `RubiksCube` class. Creates a solved version of the cube.
* `public boolean equals(Object cube)` - Takes in a Rubik’s Cube object and compares it to itself for equality.
* `public int hashCode()` - overrides hashCode, allowing for hash-set/hash-map functionality with RubiksCube objects
* `public RubiksCube rotate(char c)` - Takes in a character that represents the rotation of a face (see above) and performs that rotation on your cube model. This returns a new Rubik’s Cube (it doesn’t modify the original)
* `public boolean isSolved()` - Returns whether the cube this method is called on is in a solved state.
* `public List<Character> solve()` - Returns the set of rotations as a list of characters (see above for notation) needed to solve the cube this method is called on. For this option you need only use BFS, however feel free to use A* (or something else!) if you want an extra challenge.

The tradeoff comes in that instead of writing an A* solution, you just need to implement BFS for your `solve` method. No heuristic necessary!

### Option 2 - Create your own heuristic and search algorithm, use our data-structure

Alternatively, you can use the Rubik’s Cube class we provide. You will need to understand how it works (refer to the slides). You will come up with your own heuristic and implement an A* solution (or some other interesting algorithm). Your algorithm should solve the Rubik’s cube faster and more efficiently than a BFS approach.

Your heuristic should provide information that quantifies how “solved” a Rubiks’s cube is. This information helps your algorithm to go to the right direction when exploring solutions.

**Stop reading now if you intend to do Option 1**

In the provided RubiksCube class, a Rubik’s Cube is represented with a BitSet of size 72, where every 3 bits represents a block. Each of the 24 blocks stores a color, where colors are represented by a integer from 0-6. Each integer is converted into 3 bits in binary. For example, 0 is [0,0,0], and 6 is [1,1,0]. There are 24 blocks in total on a cube, and that’s why we need 24x3=72 bits.

Each block is numbered as follows:

![](https://i.imgur.com/7Qb7kz0.jpg)

That is, [0, 21, 16] is one cubie, and [6, 11, 14] is another.

The RubiksCube class contains following methods:

* `RubiksCube()`:   The constructor creates a BitSet of size 24*3. Each face on Rubik’s Cube is represented with 4 adjacent bits. For example, [0,1,2,3] is one face, and [4,5,6,7] is another face. The constructor also assigns color to all faces and produces a solved Rubik’s Cube.
* `setColor(int index, int color)` : This method assigns a color to a block. A block is indexed from [0-23], and color [0-5].
* `getColor(int index)` : This function returns a specific block’s color. `index` is from [0-23].
* `rotate(List<Character> c)`： This methods takes a list of rotation commands (see glossary for notation). This methods calls rotate(char c) on each command.
* `rotate(char c)`: This method rotates a Rubik’s Cube based on the command.
* `intToBitset(int i)`: Convert an integer to a bitset of size 3
* `bitsetToInt(BitSet s)`: Convert a bitset to an integer
* `equals(Object obj)`： Assert that two Rubik’s Cubes have the same configuration
* `hashCode()*`: Return a hashcode of the Bitset
* `isSolved()`: Check the current cube with a newly constructed cube which is by default solved.

To get started, delete `src/RubiksCube` and replace it with `ourimplementation/RubiksCube`.
