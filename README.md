# sping-cloud
学习地址：http://blog.didispace.com/categories/Spring-Cloud/
部署和安装参考地址：https://lazycece.github.io/2019/03/22/ubuntu%E4%B8%8Bnacos%E5%8D%95%E6%9C%BA%E9%83%A8%E7%BD%B2%E5%AE%89%E8%A3%85/
部署常见问题汇总：http://blog.didispace.com/nacos-faqs/


下载地址：https://github.com/alibaba/Sentinel/releases
通过命令启动：java -jar sentinel-dashboard-1.6.0.jar 
默认端口访问地址：http://localhost:8080  默认用户名和密码都是：sentinel
可以通过启动命令修改信息：
如修改端口：java -jar sentinel-dashboard-1.6.0.jar -Dserver.port=8888
-Dsentinel.dashboard.auth.username=sentinel: 用于指定控制台的登录用户名为 sentinel；
-Dsentinel.dashboard.auth.password=123456: 用于指定控制台的登录密码为 123456；如果省略这两个参数，默认用户和密码均为 sentinel
-Dserver.servlet.session.timeout=7200: 用于指定 Spring Boot 服务端 session 的过期时间，如 7200 表示 7200 秒；60m 表示 60 分钟，默认为 30 分钟；


在程序上加上配置（生产端）
# sentinel dashboard
spring.cloud.sentinel.transport.dashboard=localhost:8080
