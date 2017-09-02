#asyn4j

asyn4j 是一个java异步方法调用框架，基于消费者与生产者模式。
async4j就是基于Executors线程池和反射机制实现的。

包括了异步方法执行，异步回调执行，异步工作缓存模块.支持Spring.
让我们写异步方法不再写很多的相关多线程代码。用asyn4j轻松搞定异步方法调用.提高程序的响应能力.

1.3.1更新 [下载](http://git.oschina.net/chenjinglys/asyn4j/attach_files/download?i=70626&u=http%3A%2F%2Ffiles.git.oschina.net%2Fgroup1%2FM00%2F00%2FAC%2FPaAvDFhKIX-AHwYEAACTzGkNepM350.jar%3Ftoken%3De6ca14cc9809d65179c0d154a872358e%26ts%3D1481253241%26attname%3Dasyn4j-1.3.1.jar)
    1.优化日志,支持sf4j
    2.文件异步存储FileAsynServiceHandler,在window和linux下缓存文件路径修复
    3.调用普通方法，提出工具类com.googlecode.asyn4j.Asyn4jHelper [详细](http://git.oschina.net/chenjinglys/asyn4j/wikis/asyn4j%E6%99%AE%E9%80%9A%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%8F%90%E5%8F%96)


历史版本及描述

项目地址:http://asyn4j.googlecode.com
源码SVN : http://asyn4j.googlecode.com/svn/branches/asyn4j
WIKI: http://code.google.com/p/asyn4j/wiki/user_guide

2011年已经停止更新，最终版本1.3
![输入图片说明](http://git.oschina.net/uploads/images/2016/1209/100606_5a7f58ae_417742.png "在这里输入图片标题")

1.3更新
   1.优化代码
   2.新增任务持久与恢复功能
   3.任务调用和回调做为一个整体

1.2更新
   1.设置关闭服务延时
   2.设置异步工作超时设置
   3.使用信号量设置最大工作队列
   4.优化用户接口

1.1更新
   1.异步工作分为三个权重
   2.增加关闭服务处理器
   3.增加异步工作执行异常处理器
   4.Spring 支持完善