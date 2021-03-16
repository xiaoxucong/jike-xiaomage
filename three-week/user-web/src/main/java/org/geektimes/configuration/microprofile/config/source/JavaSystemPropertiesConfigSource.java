package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/****
 * org.eclipse.microprofile.config.spi.ConfigSource
 * 实现，包括 OS 环境变量，以及本地配置文件
 */
public class JavaSystemPropertiesConfigSource implements ConfigSource {

    /**
     * Java 系统属性最好通过本地变量保存，使用 Map 保存，尽可能运行期不去调整
     * -Dapplication.name=user-web
     */
    private final Map<String, String> properties = new HashMap<>();
    private static   Properties prop = new Properties();
        /*获取本地的配置 获取本地的所有的 properties 文件的配置信息*/
    public JavaSystemPropertiesConfigSource() {
        URL url = ClassLoader.getSystemResource("");
        String path = url.getPath();
        File file = new File(path);

        List<File> files = this.getPropFile(file);

        Map<String, File> map = new HashMap<String, File>();
        for (File item : files) {
            String fileName = item.getName().replace(".properties", "");
            map.put(fileName, item);//去重
            System.out.println(item.getName());

            try {
                FileReader reader = new FileReader(item.getPath());
                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine()) != null) {
                    int index = line.indexOf("=");
                    if (index < 0) {
                        continue;
                    }
                    String name = line.substring(0, index);
                    String val = line.substring(index + 1);
                    properties.put(name, val);
                }
                br.close();
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "Java System Properties";
    }
    public Map<String, String> getLocalAllProperty() {
        return properties;
    }
    public  List<File> getPropFile(File file) {
        List<File> list = new ArrayList<File>();
        File[] files = file.listFiles();
        for (File fileItem : files) {
            if (fileItem.isDirectory()) {
                List<File> items = getPropFile(fileItem);
                list.addAll(items);
            } else if (fileItem.getName().endsWith(".properties")) {
                list.add(fileItem);
            }
        }
        return list;
    }

   //--------------------------------------获取注册表的配置----------------------------


    private final  Preferences prefs = Preferences.userRoot();


        public Map<String,Object> getWinAllProperty() {
            Map<String,Object> map = new HashMap<>();
            try {
                for (String key : prefs.keys()) {
                    Object val = prefs.get(key, null);
                    map.put(key,val);
                }
            } catch (BackingStoreException e) {
                e.printStackTrace();
            }
            return map;
        }
    public Set<String> getWinPropertyNames() {
        Set set=null;

        try {
            String [] keys = prefs.keys();
            set = new HashSet(Arrays.asList(keys));
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }

        return set;
    }


    public String getWinValue(String propertyName) {
        return prefs.get(propertyName,null);
    }


    public String getWinName() {
        String val = "";
        try {
            for (String key : prefs.keys()) {
                val = prefs.get(key, null);
            }
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
        return val;
    }

}
