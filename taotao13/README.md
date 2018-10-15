# SSM-SOA
## 第六天：solr

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

## solr是什么
```xml
一、Solr它是一种开放源码的、基于 Lucene Java 的搜索服务器，易于加入到 Web 应用程序中。

二、Solr 提供了层面搜索(就是统计)、命中醒目显示并且支持多种输出格式（包括XML/XSLT 和JSON等格式）。它易于安装和配置，而且附带了一个基于 HTTP 的

管理界面。Solr已经在众多大型的网站中使用，较为成熟和稳定。

三、Solr 包装并扩展了 Lucene，所以Solr的基本上沿用了Lucene的相关术语。更重要的是，Solr 创建的索引与 Lucene 搜索引擎库完全兼容。

四、通过对Solr 进行适当的配置，某些情况下可能需要进行编码，Solr 可以阅读和使用构建到其他 Lucene 应用程序中的索引。

五、此外，很多 Lucene 工具（如Nutch、 Luke）也可以使用Solr 创建的索引。可以使用 Solr 的表现优异的基本搜索功能，也可以对它进行扩展从而满足企业的需要。
```
