
| 参数       | 默认值 | 说明                 |
|:-----------|:------|:--------------------|
| clientPort | 2181  | 客户端连接server的端口 |
|  dataDir   |/tmp/zookeeper   |存储快照文件snapshot目录。默认情况下，事物日志也会存储在这里。建议同时配置参数dataLogDir，事物日志的写性能直接影响zk性能 |
|dataLogDir | |  事物日志输出目录。尽量给事物日志一个单端的磁盘或者挂载点，可以提升性能|
| tickTime | 2000(毫秒) | ZK中的一个时间单元。ZK中所有的时间都是以这个时间单元为基础，进行的整数倍配置|
|initLimit|10|Follower在启动过程中，会从Leader同步所有最新数据，然后确定自己能够对外服务的起始状态。Leader允许F在 initLimit 时间内完成这个工作 |
|syncLimit|5|在运行过程中，Leader负责与ZK集群中所有机器进行通信，例如通过一些心跳检测机制，来检测机器的存活状态。如果L发出心跳包在syncLimit之后，还没有从F那里收到响应，那么就认为这个F已经不在线了|
|server.x=[hostname]:[:mmmm][:nnnnn]| |这里的x是一个数字，与myid文件中的id是一致的。右边可以配置两个端口，第一个端口用于F和L之间的数据同步和其它通信，第二个端口用于Leader选举过程中投票通信。  |
|maxClientCnxns|60|单个客户端与单台服务器之间的连接数的限制，是ip级别的，默认是60，如果设置为0，那么表明不作任何限制|
|minSessionTimeoutmaxSessionTimeout|2 *  tickTime ~ 20 * tickTime |Session超时时间限制，如果客户端设置的超时时间不在这个范围，那么会被强制设置为最大或最小时间|
|globalOutstandingLimit| |最大请求堆积数。默认是1000。ZK运行的时候， 尽管server已经没有空闲来处理更多的客户端请求了，但是还是允许客户端将请求提交到服务器上来，以提高吞吐性能。当然，为了防止Server内存溢出，这个请求堆积数还是需要限制下的。|
|preAllocSize|64M|预先开辟磁盘空间，用于后续写入事务日志。默认是64M，每个事务日志大小就是64M。如果ZK的快照频率较大的话，建议适当减小这个参数 |



