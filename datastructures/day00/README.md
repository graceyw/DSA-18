# Day 00

## Learning Goals and Student Input

Help us get to know you and provide input to the class by filling out [this](https://goo.gl/forms/iIcRZXaDP6nuO7fD2) Google form.

For info on the class that is not represented on the syllabus, refer to our intro slides [here](https://drive.google.com/open?id=14W94RU1IpB8Sfvl7VP9Px4VlwRQ7Nl0Vg7PxyvgXs-Y).

## Getting Set

### Git

If you don't have `git` installed:

```
sudo apt-get update
sudo apt-get install git-core
git config --global user.name "Firstname Lastname" # your name here
git config --global user.email "mygitemail@example.com" # the email used with your github account
```

Then:

- Follow [these](./GitSetup.md) instructions to fork our repository and add our repo as `upstream`.

**Optional** Complete **at least 10 levels** of [this](http://learngitbranching.js.org/) Git tutorial.

### Java 9

Run the following commands:

```
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java9-installer
sudo apt-get install oracle-java9-set-default
```

Run `java -version` and ensure your output matches the following:

```
java version "9.0.4"
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
```

### Installing IntelliJ

The IDE we recommend for this class is IntelliJ. If you have another preferred
IDE, that's fine. Here's how to install IntelliJ:

```
sudo add-apt-repository ppa:ubuntu-desktop/ubuntu-make
sudo apt update
sudo apt install ubuntu-make
umake ide idea
```

Set up IntelliJ according to your preferences!

### Getting started with the code

- Open IntelliJ. If IntelliJ opens a project, click *File > Close Project*. Then click *Open*, and navigate to `datastructures/day00`.
- If you don't see the Project sidebar on the left, click on `View > Tool Windows > Project`.
- Open up `src/HelloWorld.java`. Right click on the `main` method and choose `Run`.

### Debugger

- **Optional but recommended:** Read instructions inside `HelloWorld.java` to play around with IntelliJ's debugging tool. Become at least acquainted with breakpoints, the `Debug` button, the `Variables` window, and the `Step Over`, `Step Into` and `Step Out` buttons.

### If you have errors

- If the `.java` files' icons are a red J instead of a blue C, right click on the `src/` folder and click on `Mark Directory As > Sources Root`
- If you have unrecognized imports, right click on the `lib/` folder and click on `Add as Library`
- If you see a yellow bar at the top, click on `Setup SDK/JDK` and choose `Java 1.9`
- If you get the error

> Cannot start compilation: the output path is not specified for module "day00".
> Specify the output path in Configure Project.

Click OK. A new window should open. IntelliJ needs you to specify a place for it to dump compiled Java code. On the left sidebar, choose `Project`. The last option, `Project compiler output`, should be empty (which is why it was complaining). Browse to and choose `day00/out/` as the compiler output folder. If that folder does not exist, simply `cd` into the `day00` directory, and execute `mkdir out/`. Run `main` again.

# Assignment Checklist

- [ ] I've filled out [this](https://goo.gl/forms/iIcRZXaDP6nuO7fD2) Google form to provide input and learning goals (also linked at the top of this README)
- [ ] Git is installed.
- [ ] I've forked the DSA-18 repository using [these](./GitSetup.md) instructions
- [ ] I've added the DSA-18 repository as an upstream remote
- [ ] IntelliJ is installed and I've run `HelloWorld.java`
- [ ] **Optional** I've familiarized myself with the debugger.
- [ ] **Optional** I've completed 10 levels of the [Git tutorial](http://learngitbranching.js.org/)
- [ ] I've joined [the DSA channel](https://olin.slack.com/messages/dsa-18) `#dsa-18` on Slack.
- [ ] I've filled out [this](https://goo.gl/forms/epFStUdhHJpqvJ0h2) Google form regarding getting set.
