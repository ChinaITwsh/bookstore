# bookstore
网上书城售卖系统
该项目所设计的系统为基于Web的图书售卖系统的设计与实现，网站的浏览者可以浏览每一个图书的信息，通过注册和登陆购买图书，可以查看自己的购物车和订单。
项目负责：

1、项目底层框架是Servlet的基础MVC框架，采用多处理Servlet，通过自己定义的代理类和监听器实现Model-View-Controller的分类，框架的实现均有自己独自设计完成。

2、采用c3p0数据库动态连接池，由MySQL数据库提供数据支持。

3、Jsp页面采用tag/jstl标签实现各种功能，通过el表达式实现Java代码与Jsp代码之间值的传递。手写Jsp页面的css代码，用了一点点JavaScript技术。

4、用MD5加密方法将用户的密码进行加密存储。