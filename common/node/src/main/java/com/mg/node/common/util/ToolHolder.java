package com.mg.node.common.util;

import com.mg.node.common.config.DaoConfiguration;

public class ToolHolder {

    public static DaoUtils daoUtils = new DaoConfiguration().daoUtilsBean();

}
