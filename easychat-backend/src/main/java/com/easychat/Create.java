package com.easychat;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class Create {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/easychat?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("cxj") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("C:\\Users\\Meng_fan\\Desktop\\easychat\\easychat-backend\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com") // 设置父包名
                                .moduleName("easychat") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\Meng_fan\\Desktop\\easychat")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("user_info") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
