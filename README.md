# IF
本自动化测试框架结构：Java+Maven+selenium
\IF\src\main\java\com\atf
通过Init类初始化环境变量；
创建Interface接口，公共键以及浏览器动作封装调用；
PageElements中管理浏览器相关动作，包括：
  1.动作的公共类调用
  2.各种浏览器操作封装
  3.Excel数据驱动封装
  4.判断Excel输入的元素属性
  5.Excel数据连接
  6.初始化环境，启动浏览器驱动，杀进程
  7.获取输入值
  8.公共键，截图，以及时间格式化

