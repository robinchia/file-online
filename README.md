# file-online-preview
此项目为文件文档在线预览项目解决方案。该项目使用流行的spring boot搭建，易上手和部署，基本支持主流办公文档的在线预览，如doc,docx,Excel,pdf,ppt,txt,zip,rar,图片等等。
在此特别感谢kekingcn,我参考了的项目[kkFileView](https://github.com/kekingcn/kkFileView)，在此特别注明！Thanks！也因此将项目开源出来反哺社区。
### 项目特性

1. 支持office(doc,docx,ppt,pptx,excel)，pdf等办公文档
1. 支持txt,java,php,py,md,js,css等所有纯文本
1. 支持zip,rar,jar,tar,gzip等压缩包
1. 支持jpg，jpeg，png，gif等图片预览（翻转，缩放，镜像）
1. 支持mp3、mp4视频文件预览
1. 使用spring boot开发，预览服务搭建部署非常简便
1. rest接口提供服务，跨平台特性(java,php,python,go,php，....)都支持，应用接入简单方便
1. 抽象预览服务接口，方便二次开发，非常方便添加其他类型文件预览支持
1. 最最重要Apache协议开源，代码pull下来想干嘛就干嘛


### 项目文档（Project documentation）
1. 中文文档：https://github.com/robinchia/file-online/blob/master/README.md
1. English document：https://github.com/robinchia/file-online/blob/master/README.en.md

### 联系我
> 有重要问题可以联系我

QQ：155193753


### 快速开始
> 项目使用技术
- spring boot
- freemarker
- redisso
- jodconverter
> 依赖外部环境
- redis 
- OpenOffice或者LibreOffice

1. 第一步：pull项目https://github.com/robinchia/file-online.git

2. 第二步：配置redis地址和OpenOffice目录，如
```
#====================#spring Redisson配置#===========#
spring.redisson.address = redis:\\192.168.27.68:6379
##资源映射路径(因为jar方式运行的原因)
file.dir = /home/robin/Desktop/dev/
## openoffice相关配置
office.home = /opt/openoffice4

```
file.dir为转换文件实际存储地址，注意要以/结尾

3. 第三步：运行mvn clean package，进入target目录执行:java -jar file-online-1.0.jar ，服务启动后，访问http://localhost:8012/

### 历史更新记录

> 2018年04月03日 ：

1. 重构项目，更换jodconverter-core版本，使用jodconverter 4.2.0
2. 更新依赖包 commons-io -> 2.6 、 fr.opensagres.xdocreport -> 1.0.6 poi -> 3.17  redisson -> 3.5.7
3. 更新web插件plyr->3.0.3
4. 更新JQuery、Ztree等版本
5. 完成java国际化支持(js部分未完成)


### 使用
如果这个项目解决了你的实际问题，节省了你的三方预览服务费用，也愿意支持下的话，可点击下方【捐助】请作者喝杯咖啡，也是非常感谢

### 许可

[APACHE](https://github.com/robinchia/file-online/blob/master/LICENSE)