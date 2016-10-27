# 1 启动时抛java.lang.ClassNotFoundException: rx.Single

	at java.net.URLClassLoader$1.run(URLClassLoader.java:366) ~[na:1.7.0_79]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:355) ~[na:1.7.0_79]
	at java.security.AccessController.doPrivileged(Native Method) ~[na:1.7.0_79]
	at java.net.URLClassLoader.findClass(URLClassLoader.java:354) ~[na:1.7.0_79]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:425) ~[na:1.7.0_79]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:308) ~[na:1.7.0_79]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:358) ~[na:1.7.0_79]
	... 55 common frames omitted
	

https://github.com/spring-cloud/spring-cloud-netflix/issues/1019	