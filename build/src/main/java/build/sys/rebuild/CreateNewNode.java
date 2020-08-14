package build.sys.rebuild;

public class CreateNewNode {

    public static void main(String[] args) throws Exception {
        CreateUtil util = new CreateUtil();
        util.createSys("user","node");
    }
}
