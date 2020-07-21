package build.sys.rebuild;

public class CreateNewWebsite {
    public static void main(String[] args) throws Exception {
        CreateUtil util = new CreateUtil();
        util.createSys("vms","website");
    }
}
