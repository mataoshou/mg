package com.mg.node.common.generate.db;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.DBConstant;

import java.io.IOException;

public class CreateMergeMapper extends ICreate {


    public CreateMergeMapper(String name) {
        super(name, null);
    }



    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addImport(new String[]{
                DBConstant.DB_MAPPER_PACKAGE +"."+this.getName2() +"BaseMapper",
                DBConstant.DB_MAPPER_PACKAGE +"."+this.getName2() +"ExternMapper"
        });
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImplement(this.getName2() +"BaseMapper");
        unit.addImplement(this.getName2() +"ExternMapper");

        unit.setType(2);
    }

    @Override
    protected String getPackageName() {
        return DBConstant.DB_MERGEDAO_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return "I" + StringUtil.firstUpper(name) +"Mapper";
    }

}
