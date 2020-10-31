# GC 总结

```sh
# 串行 GC
java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

# 并行 GC
java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

# CMS GC
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

# G1 GC
java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

## 年轻代

### Serial

- 单线程
- 简单高效
- 适合 client 模式
- 参数
  - -XX:parallelGCThreads  GC 线程数

### ParNew

- Serial 多线程版本
- server 模式下首选的新生代收集器：可以合 CMS 收集器配合
- 参数
  - GC 最大停顿时间 -XX:MaxGCPauseMillis
  - 吞吐量         -XX:GCTimeRatio
  - 日使用调节模式  -XX:+UseAdaptiveSizePolicy

### Parallel Scavenge

- 复制算法
- 目标：达到一个可控制的吞吐量 (Throughput = 逻辑代码时间/(逻辑代码时间 + 垃圾收集时间))


## 老年代

### Serial Old

- 标记整理
- JDK 1.5 之前 与 Parallel Scavenge 配合使用
- 作为 CMS 收集器的后背预案，在并发收集发生 Concurrent Mode Failure


### Parallel Old

- Parallel Scavenge 老年代版本
- 标记整理算法

### CMS

- 目标：最酸回收停顿时间
- 过程
  - CMS initial mark
  - CMS concurrent mark
  - CMS remark 
  - CMS concurrent sweep
- 并发收集，低停顿 Concurrent Low Pause
- 缺点
  - CPU 资源敏感；并发结算会占用一部分线程而导致应用程序变慢
  - 无法处理浮动垃圾，可能狐仙 Concurrent Mode Failure 失败导致另一次 FullGC 产生
    - 浮动垃圾是指在清理过程中产生的新垃圾
  - 标记-清除导致收集结束产生大量空间碎片，导致大对象没有足够连续的空间可以分配
  
## G1

- 优点
  - 并行与并发
  - 分代收集
  - 空间整合
  - 可预测的停顿
- 过程
  - Initial Marking
  - Concurrent Marking
  - Final Marking
  - Live Data Counting and Evacuation

