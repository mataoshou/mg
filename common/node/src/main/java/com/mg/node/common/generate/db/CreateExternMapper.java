package com.mg.node.common.generate.db;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.DBConstant;

import java.io.IOException;

public class CreateExternMapper extends ICreate {


    public CreateExternMapper(String name) {
        super(name, null);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent( String.format(" List<%s> list(@Param(\"where\") String where,@Param(\"order\") String order);", this.getName()));
        unit.addPreContent("\r");
        unit.addPreContent( String.format(" %s selectByName(String name);", this.getName()));
        unit.addPreContent("\r");
        unit.addPreContent( String.format(" %s get(@Param(\"where\") String where);", this.getName()));
        unit.addPreContent("\r");
        unit.addPreContent( String.format(" int insertByCustomId(%s item);", this.getName()));
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{
                "java.util.List","org.apache.ibatis.annotations.Param",
                DBConstant.DB_POJO_PACKAGE+"." +this.getName()
        });

        unit.setType(2);
    }

    @Override
    protected String getPackageName() {
        return DBConstant.DB_MAPPER_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"ExternMapper";
    }
}
