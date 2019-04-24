## 为什么要搭建内网穿透

其实很简单，云服务器资源太贵，买不起，本地还有笔记本等破机器，可以在搭建微服务的时候需要大量硬件资源的试试起到作用

### 前提条件

1. 需要一个服务器（个人拥有一台最低配的阿里云刚好可以使用）

2. 需要一个绑定好个人服务的域名

### 搭建ngrok内网穿透

1. **安装go语言**

   `yum install -y golang`

2. **配置本地环境变量**

   ```bash
   vim /etc/profile
   export NGROK_DOMAIN="xxx"//xxx为你的域名
   
   source /etc/profile
   ```

3. **下载ngrok源码包**

```bash
cd /usr/local
//创建目录
mkdir ngrok
cd ngrok
git clone https://github.com/inconshreveable/ngrok.git
```

4. **生成证书**

   ```bash
    cd /usr/local/ngrok
    mkdir cert
    cd cert
    openssl genrsa -out rootCA.key 2048
    openssl req -x509 -new -nodes -key rootCA.key -subj "/CN=$NGROK_DOMAIN" -days 5000 -out rootCA.pem
    openssl genrsa -out server.key 2048
    openssl req -new -key server.key -subj "/CN=$NGROK_DOMAIN" -out server.csr
    openssl x509 -req -in server.csr -CA rootCA.pem -CAkey rootCA.key -CAcreateserial -out server.crt -days 5000
   
   ```

5. **覆盖原来的证书**

```
 cp rootCA.pem /usr/local/ngrok/ngrok/assets/client/tls/ngrokroot.crt
 cp server.crt /usr/local/ngrok/ngrok/assets/server/tls/snakeoil.crt
 cp server.key /usr/local/ngrok/ngrok/assets/server/tls/snakeoil.key
```

6. **编译生成ngrokd服务端与客户端**

   ```bash
   cd /usr/local/ngrok/ngrok
   GOOS=linux GOARCH=amd64 make release-server
   GOOS=windows GOARCH=amd64 make release-client
   #Linux 平台 32 位系统：GOOS=linux GOARCH=386
   #Linux 平台 64 位系统：GOOS=linux GOARCH=amd64
   #Windows 平台 32 位系统：GOOS=windows GOARCH=386
   #Windows 平台 64 位系统：GOOS=windows GOARCH=amd64
   #MAC 平台 32 位系统：GOOS=darwin GOARCH=386
   #MAC 平台 64 位系统：GOOS=darwin GOARCH=amd64
   #ARM 平台：GOOS=linux GOARCH=arm
   ```

7. **运行服务器**

   ```bash
   setsid ./bin/ngrokd -tlsKey="assets/server/tls/snakeoil.key" -tlsCrt="assets/server/tls/snakeoil.crt" -domain="xxx" -httpAddr=":8081" -httpsAddr=":8082" -tunnelAddr=":8083" //xxx为域名
   ```

8. **运行window端的客户端**

   1. 将原来编译好windows_amd64移动到自己机器上来

   2. 编写ngrok.cfg文件

      ```text
      server_addr: "xxx:8083"  //xxx为域名 
      trust_host_root_certs: false
      ```

   3. 编写run.bat文件

      ngrok -config=ngrok.cfg -hostname=xxx 8081

9. **运行run.bat**

   ```bash
   //出现以下内容表示成功链接：
   ngrok
   
   Tunnel Status                 online
   Version                       1.7/1.7
   Forwarding                    http://xxx:8081 -> 127.0.0.1:80
   Forwarding                    https://xxx:8081 -> 127.0.0.1:80
   Web Interface                 127.0.0.1:4040
   # Conn                        0
   Avg Conn Time                 0.00ms
   ```

   