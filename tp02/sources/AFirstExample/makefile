all:
	javac SimpleJNI.java
	javah -jni AClassWithNativeMethods
	cc -c -I/System/Library/Frameworks/JavaVM.framework/Headers TheNativeMethodImpl.c
	cc -dynamiclib -o libNativeMethodImpl.jnilib TheNativeMethodImpl.o -framework JavaVM

run:
	@java -Djava.library.path=. SimpleJNI

clean:
	@rm -f *.o
	@echo Done

clean_all:
	@rm -f *.o
	@rm -f *.h
	@rm -f *.class
	@rm -f *.jnilib
	@echo Done