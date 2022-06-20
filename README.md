# JIL

#### 介绍

JIL(Java Imaging Library) 让图像处理更简单

#### 软件架构

基于 `Graphics2D` 和 `BufferedImage`，API设计参考 [Pillow](https://pillow.readthedocs.io/en/latest/index.html) (一个Python图像处理库)

#### 安装教程

在`pom.xml`文件中添加依赖

```xml
<dependency>
    <groupId>cn.psoho</groupId>
    <artifactId>JIL</artifactId>
    <version>0.0.1</version>
</dependency>
```

#### 使用说明

示例代码

```java
// 打开图片
Image img = Image.open("data/store/leo.jpeg");

// 显示图片
img.show();

// 保存图片
img.save("ddd.jpeg");

// 调整图片尺寸
Image newImg = img.resize(200, 200);
newImg.show();
```

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
