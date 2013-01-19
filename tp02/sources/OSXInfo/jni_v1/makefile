all:
	javac ShowOSXInfo.java
	javah -jni ShowOSXInfo
	cc -c -I/System/Library/Frameworks/JavaVM.framework/Headers osxinfo.c
	cc -dynamiclib -o libosxinfo.jnilib osxinfo.o -framework JavaVM -framework CoreServices

run:
	@java -Djava.library.path=. ShowOSXInfo

clean:
	@rm -f *.o
	@echo Done

clean_all:
	@rm -f *.o
	@rm -f *.h
	@rm -f *.class
	@rm -f *.jnilib
	@echo Done