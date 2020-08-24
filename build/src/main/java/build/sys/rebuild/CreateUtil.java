package build.sys.rebuild;

import build.tool.FileStore;
import build.tool.StringUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class CreateUtil {

    public File getRoot()
    {
        String path =CreateNewNode.class.getResource("/").getPath();
        return new File(path).getParentFile().getParentFile().getParentFile();
    }

    public File getRootBussiness()
    {
        File root = new File(getRoot(),"bussiness");
        return root;
    }

    public File getRootEmpty()
    {
        File root = new File(getRoot(),"atomicEmpty");
        return root;
    }


    public File getSysRoot(String sysType)
    {
        File sysRoot =new File(getRootBussiness(),sysType);
        return sysRoot;
    }

    public File getSysPath(String sysName,String sysType)
    {
        File sysRoot =new File(getRootBussiness(),sysType);
        File sys =new File(sysRoot,String.format("%s.%s",sysType,sysName));
        return sys;
    }

    public File getEmptyPath(String sysType)
    {
        File root =  new File(getRootEmpty(),sysType);
        File emptyFile = new File(root,String.format("%s.eitem",sysType));
        return emptyFile;
    }

    public void createSys(String sysName,String sysType) throws Exception {
        String srcName = "eitem";
        String[] src = {srcName.toLowerCase(),srcName.toUpperCase(), StringUtil.firstUpper(srcName)};
        String[] dst = {sysName.toLowerCase(),sysName.toUpperCase(), StringUtil.firstUpper(sysName)};

        File srcFile = getEmptyPath(sysType);
        File dstFile =  getSysPath(sysName,sysType);

        createItem(srcFile,dstFile,src,dst);
    }

    public void createItem(File srcFile, File dstFile,String[] src,String[] dst) throws Exception {
        if(dstFile.exists())
        {
            throw new Exception(dstFile.getPath() + "目标目录已存在,请检查系统名称，是否正确！！");
        }
        FileUtils.copyDirectory(srcFile,dstFile);

        for(int i=0;i<src.length;i++)
        {
            try {
                replaceName(src[i],dst[i],dstFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void replaceName(String src,String dst,File sysFile) throws Exception {
        if(!sysFile.exists())
        {
            System.out.println(sysFile.getPath() + "系统路径不存在，请检查！！");
            return;
        }

        if(sysFile.isDirectory())
        {
            File[] fs = sysFile.listFiles();

            for(File f :fs) {
                replaceName(src, dst, f);
            }

            if(sysFile.getName().indexOf(src)>=0)
            {
                String dname = sysFile.getName().replace(src,dst);
                FileUtils.moveDirectory(sysFile,new File(sysFile.getParent(),dname));
            }
        }

        if(sysFile.isFile())
        {
            String content =  FileStore.getContent(sysFile);
            content = content.replace(src,dst);
            FileStore.putString(sysFile,content);

            System.out.println(String.format("%s已经替换完成[%s]-->[%s]！",sysFile.getPath(),src,dst ));
        }

        if(sysFile.isFile()&&sysFile.getName().indexOf(src)>=0)
        {
            String fName = sysFile.getName().replace(src,dst);
            FileUtils.moveFile(sysFile,new File(sysFile.getParent(),fName));
        }
    }


}
