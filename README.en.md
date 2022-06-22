# JIL

#### Description

The **JIL**(Java Imaging Library) make image processing easier.

#### Software Architecture

Software architecture description

#### Installation

Add the dependent in your `pom.xml` file.

```xml
<dependency>
    <groupId>cn.psoho</groupId>
    <artifactId>JIL</artifactId>
    <version>0.0.1</version>
</dependency>
```

#### Instructions

The sample code

```java
// open a image
Image img=Image.open("data/store/leo.jpeg");

// show image
img.show();

// save image
img.save("ddd.jpeg");

// change image size
Image newImg=img.resize(200,200);
newImg.show();
```

Move forward a little bit each day.

#### Contribution

1. Fork the repository
2. Create Feat_xxx branch
3. Commit your code
4. Create Pull Request

#### Gitee Feature

1. You can use Readme\_XXX.md to support different languages, such as Readme\_en.md, Readme\_zh.md
2. Gitee blog [blog.gitee.com](https://blog.gitee.com)
3. Explore open source project [https://gitee.com/explore](https://gitee.com/explore)
4. The most valuable open source project [GVP](https://gitee.com/gvp)
5. The manual of Gitee [https://gitee.com/help](https://gitee.com/help)
6. The most popular members  [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
