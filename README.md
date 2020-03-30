# jmq

a lightweight message queue  inspired by youzan

<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]




<!-- PROJECT LOGO -->
<br />

<p align="center">
  <a href="https://github.com/shaojintian/jmq/">
    <img src="docs/images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Best-README-Template</h3>
  <p align="center">
    An awesome README template to jumpstart your projects!
    <br />
    <a href="https://github.com/shaojintian/jmq"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/shaojintian/jmq"> View Demo</a>
    ·
    <a href="https://github.com/shaojintian/jmq/issues">Report Bug</a>
    ·
    <a href="https://github.com/shaojintian/jmq/issues">Request Feature</a>
  </p>

</p>

 本篇README.md面向开发者 

# 🚀 功能

- [x] 一种带有延迟功能的消息队列

<a href="https://github.com/shaojintian/jmq/">
    <img src="docs/images/delay-queue.png" alt="Logo" width="80" height="80">
</a>



## 目录

- [上手指南](#上手指南)
  - [开发前的配置要求](#开发前的配置要求)
  - [安装步骤](#安装步骤)
- [文件目录说明](#文件目录说明)
- [开发的架构](#开发的架构)
- [部署](#部署)
- [使用到的框架](#使用到的框架)
- [核心设计💡](#核心设计)
- [性能测试📊](#性能测试)
- [贡献者](#贡献者)
  - [如何参与开源项目](#如何参与开源项目)
- [版本控制](#版本控制)
- [作者](#作者)
- [赞助❤](#赞助)
- [鸣谢](#鸣谢)

### 上手指南



###### 开发前的配置要求

1. java1.8
2. springboot
3. idea

###### **安装步骤**

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo

```sh
git clone https://github.com/shaojintian/jmq.git
```

### 文件目录说明

eg:
/src/
```
├── /main/
│  ├── .DS_Store
│  ├── /java/
│  │  ├── .DS_Store
│  │  ├── /com/
│  │  │  ├── /sjt/
│  │  │  │  ├── /jmq/
│  │  │  │  │  ├── JmqApp.java
│  │  │  │  │  ├── /core/
│  │  │  │  │  │  ├── DelayBucket.java
│  │  │  │  │  │  ├── DelayBucketHandler.java
│  │  │  │  │  │  ├── DelayQueue.java
│  │  │  │  │  │  ├── DelayQueueJob.java
│  │  │  │  │  │  ├── DelayQueueJobPool.java
│  │  │  │  │  │  ├── ReadyQueue.java
│  │  │  │  │  │  └── ScoredSortedItem.java
│  │  │  │  │  ├── /dto/
│  │  │  │  │  ├── /exception/
│  │  │  │  │  ├── /listener/
│  │  │  │  │  │  └── ApplicationStartup.java
│  │  │  │  │  ├── /util/
│  │  │  │  │  │  └── RedissonUtil.java
│  ├── /resources/
│  │  ├── application.yaml
│  │  ├── log4j.properties
│  │  └── redis.yaml

```



### 开发的架构 

请阅读[ARCHITECTURE.md](https://github.com/shaojintian/jmq/blob/master/ARCHITECTURE.md) 查阅为该项目的架构。

### 部署

暂无

### 使用到的框架

- [Redisson](https://redisson.org/)



## 💡核心设计

1. xxxxx
2. xxxxx
3. xxxxx

## 📊性能测试

 1. xxxxx
 2. xxxxx


### 贡献者

请阅读**CONTRIBUTING.md** 查阅为该项目做出贡献的开发者。

#### 如何参与开源项目

贡献使开源社区成为一个学习、激励和创造的绝佳场所。你所作的任何贡献都是**非常感谢**的。

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



### 版本控制

该项目使用Git进行版本管理。您可以在repository参看当前可用版本。

### 作者

E-mail: sjt@hnu.edu.cn

知乎:[笃行er](https://www.zhihu.com/people/sjt_ai/activities)  &ensp; qq:1075803623    

 *您也可以在贡献者名单中参看所有参与该项目的开发者。*

### 版权说明

该项目签署了MIT 授权许可，详情请参阅 [LICENSE.txt](https://github.com/shaojintian/jmq/blob/master/LICENSE.txt)

### 鸣谢

- [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
- [Img Shields](https://shields.io)
- [Choose an Open Source License](https://choosealicense.com)
- [GitHub Pages](https://pages.github.com)
- [Animate.css](https://daneden.github.io/animate.css)
- [xxxxxxxxxxxxxx](https://connoratherton.com/loaders)

### 赞助

If you like this project and want to sponsor the author, you can reward the author using Wechat or Alipay by scanning the following QR code.

<figure class="half">
  <img src="docs/images/reward_wechat.png" width="200" height="260"/>
  <img src="docs/images/reward_alipay.png" width="200" height="260"/>
</figure>
<!-- links -->

[your-project-path]: shaojintian/jmq
[contributors-shield]: https://img.shields.io/github/contributors/shaojintian/jmq.svg?style=flat-square
[contributors-url]: https://github.com/shaojintian/jmq/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/shaojintian/jmq.svg?style=flat-square
[forks-url]: https://github.com/shaojintian/jmq/network/members
[stars-shield]: https://img.shields.io/github/stars/shaojintian/jmq.svg?style=flat-square
[stars-url]: https://github.com/shaojintian/jmq/stargazers
[issues-shield]: https://img.shields.io/github/issues/shaojintian/jmq.svg?style=flat-square
[issues-url]: https://img.shields.io/github/issues/shaojintian/jmq.svg
[license-shield]: https://img.shields.io/github/license/shaojintian/jmq.svg?style=flat-square
[license-url]: https://github.com/shaojintian/jmq/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/shaojintian