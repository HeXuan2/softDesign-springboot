package com.hexuan.supermarketspringboot;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author hexuan
 * @Date 2023/9/3 16:09
 * @PackageName:com.hexuan.elmboot
 * @ClassName: CodeGenerater
 * @Description: TODO
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String url="jdbc:mysql:///supermarket";
        String username="root";
        String password="123456";
        String moduleName="supermarket";
        String mapperLocation="D:\\大学学习资料\\大三上\\软件设计与体系结构\\大作业\\" +
                "后端springboot\\supermarketSpringboot\\src\\main\\resources\\mapper"+moduleName;
        String tables="business,deliveryaddress,item,lineitem,orders,user,shop,shopitem";

        FastAutoGenerator.create(url,username, password)
                .globalConfig(builder -> {
                    builder
                               .author("hexuan") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\大学学习资料\\大三上\\软件设计与体系结构\\大作业\\" +
                                    "后端springboot\\supermarketSpringboot\\src\\main\\java"); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder
                            .parent("com.hexuan") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
