Classfile /Users/jerry_zhang/pp/JAVA-000/Week_01/notes/FirstSample.class
  Last modified Oct 18, 2020; size 636 bytes
  MD5 checksum 944fb56a2498efbf6982408a0a39fc87
  Compiled from "FirstSample.java"
public class FirstSample
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #7.#18         // java/lang/Object."<init>":()V
   #2 = Fieldref           #19.#20        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Methodref          #21.#22        // java/io/PrintStream.println:(I)V
   #4 = String             #23            // We will not use 'Hello, World!'
   #5 = Methodref          #21.#24        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #6 = Class              #25            // FirstSample
   #7 = Class              #26            // java/lang/Object
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               main
  #13 = Utf8               ([Ljava/lang/String;)V
  #14 = Utf8               StackMapTable
  #15 = Class              #27            // "[Ljava/lang/String;"
  #16 = Utf8               SourceFile
  #17 = Utf8               FirstSample.java
  #18 = NameAndType        #8:#9          // "<init>":()V
  #19 = Class              #28            // java/lang/System
  #20 = NameAndType        #29:#30        // out:Ljava/io/PrintStream;
  #21 = Class              #31            // java/io/PrintStream
  #22 = NameAndType        #32:#33        // println:(I)V
  #23 = Utf8               We will not use 'Hello, World!'
  #24 = NameAndType        #32:#34        // println:(Ljava/lang/String;)V
  #25 = Utf8               FirstSample
  #26 = Utf8               java/lang/Object
  #27 = Utf8               [Ljava/lang/String;
  #28 = Utf8               java/lang/System
  #29 = Utf8               out
  #30 = Utf8               Ljava/io/PrintStream;
  #31 = Utf8               java/io/PrintStream
  #32 = Utf8               println
  #33 = Utf8               (I)V
  #34 = Utf8               (Ljava/lang/String;)V
{
  public FirstSample();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:i
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=7, args_size=1
         0: iconst_1
         1: istore_1
         2: bipush        56
         4: istore_2
         5: iload_1
         6: iload_2
         7: iadd
         8: istore_3
         9: iload_3
        10: iload_1
        11: imul
        12: istore        4
        14: iload         4
        16: iload_1
        17: idiv
        18: istore        5
        20: iconst_0
        21: istore        6
        23: iload         6
        25: iload         5
        27: if_icmpge     62
        30: iload         6
        32: iconst_2
        33: irem
        34: ifne          48
        37: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        40: iload         6
        42: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        45: goto          56
        48: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        51: iload         5
        53: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        56: iinc          6, 1
        59: goto          23
        62: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        65: ldc           #4                  // String We will not use 'Hello, World!'
        67: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        70: return
      LineNumberTable:
        line 5: 0
        line 6: 2
        line 7: 5
        line 8: 9
        line 9: 14
        line 11: 20
        line 12: 30
        line 13: 37
        line 15: 48
        line 11: 56
        line 20: 62
        line 22: 70
      StackMapTable: number_of_entries = 4
        frame_type = 255 /* full_frame */
          offset_delta = 23
          locals = [ class "[Ljava/lang/String;", int, int, int, int, int, int ]
          stack = []
        frame_type = 24 /* same */
        frame_type = 7 /* same */
        frame_type = 250 /* chop */
          offset_delta = 5
}
SourceFile: "FirstSample.java"