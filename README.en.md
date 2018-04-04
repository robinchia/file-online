# file-online-preview

[GitHub license](https://github.com/robinchia/file-online/blob/master/LICENSE)

### Introduction

This robinchia fileonline project is intended to be a solution for previewing documents online. 
It is an open source implementation and released under the Apache License version 2.0. Finally,It is aimed to feedback the community after obtaining the consent of company executives, 
special thanks to  @kekingcn. 

### Features
- Build with the popular frame spring boot
- Easy to build and deploy
- Basically support online preview of mainstream office documents, such as Doc, docx, Excel, PDF, TXT, zip, rar, pictures, etc
- REST API
- Abstract file preview interface so that it is easy to extend more file extensions and develop this project on your own


### Documentation
1. 中文文档：https://github.com/robinchia/file-online/blob/master/README.md
1. English document：https://github.com/robinchia/file-online/blob/master/README.en.md

### Contact us && Join us
> We will answer everyone's questions in use of this project.
And please Google or Baidu first before asking a question, so that we can solve it efficiently. 
Cherish life away from ineffective communication.

QQ：155193753

### Pictures for some samples

### Quick Start
> Technology stack
- Spring boot
- Freemarker
- Redisson 
- Jodconverter
> Dependencies
- Redis 
- OpenOffice or LibreOffice

1. First step：`git pull https://github.com/robinchia/file-online.git`

2. Second step：configure redis address and OpenOffice directory，such as
```
#=============================================#Spring Redisson Configuration#===================================#
spring.redisson.address = redis:\\192.168.27.68:6379
##The folder for files which are uploaded to the server(Because of running as jar)
file.dir =  /home/robin/Desktop/dev/
## openoffice configuration
office.home = /opt/openoffice4

```
'file.dir' is the real storage address of the converted files, please end with '/'.

3. Third step：Run the command mvn clean package, then come into target and run java -jar file-online-1.0.jar.After starting,visit `http://localhost:8012/`.

### Changelog

> April 3th 2018

1. refactor and  replace jodconverter-core version, and use jodconverter 4.2.0.
2. update dependencies: commons-io - > 2.6, fr.opensagres.xdocreport - > 1.0.6 , redisson - > 3.5.7 ,POI- > 3.17
3. update the web plug-in plyr->3.0.3
4. update the versions of JQuery, Ztree, and so on
5. complete Java internationalization support (JS  is not completed)

### Usage
If this project is helpful for you, this project helps you to economize the service charge for preview of documents, as well as you are willing to support us, click 【donate】 below to donate a cup of coffee, we would appreciate it.

### License

[APACHE](https://github.com/robinchia/file-online/blob/master/LICENSE)
