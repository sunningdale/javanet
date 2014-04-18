java jdk 笔记
=====

1，javac命令

用法：javac <选项> <源文件>

其实选项不必放在源文件前面放在后面也是可以的


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


**javac参数(-classpath, -sourcepath)详解**
     首先是官方说法： 
     
-classpath:  设置用户类路径，它将覆盖 CLASSPATH 环境变量中的用户类路径。若既未指定 CLASSPATH 又未指定 
     -classpath，则用户类路径由当前目录构成。    
     -sourcepath:  指定用以查找类或接口定义的源代码路径。与用户类路径一样，源路径项用分号 (;) 
     进行分隔，它们可以是目录、JAR 归档文件或 ZIP 归档文件。
     如果使用包，那么目录或归档文件中的本地路径名必须反映包名。   
     注意：通过类路径查找的类，如果找到了其源文件，则可能会自动被重新编译。
     
     
     具体例子：      
     假设我们有如下的目录结构：     
     src-|           
         |-foo-|                     
               |-Testfoo.java           
         |-baz-|                      
               |-Testbaz.java
     classes-| 
     
     
     其中Testfoo.java:
     
     package foo; 
     public class Testfoo 
     { //.... }  
     其中Testbaz.java: package baz; 
     import foo.Testfoo; 
     public class Testbaz { //... }  
     也就是说Testbaz对Testfoo有引用。
     
     
     我们目标是把Testbaz编译到目录classes里面，试用如下的命令：
     
     javac -d classes src/baz/Testbaz.java  命令失败，因为找不到它依赖的Testfoo。
     我们可以用以下三种方式来实现：        
     1.我们最容易考虑到的就是编译被依赖的Testfoo类，并将其加入Testbaz的CLASSPATH 
       javac -d classes src/foo/Testfoo.java  
       javac -d classes -classpath classes src/baz/Testbaz.java     
       第二行使用了-classpath，使得编译器在寻找Testfoo类的时候以classes为根目录，
     根据根目录和package名，类名最终定位了需要用的（已编译出来的）Testfoo类。  
     
     2.在编译Testbaz的时候把被依赖的Testfoo类加入SOURCEPATH 
     javac -d classes -sourcepath src src/baz/Testbaz.java  
     在编译条件里面加入-verbose可以很清楚的看到，编译器在寻找Testfoo类的时候，
     以src为根目录，根据根目录和package名，类名最终定位了需要用的（源代码）Testfoo类。
     
     3.把CLASSPATH和SOURCEPATH两者都加进来 
     javac -d classes src/foo/Testfoo.java  
     javac -d classes -sourcepath src -classpath classes src/baz/Testbaz.java  
     两个属性都被加入，编译器首先会判断Testfoo.class和Testfoo.java是否同时存在。
     如果单独存在，则适应于以上的方法之一。如果同时存在，则判断.class是否是.java的最新编译，
     如果有差异，则重新编译.java来覆盖.class    
     
有必要补充一下-d参数:  
     -d参数是很好的把源程序和目标代码分离的参数。-d制定的是目标代码的根目录，
     源文件的包的结构将以目录形式反映到根目录上。
     美中不足的是-d需要指定已经存在的目录，不能自动创建。 
