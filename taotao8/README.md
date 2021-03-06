# SSM-SOA
## 第六天：solr，日志文件

## solr下载安装启动
下载地址 http://archive.apache.org/dist/lucene/solr/5.4.1/

其中： 
1. src.tgz：带src表示是带源码文件的压缩包，无src是已经编译过的压缩包 
2. .tgz：Linux相关操作系统使用的压缩包 
3. .zip：Windows操作系统使用的压缩包

找到start.jar文件将其放入example目录下

solr的启动、停止、查看命令： 
1. 启动：bin\solr.cmd start 
2. 停止：bin\solr.cmd stop 或bin\solr.cmd stop -all 
3. 查看：bin\solr.cmd status

启动之后就可以打开浏览器输入地址http://localhost:8983/solr/#/来查看solr的管理控制台了

## 启动方式: 
 配置链接https://blog.csdn.net/qq_33195578/article/details/53350525

 1、部署在Tomcat。2、自带jetty服务器启动

以Tomcat为例

1.将solr-5.5.3下的service下的solr-webapp复制到Tomcat 下的webapp下，并改名solr（名字随意）；

2.将solr-5.5.3下的service下的lib下的ext下的所有jar包复制到Tomcat下solr下web-inf下lib下；

3.在Tomcat下solr下web-inf创建classes文件夹，并把solr5.5.3下的solr-5.5.3\solr-5.5.3\example\resources下的log4.perportiy复制到classes文件下；

到此，启动Tomcat，可以正常访问solr了，localhost:8080/solr/index.html#

4.创建core核心；在任意地方创建文件夹home，把solr5.53下service下solr复制到这个home下，在这里，我创建在Tomcat的bin目录下了，并且修改配置文件Tomcat下的solr下web-inf下web.xml
```xml
    <env-entry>
       <env-entry-name>solr/home</env-entry-name>
       <env-entry-value>C:\solrhome</env-entry-value>
       <env-entry-type>java.lang.String</env-entry-type>
    </env-entry>
```
### 使用
![](微信截图_20181017192037.png)


## solr是什么
学习链接https://www.cnblogs.com/peaceliu/p/7786851.html
```xml
一、Solr它是一种开放源码的、基于 Lucene Java 的搜索服务器，易于加入到 Web 应用程序中。

二、Solr 提供了层面搜索(就是统计)、命中醒目显示并且支持多种输出格式（包括XML/XSLT 和JSON等格式）。它易于安装和配置，而且附带了一个基于 HTTP 的

管理界面。Solr已经在众多大型的网站中使用，较为成熟和稳定。

三、Solr 包装并扩展了 Lucene，所以Solr的基本上沿用了Lucene的相关术语。更重要的是，Solr 创建的索引与 Lucene 搜索引擎库完全兼容。

四、通过对Solr 进行适当的配置，某些情况下可能需要进行编码，Solr 可以阅读和使用构建到其他 Lucene 应用程序中的索引。

五、此外，很多 Lucene 工具（如Nutch、 Luke）也可以使用Solr 创建的索引。可以使用 Solr 的表现优异的基本搜索功能，也可以对它进行扩展从而满足企业的需要。
```
