# woodpecker-tools

## 0x01 简介
`woodpecker-tools`封装了漏洞检测与漏洞利用中常见的操作，让开发者可以使用更少的代码更短的时间编写woodpecker框架插件。

- [ ] 常见类
    - [x] 流操作
    - [x] 文件操作
    - [x] 反射操作
- [ ] 编码类
    - [x] base64编码
    - [x] hex编码
    - [x] Gzip压缩解缩
- [ ] 杂项
    - [x] 随机数生成
    - [x] 序列化与反序列化操作
    - [x] 异常错误处理
    
    
## 0x02 使用
https://mvnrepository.com/artifact/me.gv7.woodpecker/woodpecker-tools

Maven

```xml
<dependency>
  <groupId>me.gv7.woodpecker</groupId>
  <artifactId>woodpecker-tools</artifactId>
  <version>0.1.1</version>
</dependency>
```

Gradle

```
implementation 'me.gv7.woodpecker:woodpecker-tools:0.1.1'
```