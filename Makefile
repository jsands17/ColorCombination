JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Bicolor.java \
        ColorCombination.java \
        ColorCombinationMain.java \
	ColorCombinationTest.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class