java jdk 笔记
=====

1，javac命令

 **编译java文件并存放在classes目录下**
  - javac -d classes src\nio\NioServer.java
  - javac src\nio\NioServer.java -d classes


javac classpath (http://www.blogjava.net/caizh2009/archive/2010/10/19/335634.html)

**javac -classpath的使用**： 

javac：如果当前你要编译的java文件中引用了其它的类(比如说：继承)，但该引用类的.class文件不在当前目录下，这种情况下就需要在javac命令后面加上-classpath参数，通过使用以下三种类型的方法 来指导编译器在编译的时候去指定的路径下查找引用类。 

 - (1).绝对路径：javac -classpath c:\junit3.8.1\junit.jar   Xxx.java 
 - (2).相对路径：javac -classpath ..\junit3.8.1\Junit.javr  Xxx.java 
 - (3).系统变量：javac -classpath %CLASSPATH% Xxx.java -
 - (注意：%CLASSPATH%表示使用系统变量CLASSPATH的值进行查找，这里假设Junit.jar的路径就包含在CLASSPATH系统变量中) 
