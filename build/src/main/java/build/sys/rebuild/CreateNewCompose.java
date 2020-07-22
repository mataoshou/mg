package build.sys.rebuild;

public class CreateNewCompose {
    public static void main(String[] args) throws Exception {
        CreateUtil util = new CreateUtil();
        util.createSys("auth","compose");
    }
}
