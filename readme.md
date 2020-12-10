   
    /**
     * 调用示例一
     */
    @Autowired
    DemoService demoService;
    @Autowired
    HldService hldService;
    
    //读取客户端配置
    @GetMapping("/starter")
    public R starterTest(){
        return R.ok(demoService.say());
    }

    //读取sdk配置
    @GetMapping("/etl")
    public R etl(){
        return R.ok(demoService.etlParams());
    }
     /**
       * 调用示例二
       * 调用子类特有方法 需要父类强转子类才能调用
       */
    String result = ((ProcessInstall)ScheduleFactory.getFactory("etl").createImplementation("demoService")).etlParams();
    
    
    客户端配置参考：
    yss:
        datamiddle:
            sdk: 
                #token
                token: 19d18ee4fde86febfad0a72b67715d74
                #etl服务ip
                ip: 192.168.100.xxx
                #etl服务port
                port: 8080  
            email:
                host: smtp.qq.com
                port: 25
                username: xxx@qq.com
                password: xxx   
                 
    