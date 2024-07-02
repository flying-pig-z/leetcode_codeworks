### 一.涉及的并发知识点
#### 1.AtomicInteger
AtomicInteger 是 Java 中提供的一个原子操作类，用于在多线程环境下对整数进行原子操作，即不可分割的操作。

**它可以保证在并发情况下对整数的操作是线程安全的，避免了多个线程同时修改一个整数时可能引发的竞态条件和数据不一致性问题。**

具体来说，AtomicInteger 主要提供了以下几种功能：

原子更新操作：AtomicInteger 提供了诸如 incrementAndGet()、decrementAndGet()、getAndIncrement()、getAndDecrement() 等方法，这些方法能够以原子方式对整数进行自增、自减操作，并返回操作后的值。

CAS（Compare And Set）操作：AtomicInteger 使用了 CAS 操作来保证线程安全。CAS 是一种乐观锁的实现方式，当需要更新变量时，先比较当前值是否符合预期，如果符合则进行更新，否则重新尝试。

内存可见性：除了原子性操作外，AtomicInteger 也能保证多个线程对变量的修改对其他线程可见。这是通过底层的内存模型和内存屏障来实现的，确保了每个线程都能看到最新的值。

无锁操作：相比使用传统的 synchronized 关键字来保证线程安全，AtomicInteger 使用了更轻量级的 CAS 操作，因此性能更高，特别是在并发量较大的情况下能够提升程序的吞吐量。

在并发编程中，当多个线程需要对共享的整数进行操作时，使用 AtomicInteger 能够简化编程，并且避免了手动同步所带来的潜在性能问题和复杂性。

#### 2.Runnable接口
Runnable里面有run方法

#### 3.实现思路
题目简单说就是要让first second third顺序输出。这里的思路是输出2的时候检查1有没有输出，输出3的时候检查2有没有输出。



