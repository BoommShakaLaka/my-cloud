# MyCloud

#### 介绍
springcloudalibaba

#### 软件架构
软件架构说明


#### 环境安装教程

###### mysql
docker启动增加环境变量，指定用户名密码
###### nacos 单例模式启动
``` shell
docker run --name my_nacos -e MODE=standalone -p 8848:8848 -d zhusaidong/nacos-server-m1:2.0.3
```
###### 启动kafka 编排
编写docker-compose.yml文件，并执行(/env/docker-compose.yml)
```yaml
version: '3'
services:
  zookeeper:
    image: zookeeper
    ports:
      - "2181:2181"
    restart: always

  kafka:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
    restart: always
```
``` shell
docker-compose up -d
```

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
