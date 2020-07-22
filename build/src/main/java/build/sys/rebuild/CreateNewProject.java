package build.sys.rebuild;

import build.tool.BaseFileUtil;
import build.tool.FileStore;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class CreateNewProject {

    public static void main(String[] args) throws Exception {
        CreateUtil util = new CreateUtil();
        File srcFile = new File("E:\\core\\mg");
        File dstFile = new File("E:\\core\\shineon");
        String[] src= new String[]{"mg","Mg","MG"};
        String[] dst= new String[]{"shineon","Shineon","SHINEON"};
        System.out.println("[begin]");
        util.createItem(srcFile,dstFile,src,dst);
        System.out.println("[end]");

        String[] paths =new String[]{"MgApp","knowledge"};

        for(String  path: paths) {
            File f = new File(dstFile, path);
            BaseFileUtil.delete(f);
        }
    }

}
