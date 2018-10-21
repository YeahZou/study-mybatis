# study-mybatis
项目注意事项：  
1、配置文件存放的位置不同，读取方式不同，跟类的加载机制有关？classpath？  
2、mybatis的配置文件中，configuration节点内的子节点有顺序，若顺序不对，报错：元素类型为 "configuration" 的内容必须匹配 "(properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,plugins?,environments?,databaseIdProvider?,mappers?)"，确保子节点出现顺序与报错内容中的顺序一致。
3、maven默认不会编译src/java目录的xml文件，需在pom文件中增加如下内容：  
```
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
</build>
```
