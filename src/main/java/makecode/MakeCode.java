package makecode;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MakeCode {
    public static void main(String[] args) {

        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("generatorConfig.xml");//建议放到src下面，或者使用绝对路径
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = null;
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = null;
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("生成完成-OK!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}